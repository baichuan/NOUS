/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package gov.pnnl.aristotle.aiminterface;  


@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ShyrePiersLOBMessage extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ShyrePiersLOBMessage\",\"namespace\":\"gov.pnnl.aristotle.aiminterface\",\"fields\":[{\"name\":\"company\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"lob\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"score\",\"type\":\"double\"},{\"name\":\"expectedCount\",\"type\":\"long\"},{\"name\":\"examplarCompany\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"probability\",\"type\":\"double\"},{\"name\":\"highScore\",\"type\":\"boolean\"},{\"name\":\"isHighScore\",\"type\":\"boolean\"},{\"name\":\"hscodes\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}},{\"name\":\"recordids\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.String company;
  @Deprecated public java.lang.String lob;
  @Deprecated public double score;
  @Deprecated public long expectedCount;
  @Deprecated public java.lang.String examplarCompany;
  @Deprecated public double probability;
  @Deprecated public boolean highScore;
  @Deprecated public boolean isHighScore;
  @Deprecated public java.util.List<java.lang.String> hscodes;
  @Deprecated public java.util.List<java.lang.String> recordids;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public ShyrePiersLOBMessage() {}

  /**
   * All-args constructor.
   */
  public ShyrePiersLOBMessage(java.lang.String company, java.lang.String lob, java.lang.Double score, java.lang.Long expectedCount, java.lang.String examplarCompany, java.lang.Double probability, java.lang.Boolean highScore, java.lang.Boolean isHighScore, java.util.List<java.lang.String> hscodes, java.util.List<java.lang.String> recordids) {
    this.company = company;
    this.lob = lob;
    this.score = score;
    this.expectedCount = expectedCount;
    this.examplarCompany = examplarCompany;
    this.probability = probability;
    this.highScore = highScore;
    this.isHighScore = isHighScore;
    this.hscodes = hscodes;
    this.recordids = recordids;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return company;
    case 1: return lob;
    case 2: return score;
    case 3: return expectedCount;
    case 4: return examplarCompany;
    case 5: return probability;
    case 6: return highScore;
    case 7: return isHighScore;
    case 8: return hscodes;
    case 9: return recordids;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: company = (java.lang.String)value$; break;
    case 1: lob = (java.lang.String)value$; break;
    case 2: score = (java.lang.Double)value$; break;
    case 3: expectedCount = (java.lang.Long)value$; break;
    case 4: examplarCompany = (java.lang.String)value$; break;
    case 5: probability = (java.lang.Double)value$; break;
    case 6: highScore = (java.lang.Boolean)value$; break;
    case 7: isHighScore = (java.lang.Boolean)value$; break;
    case 8: hscodes = (java.util.List<java.lang.String>)value$; break;
    case 9: recordids = (java.util.List<java.lang.String>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'company' field.
   */
  public java.lang.String getCompany() {
    return company;
  }

  /**
   * Sets the value of the 'company' field.
   * @param value the value to set.
   */
  public void setCompany(java.lang.String value) {
    this.company = value;
  }

  /**
   * Gets the value of the 'lob' field.
   */
  public java.lang.String getLob() {
    return lob;
  }

  /**
   * Sets the value of the 'lob' field.
   * @param value the value to set.
   */
  public void setLob(java.lang.String value) {
    this.lob = value;
  }

  /**
   * Gets the value of the 'score' field.
   */
  public java.lang.Double getScore() {
    return score;
  }

  /**
   * Sets the value of the 'score' field.
   * @param value the value to set.
   */
  public void setScore(java.lang.Double value) {
    this.score = value;
  }

  /**
   * Gets the value of the 'expectedCount' field.
   */
  public java.lang.Long getExpectedCount() {
    return expectedCount;
  }

  /**
   * Sets the value of the 'expectedCount' field.
   * @param value the value to set.
   */
  public void setExpectedCount(java.lang.Long value) {
    this.expectedCount = value;
  }

  /**
   * Gets the value of the 'examplarCompany' field.
   */
  public java.lang.String getExamplarCompany() {
    return examplarCompany;
  }

  /**
   * Sets the value of the 'examplarCompany' field.
   * @param value the value to set.
   */
  public void setExamplarCompany(java.lang.String value) {
    this.examplarCompany = value;
  }

  /**
   * Gets the value of the 'probability' field.
   */
  public java.lang.Double getProbability() {
    return probability;
  }

  /**
   * Sets the value of the 'probability' field.
   * @param value the value to set.
   */
  public void setProbability(java.lang.Double value) {
    this.probability = value;
  }

  /**
   * Gets the value of the 'highScore' field.
   */
  public java.lang.Boolean getHighScore() {
    return highScore;
  }

  /**
   * Sets the value of the 'highScore' field.
   * @param value the value to set.
   */
  public void setHighScore(java.lang.Boolean value) {
    this.highScore = value;
  }

  /**
   * Gets the value of the 'isHighScore' field.
   */
  public java.lang.Boolean getIsHighScore() {
    return isHighScore;
  }

  /**
   * Sets the value of the 'isHighScore' field.
   * @param value the value to set.
   */
  public void setIsHighScore(java.lang.Boolean value) {
    this.isHighScore = value;
  }

  /**
   * Gets the value of the 'hscodes' field.
   */
  public java.util.List<java.lang.String> getHscodes() {
    return hscodes;
  }

  /**
   * Sets the value of the 'hscodes' field.
   * @param value the value to set.
   */
  public void setHscodes(java.util.List<java.lang.String> value) {
    this.hscodes = value;
  }

  /**
   * Gets the value of the 'recordids' field.
   */
  public java.util.List<java.lang.String> getRecordids() {
    return recordids;
  }

  /**
   * Sets the value of the 'recordids' field.
   * @param value the value to set.
   */
  public void setRecordids(java.util.List<java.lang.String> value) {
    this.recordids = value;
  }

  /** Creates a new ShyrePiersLOBMessage RecordBuilder */
  public static gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder newBuilder() {
    return new gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder();
  }
  
  /** Creates a new ShyrePiersLOBMessage RecordBuilder by copying an existing Builder */
  public static gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder newBuilder(gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder other) {
    return new gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder(other);
  }
  
  /** Creates a new ShyrePiersLOBMessage RecordBuilder by copying an existing ShyrePiersLOBMessage instance */
  public static gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder newBuilder(gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage other) {
    return new gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder(other);
  }
  
  /**
   * RecordBuilder for ShyrePiersLOBMessage instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ShyrePiersLOBMessage>
    implements org.apache.avro.data.RecordBuilder<ShyrePiersLOBMessage> {

    private java.lang.String company;
    private java.lang.String lob;
    private double score;
    private long expectedCount;
    private java.lang.String examplarCompany;
    private double probability;
    private boolean highScore;
    private boolean isHighScore;
    private java.util.List<java.lang.String> hscodes;
    private java.util.List<java.lang.String> recordids;

    /** Creates a new Builder */
    private Builder() {
      super(gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.company)) {
        this.company = data().deepCopy(fields()[0].schema(), other.company);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.lob)) {
        this.lob = data().deepCopy(fields()[1].schema(), other.lob);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.score)) {
        this.score = data().deepCopy(fields()[2].schema(), other.score);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.expectedCount)) {
        this.expectedCount = data().deepCopy(fields()[3].schema(), other.expectedCount);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.examplarCompany)) {
        this.examplarCompany = data().deepCopy(fields()[4].schema(), other.examplarCompany);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.probability)) {
        this.probability = data().deepCopy(fields()[5].schema(), other.probability);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.highScore)) {
        this.highScore = data().deepCopy(fields()[6].schema(), other.highScore);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.isHighScore)) {
        this.isHighScore = data().deepCopy(fields()[7].schema(), other.isHighScore);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.hscodes)) {
        this.hscodes = data().deepCopy(fields()[8].schema(), other.hscodes);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.recordids)) {
        this.recordids = data().deepCopy(fields()[9].schema(), other.recordids);
        fieldSetFlags()[9] = true;
      }
    }
    
    /** Creates a Builder by copying an existing ShyrePiersLOBMessage instance */
    private Builder(gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage other) {
            super(gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.SCHEMA$);
      if (isValidValue(fields()[0], other.company)) {
        this.company = data().deepCopy(fields()[0].schema(), other.company);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.lob)) {
        this.lob = data().deepCopy(fields()[1].schema(), other.lob);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.score)) {
        this.score = data().deepCopy(fields()[2].schema(), other.score);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.expectedCount)) {
        this.expectedCount = data().deepCopy(fields()[3].schema(), other.expectedCount);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.examplarCompany)) {
        this.examplarCompany = data().deepCopy(fields()[4].schema(), other.examplarCompany);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.probability)) {
        this.probability = data().deepCopy(fields()[5].schema(), other.probability);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.highScore)) {
        this.highScore = data().deepCopy(fields()[6].schema(), other.highScore);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.isHighScore)) {
        this.isHighScore = data().deepCopy(fields()[7].schema(), other.isHighScore);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.hscodes)) {
        this.hscodes = data().deepCopy(fields()[8].schema(), other.hscodes);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.recordids)) {
        this.recordids = data().deepCopy(fields()[9].schema(), other.recordids);
        fieldSetFlags()[9] = true;
      }
    }

    /** Gets the value of the 'company' field */
    public java.lang.String getCompany() {
      return company;
    }
    
    /** Sets the value of the 'company' field */
    public gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder setCompany(java.lang.String value) {
      validate(fields()[0], value);
      this.company = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'company' field has been set */
    public boolean hasCompany() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'company' field */
    public gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder clearCompany() {
      company = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'lob' field */
    public java.lang.String getLob() {
      return lob;
    }
    
    /** Sets the value of the 'lob' field */
    public gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder setLob(java.lang.String value) {
      validate(fields()[1], value);
      this.lob = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'lob' field has been set */
    public boolean hasLob() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'lob' field */
    public gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder clearLob() {
      lob = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'score' field */
    public java.lang.Double getScore() {
      return score;
    }
    
    /** Sets the value of the 'score' field */
    public gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder setScore(double value) {
      validate(fields()[2], value);
      this.score = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'score' field has been set */
    public boolean hasScore() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'score' field */
    public gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder clearScore() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'expectedCount' field */
    public java.lang.Long getExpectedCount() {
      return expectedCount;
    }
    
    /** Sets the value of the 'expectedCount' field */
    public gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder setExpectedCount(long value) {
      validate(fields()[3], value);
      this.expectedCount = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'expectedCount' field has been set */
    public boolean hasExpectedCount() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'expectedCount' field */
    public gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder clearExpectedCount() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'examplarCompany' field */
    public java.lang.String getExamplarCompany() {
      return examplarCompany;
    }
    
    /** Sets the value of the 'examplarCompany' field */
    public gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder setExamplarCompany(java.lang.String value) {
      validate(fields()[4], value);
      this.examplarCompany = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'examplarCompany' field has been set */
    public boolean hasExamplarCompany() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'examplarCompany' field */
    public gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder clearExamplarCompany() {
      examplarCompany = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'probability' field */
    public java.lang.Double getProbability() {
      return probability;
    }
    
    /** Sets the value of the 'probability' field */
    public gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder setProbability(double value) {
      validate(fields()[5], value);
      this.probability = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'probability' field has been set */
    public boolean hasProbability() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'probability' field */
    public gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder clearProbability() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'highScore' field */
    public java.lang.Boolean getHighScore() {
      return highScore;
    }
    
    /** Sets the value of the 'highScore' field */
    public gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder setHighScore(boolean value) {
      validate(fields()[6], value);
      this.highScore = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'highScore' field has been set */
    public boolean hasHighScore() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'highScore' field */
    public gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder clearHighScore() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'isHighScore' field */
    public java.lang.Boolean getIsHighScore() {
      return isHighScore;
    }
    
    /** Sets the value of the 'isHighScore' field */
    public gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder setIsHighScore(boolean value) {
      validate(fields()[7], value);
      this.isHighScore = value;
      fieldSetFlags()[7] = true;
      return this; 
    }
    
    /** Checks whether the 'isHighScore' field has been set */
    public boolean hasIsHighScore() {
      return fieldSetFlags()[7];
    }
    
    /** Clears the value of the 'isHighScore' field */
    public gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder clearIsHighScore() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /** Gets the value of the 'hscodes' field */
    public java.util.List<java.lang.String> getHscodes() {
      return hscodes;
    }
    
    /** Sets the value of the 'hscodes' field */
    public gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder setHscodes(java.util.List<java.lang.String> value) {
      validate(fields()[8], value);
      this.hscodes = value;
      fieldSetFlags()[8] = true;
      return this; 
    }
    
    /** Checks whether the 'hscodes' field has been set */
    public boolean hasHscodes() {
      return fieldSetFlags()[8];
    }
    
    /** Clears the value of the 'hscodes' field */
    public gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder clearHscodes() {
      hscodes = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /** Gets the value of the 'recordids' field */
    public java.util.List<java.lang.String> getRecordids() {
      return recordids;
    }
    
    /** Sets the value of the 'recordids' field */
    public gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder setRecordids(java.util.List<java.lang.String> value) {
      validate(fields()[9], value);
      this.recordids = value;
      fieldSetFlags()[9] = true;
      return this; 
    }
    
    /** Checks whether the 'recordids' field has been set */
    public boolean hasRecordids() {
      return fieldSetFlags()[9];
    }
    
    /** Clears the value of the 'recordids' field */
    public gov.pnnl.aristotle.aiminterface.ShyrePiersLOBMessage.Builder clearRecordids() {
      recordids = null;
      fieldSetFlags()[9] = false;
      return this;
    }


    public ShyrePiersLOBMessage build() {
      try {
        ShyrePiersLOBMessage record = new ShyrePiersLOBMessage();
        record.company = fieldSetFlags()[0] ? this.company : (java.lang.String) defaultValue(fields()[0]);
        record.lob = fieldSetFlags()[1] ? this.lob : (java.lang.String) defaultValue(fields()[1]);
        record.score = fieldSetFlags()[2] ? this.score : (java.lang.Double) defaultValue(fields()[2]);
        record.expectedCount = fieldSetFlags()[3] ? this.expectedCount : (java.lang.Long) defaultValue(fields()[3]);
        record.examplarCompany = fieldSetFlags()[4] ? this.examplarCompany : (java.lang.String) defaultValue(fields()[4]);
        record.probability = fieldSetFlags()[5] ? this.probability : (java.lang.Double) defaultValue(fields()[5]);
        record.highScore = fieldSetFlags()[6] ? this.highScore : (java.lang.Boolean) defaultValue(fields()[6]);
        record.isHighScore = fieldSetFlags()[7] ? this.isHighScore : (java.lang.Boolean) defaultValue(fields()[7]);
        record.hscodes = fieldSetFlags()[8] ? this.hscodes : (java.util.List<java.lang.String>) defaultValue(fields()[8]);
        record.recordids = fieldSetFlags()[9] ? this.recordids : (java.util.List<java.lang.String>) defaultValue(fields()[9]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
