package gov.pnnl.aristotle.utils

import java.io.PrintWriter
import java.io.File
import scala.io.Source
import util.control.Breaks._
import scala.collection.mutable.HashMap
import scala.collection.immutable.SortedMap
import org.apache.spark.graphx.Graph
import java.util.ArrayList

object GetYagoPredicates {

  def getPredicateArrayList(filename: String): ArrayList[String] ={
       
    val predicateMap = new HashMap[Int,String]();
  	  for (line <- Source.fromFile(filename).getLines()) {
        if (line.startsWith("@") || line.startsWith("#") || line.isEmpty() ) { ; }
        else {
          val line2 = line.substring(0, line.lastIndexOf("."));
          val linearray = line2.split("\\t");
          val sorted = SortedMap(predicateMap.toSeq:_*)
          predicateMap.put(linearray(0).hashCode(), linearray(0));
        }
    }
  	
  	val result = new ArrayList[String]();
  	predicateMap.toList.sortBy(_._2).foreach(f => {
  	  result.add(f._2);
  	})
  
    return result;
  }
  
  def printPredicateList(filename:String):Unit ={
    val writer = new PrintWriter(new File("yagoPredicateFromSchema.ttl"))
    val predicateArrayList = getPredicateArrayList(filename);

    val predItr = predicateArrayList.iterator();
    while (predItr.hasNext()) {
      writer.println(predItr.next())
    }
    writer.flush();
  }
  
  def main(args: Array[String]): Unit = {
		  printPredicateList(args(0))
  
  }
}