package com.sandu.erp.vo.authorize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TRequest<T> {

    @JsonProperty
    private String TimeStamp;
    @JsonProperty
    private String Seq;
    @JsonProperty
    private String Sig;
    @JsonProperty
    private String OperatorID;
    @JsonProperty
    private T Data;

    @JsonIgnore
    public String getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        TimeStamp = timeStamp;
    }

    @JsonIgnore
    public String getSeq() {
        return Seq;
    }

    public void setSeq(String seq) {
        Seq = seq;
    }

    @JsonIgnore
    public String getSig() {
        return Sig;
    }

    public void setSig(String sig) {
        Sig = sig;
    }

    @JsonIgnore
    public String getOperatorID() {
        return OperatorID;
    }

    public void setOperatorID(String operatorID) {
        OperatorID = operatorID;
    }

    @JsonIgnore
    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

}
