/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.semihtumay.cqrspattern.application.event;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class ProductUpdatedEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4329510768064230447L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ProductUpdatedEvent\",\"namespace\":\"com.semihtumay.cqrspattern.application.event\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"name\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"price\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"stock\",\"type\":[\"null\",\"int\"],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ProductUpdatedEvent> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ProductUpdatedEvent> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<ProductUpdatedEvent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<ProductUpdatedEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<ProductUpdatedEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this ProductUpdatedEvent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a ProductUpdatedEvent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a ProductUpdatedEvent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static ProductUpdatedEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence id;
  private java.lang.CharSequence name;
  private java.lang.CharSequence price;
  private java.lang.Integer stock;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ProductUpdatedEvent() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param name The new value for name
   * @param price The new value for price
   * @param stock The new value for stock
   */
  public ProductUpdatedEvent(java.lang.CharSequence id, java.lang.CharSequence name, java.lang.CharSequence price, java.lang.Integer stock) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.stock = stock;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return name;
    case 2: return price;
    case 3: return stock;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: name = (java.lang.CharSequence)value$; break;
    case 2: price = (java.lang.CharSequence)value$; break;
    case 3: stock = (java.lang.Integer)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'price' field.
   * @return The value of the 'price' field.
   */
  public java.lang.CharSequence getPrice() {
    return price;
  }


  /**
   * Sets the value of the 'price' field.
   * @param value the value to set.
   */
  public void setPrice(java.lang.CharSequence value) {
    this.price = value;
  }

  /**
   * Gets the value of the 'stock' field.
   * @return The value of the 'stock' field.
   */
  public java.lang.Integer getStock() {
    return stock;
  }


  /**
   * Sets the value of the 'stock' field.
   * @param value the value to set.
   */
  public void setStock(java.lang.Integer value) {
    this.stock = value;
  }

  /**
   * Creates a new ProductUpdatedEvent RecordBuilder.
   * @return A new ProductUpdatedEvent RecordBuilder
   */
  public static com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent.Builder newBuilder() {
    return new com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent.Builder();
  }

  /**
   * Creates a new ProductUpdatedEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ProductUpdatedEvent RecordBuilder
   */
  public static com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent.Builder newBuilder(com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent.Builder other) {
    if (other == null) {
      return new com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent.Builder();
    } else {
      return new com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent.Builder(other);
    }
  }

  /**
   * Creates a new ProductUpdatedEvent RecordBuilder by copying an existing ProductUpdatedEvent instance.
   * @param other The existing instance to copy.
   * @return A new ProductUpdatedEvent RecordBuilder
   */
  public static com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent.Builder newBuilder(com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent other) {
    if (other == null) {
      return new com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent.Builder();
    } else {
      return new com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent.Builder(other);
    }
  }

  /**
   * RecordBuilder for ProductUpdatedEvent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ProductUpdatedEvent>
    implements org.apache.avro.data.RecordBuilder<ProductUpdatedEvent> {

    private java.lang.CharSequence id;
    private java.lang.CharSequence name;
    private java.lang.CharSequence price;
    private java.lang.Integer stock;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.price)) {
        this.price = data().deepCopy(fields()[2].schema(), other.price);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.stock)) {
        this.stock = data().deepCopy(fields()[3].schema(), other.stock);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing ProductUpdatedEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.price)) {
        this.price = data().deepCopy(fields()[2].schema(), other.price);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.stock)) {
        this.stock = data().deepCopy(fields()[3].schema(), other.stock);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.CharSequence getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent.Builder setName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'price' field.
      * @return The value.
      */
    public java.lang.CharSequence getPrice() {
      return price;
    }


    /**
      * Sets the value of the 'price' field.
      * @param value The value of 'price'.
      * @return This builder.
      */
    public com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent.Builder setPrice(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.price = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'price' field has been set.
      * @return True if the 'price' field has been set, false otherwise.
      */
    public boolean hasPrice() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'price' field.
      * @return This builder.
      */
    public com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent.Builder clearPrice() {
      price = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'stock' field.
      * @return The value.
      */
    public java.lang.Integer getStock() {
      return stock;
    }


    /**
      * Sets the value of the 'stock' field.
      * @param value The value of 'stock'.
      * @return This builder.
      */
    public com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent.Builder setStock(java.lang.Integer value) {
      validate(fields()[3], value);
      this.stock = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'stock' field has been set.
      * @return True if the 'stock' field has been set, false otherwise.
      */
    public boolean hasStock() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'stock' field.
      * @return This builder.
      */
    public com.semihtumay.cqrspattern.application.event.ProductUpdatedEvent.Builder clearStock() {
      stock = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ProductUpdatedEvent build() {
      try {
        ProductUpdatedEvent record = new ProductUpdatedEvent();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.price = fieldSetFlags()[2] ? this.price : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.stock = fieldSetFlags()[3] ? this.stock : (java.lang.Integer) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ProductUpdatedEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<ProductUpdatedEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ProductUpdatedEvent>
    READER$ = (org.apache.avro.io.DatumReader<ProductUpdatedEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.id);

    if (this.name == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.name);
    }

    if (this.price == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.price);
    }

    if (this.stock == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeInt(this.stock);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);

      if (in.readIndex() != 1) {
        in.readNull();
        this.name = null;
      } else {
        this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.price = null;
      } else {
        this.price = in.readString(this.price instanceof Utf8 ? (Utf8)this.price : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.stock = null;
      } else {
        this.stock = in.readInt();
      }

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);
          break;

        case 1:
          if (in.readIndex() != 1) {
            in.readNull();
            this.name = null;
          } else {
            this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);
          }
          break;

        case 2:
          if (in.readIndex() != 1) {
            in.readNull();
            this.price = null;
          } else {
            this.price = in.readString(this.price instanceof Utf8 ? (Utf8)this.price : null);
          }
          break;

        case 3:
          if (in.readIndex() != 1) {
            in.readNull();
            this.stock = null;
          } else {
            this.stock = in.readInt();
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










