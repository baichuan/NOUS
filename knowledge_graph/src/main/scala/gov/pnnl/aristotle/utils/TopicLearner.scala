package gov.pnnl.aristotle.utils


import scala.io.Source
import org.apache.spark._
import org.apache.spark.rdd._
import org.apache.spark.graphx.Graph
import scala.collection.mutable.HashMap
import scala.collection.mutable.Map
import java.io._
import org.apache.log4j.Logger
import org.apache.log4j.Level

class nodeWithAllTopics[T](dataTemp: T, topicTemp: Array[Double]) {
  val data: T = dataTemp
  val topic = topicTemp
} 
  
class nodeWithTopKTopics[T](dataTemp: T, topicTemp: Array[(Int, Double)] ) {
  val data: T = dataTemp
  val topic = topicTemp
}
  
object TopicLearner {
  def isValidLine(ln : String) : Boolean ={
    ( (ln.startsWith("@") ==false) && (ln.startsWith("#")==false) && (ln.isEmpty()==false))
  }
   
  def main(args: Array[String]): Unit = {     
    val sparkConf = new SparkConf().setAppName("get yago topics").setMaster("local")
    val sc = new SparkContext(sparkConf)
    Logger.getLogger("org").setLevel(Level.OFF)
    Logger.getLogger("akka").setLevel(Level.OFF)
    System.setProperty("hadoop.home.dir", "C:\\fake_hadoop\\")
    println("starting from main")
    if(args.length < 5 || args.length > 6) {
      println("Usage <tac_label_to_id_file> <tacid_to_lda_docid_file> <lda_docid_topic_distr_file(s)> <numTopics> <outputFile(yagoLabel:<top_10_topic_id, weight>)> <threshold to drop topic, default=0.005> ")
      exit
    } 
    var threshold = 0.005
    if(args.length == 6){ threshold = args(5).toDouble}
    CreateYagoTopics(args(0), args(1), args(2), args(3).toInt , args(4), threshold, sc)
    //val allEntityTopics = getYagoTopicsRDDTopK(args(4)+".topk.out", sc)
    //val entityTopics = allEntityTopics.first
    //println(entityTopics._1 + "-->(" + entityTopics._2(0)._1 + "," + entityTopics._2(0)._2  +")" )
  }
  
  
  def getYagoTopicsRDDTopK(topicsFile: String, sc: SparkContext) : RDD[(Long, Array[(Int, Double)] )] = {
    
    val topicsStringRDD: RDD[String] = sc.textFile(topicsFile)
    val topicsRDD: RDD[(Long, Array[(Int, Double)] )] = topicsStringRDD.filter(isValidLine(_)).map{v =>
      val arr: Array[String] = v.split(" ; ")
      if(arr.length < 2){
        println(" No topic found in line", v)
        exit
      } 
      val yagoLabel = arr(0).replaceAllLiterally("<", "").replaceAllLiterally(">", "")
      val topicsDistString = arr.drop(1)
      val topicDist: Array[(Int, Double)]  = topicsDistString.map{topic => 
        val topicIdWithWeight = topic.replaceAllLiterally("<", "").replaceAll(">", "").split(",")
        if(topicIdWithWeight.length != 2){
           println(" No topic of and weight found", topic)
           exit
        }
        (topicIdWithWeight(0).toInt,topicIdWithWeight(1).toDouble)
      }
      (yagoLabel.hashCode().toLong, topicDist)
    }
    return topicsRDD
  } 
  
