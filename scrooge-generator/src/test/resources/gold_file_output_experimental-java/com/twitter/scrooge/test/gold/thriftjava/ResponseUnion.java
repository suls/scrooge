/**
 * Generated by Scrooge
 *   version: ?
 *   rev: ?
 *   built at: ?
 */

package com.twitter.scrooge.test.gold.thriftjava;

import com.twitter.scrooge.Option;
import com.twitter.scrooge.Utilities;
import com.twitter.scrooge.ThriftStruct;
import com.twitter.scrooge.ThriftStructCodec;
import com.twitter.scrooge.ThriftStructCodec3;
import org.apache.thrift.protocol.*;
import java.nio.ByteBuffer;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;


@javax.annotation.Generated(value = "com.twitter.scrooge.Compiler")
public class ResponseUnion implements ThriftStruct {
  private static final TStruct STRUCT = new TStruct("ResponseUnion");
  private static final TField IdField = new TField("id", TType.I64, (short) 1);
  private final Long id;
  private static final TField DetailsField = new TField("details", TType.STRING, (short) 2);
  private final String details;

  public enum Field {
    ID,
    DETAILS,
UNKNOWN_UNION_VALUE;

  }

  /*
   * A flag indicate which field this union object is set to.
   * Note that it is ok to define a field with name "setField", the
   * generated getter method would be "getSetField", so there won't
   * be naming conflict.
   */
  public final Field setField;

  public static ThriftStructCodec<ResponseUnion> CODEC = new ThriftStructCodec3<ResponseUnion>() {
    public ResponseUnion decode(TProtocol _iprot) throws org.apache.thrift.TException {
      ResponseUnion result = null;
      _iprot.readStructBegin();
      TField _field = _iprot.readFieldBegin();
      switch (_field.id) {
        case 1: /* id */
          switch (_field.type) {
            case TType.I64:
              Long id_item;
              id_item = _iprot.readI64();
              result = newId(id_item);
              break;
            default:
              TProtocolUtil.skip(_iprot, _field.type);
          }
          break;
        case 2: /* details */
          switch (_field.type) {
            case TType.STRING:
              String details_item;
              details_item = _iprot.readString();
              result = newDetails(details_item);
              break;
            default:
              TProtocolUtil.skip(_iprot, _field.type);
          }
          break;
        default:
          if (_field.type != TType.STOP) {
            result = new ResponseUnion();
          }
          TProtocolUtil.skip(_iprot, _field.type);
      }
      if (_field.type != TType.STOP) {
        _iprot.readFieldEnd();
        Boolean _done = false;
        Boolean _moreThanOne = false;
        while (!_done) {
          _field = _iprot.readFieldBegin();
          if (_field.type == TType.STOP)
            _done = true;
          else {
            _moreThanOne = true;
            TProtocolUtil.skip(_iprot, _field.type);
            _iprot.readFieldEnd();
          }
        }
        if (_moreThanOne) {
          _iprot.readStructEnd();
          throw new TProtocolException("Cannot read a TUnion with more than one set value!");
        }
      }
      _iprot.readStructEnd();
      if (result == null)
        throw new TProtocolException("Cannot read a TUnion with no set value!");
      return result;
    }

    public void encode(ResponseUnion struct, TProtocol oprot) throws org.apache.thrift.TException {
      struct.write(oprot);
    }
  };

  public static ResponseUnion decode(TProtocol _iprot) throws org.apache.thrift.TException {
    return CODEC.decode(_iprot);
  }

  public static void encode(ResponseUnion struct, TProtocol oprot) throws org.apache.thrift.TException {
    CODEC.encode(struct, oprot);
  }

  private ResponseUnion() {
    this.setField = Field.UNKNOWN_UNION_VALUE;
        this.id = null;
        this.details = null;

  }

  public ResponseUnion(
    Field setField,
    Object value
  ) {
    if (value == null)
      throw new NullPointerException("Cannot construct ResponseUnion with a null value");
    this.setField = setField;
    this.id = (setField == Field.ID ? (Long) value : null);
    this.details = (setField == Field.DETAILS ? (String) value : null);
  }

  public static ResponseUnion newId(long id) {
    return new ResponseUnion(Field.ID, id);
  }
  public static ResponseUnion newDetails(String details) {
    return new ResponseUnion(Field.DETAILS, details);
  }

  public void write(TProtocol _oprot) throws org.apache.thrift.TException {
    _oprot.writeStructBegin(STRUCT);
    switch (setField) {
      case ID:
        _oprot.writeFieldBegin(IdField);
        Long id_item = id;
        _oprot.writeI64(id_item);
        _oprot.writeFieldEnd();
        break;
      case DETAILS:
        _oprot.writeFieldBegin(DetailsField);
        String details_item = details;
        _oprot.writeString(details_item);
        _oprot.writeFieldEnd();
        break;
    }
    _oprot.writeFieldStop();
    _oprot.writeStructEnd();
  }


  @java.lang.Override
  public boolean equals(Object other) {
    if (!(other instanceof ResponseUnion)) return false;
    ResponseUnion that = (ResponseUnion) other;
    if (this.setField != that.setField) return false;
    switch (setField) {
      case ID:
        return this.id == that.id;
      case DETAILS:
        return this.details.equals(that.details);
    }
    return false;
  }

  @java.lang.Override
  public String toString() {
    switch (setField) {
      case ID:
        return "ResponseUnion(id," + this.id + ")";
      case DETAILS:
        return "ResponseUnion(details," + this.details + ")";
    }
    return "ResponseUnion(???)";
  }

  @java.lang.Override
  public int hashCode() {
    int hash = 1;
    switch (setField) {
      case ID:
        hash = hash * new Long(this.id).hashCode();
        break;
      case DETAILS:
        hash = hash * (this.details == null ? 0 : this.details.hashCode());
        break;
    }
    return hash;
  }
}