  def getYagoTopicsRDDAll(topicsFile: String, sc: SparkContext) : RDD[(Long, Array[Double])] = {
    
    val topicsStringRDD: RDD[String] = sc.textFile(topicsFile)
    val topicsRDD: RDD[(Long, Array[Double] )] = topicsStringRDD.filter(isValidLine(_)).map{v =>
      val arr: Array[String] = v.split(" ; ")
      if(arr.length < 2){
        println(" No topic found in line", v)
        exit
      } 
      val yagoLabel = arr(0).replaceAllLiterally("<", "").replaceAllLiterally(">", "")
      val topicsDistString = arr.drop(1)
      val cleanedTopicWeights: Array[Double] = topicsDistString.map(v => v.replaceAll("<", "").replaceAll(">", "").toDouble)
      (yagoLabel.hashCode().toLong, cleanedTopicWeights)
    }
    return topicsRDD
  } 
  
     
  // Adds topic distribution Array(topicid, topic strength) to each node ( topic id start from 1)
  // adds (topicid=-1, strength =1.0) for nodes that have no known topic distributions
   def addTopicsToGraphTopK[VD, ED](graph: Graph[VD, ED], topicsFileTopK: String, sc: SparkContext) : 
   Graph[nodeWithTopKTopics[VD], ED] = {
     val topicsRDD : RDD[ (Long, Array[(Int, Double)])]= getYagoTopicsRDDTopK(topicsFileTopK, sc)
     val graphWithTopics: Graph[nodeWithTopKTopics[VD], ED] = graph.outerJoinVertices(topicsRDD) {  
           case (vertexid, vertexData, Some(topic)) => new nodeWithTopKTopics[VD](vertexData, topic)
           // for vertices without topics , add (topicid=-1, weight=1)
           case (vertexid, vertexData, None) => new nodeWithTopKTopics[VD](vertexData, Array((-1, -1.0)))           
     }
     return  graphWithTopics
   }
  
   // Adds topic distribution Array(topicid, topic strength) to each node ( topic id start from 1)
  // adds (topicid=-1, strength =1.0) for nodes that have no known topic distributions
   def addTopicsToGraphAll[VD, ED](graph: Graph[VD, ED], topicsFileAll: String, sc: SparkContext) : 
   Graph[nodeWithAllTopics[VD], ED] = {
     val topicsRDD : RDD[(Long, Array[Double])]= TopicLearner.getYagoTopicsRDDAll(topicsFileAll, sc)
     val graphWithTopics = graph.outerJoinVertices(topicsRDD) {  
           case (vertexid, vertexData, Some(topic)) => new nodeWithAllTopics[VD](vertexData, topic)
           // for vertices without topics , add (topicid=-1)
           case (vertexid, vertexData, None) => new nodeWithAllTopics[VD](vertexData, Array(-1.0))           
     }
     return  graphWithTopics
   }
  
  
  /* REad all mapping files containing:
   * INPUT1 -> Mapping of tac_file---> tac_label
   * INPUT2 -> Mapping of lda_doc_id -> tac_file_paths
   * INPUT3 -> lda_doc_id -> topic distributions (generated by graphlab)
   * INPUT4 -> numTopics
   * generates:
   * OUTPUT -> writes to outputfile
   * <yago_label> <sorted_topics_with_weights_lessThan_threshold>
   * e.g 
   * <Apple_Inc> <100, 0.77> < <121, .33>
   * => Apple_Inc is related to topic id 100 with weight 0.77
   * and related to topic id 121 with weight .33 
   */
  def CreateYagoTopics(tacFileNameToYagoLabelFile: String, tacFileNameToLdaIdFile: String, ldaIdTopicDistFile: String, numTopics: Int, 
      outputFile: String, threshold:Double, sc:SparkContext) : Unit = {
    
    // 1. Get mapping of TAC_Doc_Ids to TAC_Labels
    // Convert TAC_Labels to Yago_Labels
    val tacFileToYagoLabelMap = TAC_Utils.ReadEntityIdLabelFile(tacFileNameToYagoLabelFile).mapValues(v => v.replace(' ', '_'))
    println(tacFileToYagoLabelMap.head)
    
    // 2. Get Mapping of LDA_Doc_Ids tp TAC_Doc_Ids
    // Use output from step 1, to find
    // Array([LDA_Doc_Id] -> Yago_Label)
    val ldaIdToYagoLabel : Array[String] = GetLDAIdToYagoLabelMapping(tacFileNameToLdaIdFile, tacFileToYagoLabelMap)
    
    //3. Read Topic Distributions calculated from graphlab for each LDA_Doc_Id
    // First Create following Output for each TAC documents 
    // Array([lda_doc_id] -> String(topic_id, topic_normalized_weight))
    // Use output from Step 2. to create file containing following on each line:
    // <Yago_Label> ; <ListTopX(topic_id , topic_normalized_weight)>
    // not : Topic list separator is ';'
    println("Done, getting tac id to lda id, Reading lda topic distributions", ldaIdToYagoLabel(1))
    //Note that lda_doc_Id start from id=1, using space filler at  index 0
    var i = 1
    //val size = ldaIdToYagoLabel.size
    val size = 51079
    val tacLabelTopicDistTopK = new Array[String](size +1)
    val tacLabelTopicDistAll = new Array[String](size +1)
    tacLabelTopicDistAll(0) = ""
    tacLabelTopicDistTopK(0) = "" 
    for(line<- Source.fromFile(ldaIdTopicDistFile).getLines()) {
      if(isValidLine(line)){
    
    	  val arr = line.split("\t")
    	  if(arr.length != numTopics+1) {
    		println("the number of columns in this line is not correct", line)
    		exit
    	  }
    	  val ldaDocId = arr(0).toInt
    	  val topicCounts: Array[Int] = arr.drop(1).map(v => v.toInt)
    	  val topicCountsSum: Int = topicCounts.reduce((v1, v2) => v1 +v2)
    	  
    	  val normalizedTopicsAll = topicCounts.map(v=> (v.toDouble)/topicCountsSum).map(_.toString).reduce((v1, v2) => v1 + " ; " + v2)
    	  
    	  val mappedTopicCounts: Array[(Int, Double)] = new Array(numTopics)
    	  for(i <- 0 until numTopics){ 
    	    mappedTopicCounts(i) = (i, topicCounts(i).toDouble)
    	  }
    	  val sortedTopics = mappedTopicCounts.sortBy(_._2)
    	  val normalizedTopics: Array[(Int, Double)] = sortedTopics.map(v => (v._1, v._2/topicCountsSum))
    	  val normalizedTopicsTopK = normalizedTopics.dropWhile(_._2 <= threshold)
    	  val topicStringArrayTopK = normalizedTopicsTopK.map(topic => "<" + topic._1.toString + "," + topic._2.toString + ">").reverse
    	  val topicsStringTopK: String = topicStringArrayTopK.reduce((v1, v2) => v1 + " ; " + v2)
    	  if(ldaDocId >= ldaIdToYagoLabel.size){
    	    println(" There is document in TAC with id", ldaDocId)
    		exit
    	  }
    	  tacLabelTopicDistTopK(i) = "<" + ldaIdToYagoLabel(ldaDocId) + "> ; " + topicsStringTopK
    	  tacLabelTopicDistAll(i) = "<" + ldaIdToYagoLabel(ldaDocId) + "> ; " + normalizedTopicsAll
    	  //println(tacLabelTopicDist(i))
    	  i += 1  
      }
    }
    
    sc.makeRDD(tacLabelTopicDistTopK).saveAsTextFile(outputFile+".topk.out")
    sc.makeRDD(tacLabelTopicDistAll).saveAsTextFile(outputFile+".all.out")
    println("done calculating data", tacLabelTopicDistAll.size)   
  }
  
  /* given file containing 
   * INPUT:  File (line_number(=lad_doc_id) ----> tac document name)
   * INPUT: Map(tac document name -> yago label)
   * returns an Array containing
   * OUTPUT : Array[i=lda_doc_id] ----> yago_label
   */
  def GetLDAIdToYagoLabelMapping(ldaIdToTacFile: String, tacFileToYagoLabelMap: scala.collection.Map[String, String]): Array[String] = { 
   val numDocs = tacFileToYagoLabelMap.size
   
   // Note that the LDA document ids start from 1  , so we will start the values from subscript 1 
   // as in array[doc_id] = "tac_file_namae" 
   var i = 1
   val tacIdToLdaIdArray  = new Array[String](numDocs+1)
   tacIdToLdaIdArray(0) = ""
    for( line <- Source.fromFile(ldaIdToTacFile).getLines){
    val arr = line.split("/")
    val tacFilePath = arr.last
    val tacFileName = tacFilePath.substring(0,8)
    if(!tacFileToYagoLabelMap.contains(tacFileName)){
      print(" Could not find tac label for lda document = " + i +  ", tacFile" + tacFileName)
      exit
    }
    val yagoLabel = tacFileToYagoLabelMap(tacFileName)
    tacIdToLdaIdArray(i) = yagoLabel
    i += 1
   }
    return tacIdToLdaIdArray
  }
  
  
}