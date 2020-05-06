package com.sandu.erp.vo.authorize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TResponse<T> {

    @JsonProperty
    private String Ret;
    @JsonProperty
    private String Msg;
    @JsonProperty
    private String Sig;
    @JsonProperty
    private String OperatorID;
    @JsonProperty
    private T Data;

    public static TResponse valueOf(Status status) {
        TResponse tResponse = new TResponse();
        tResponse.setRet(status.getRet());
        tResponse.setMsg(status.getMsg());
        return tResponse;
    }

    public static TResponse valueOf(String ret, String msg) {
        TResponse tResponse = new TResponse();
        tResponse.setRet(ret);
        tResponse.setMsg(msg);
        return tResponse;
    }

    public static <T> TResponse<T> valueOf(Status status, T data) {
        TResponse tResponse = new TResponse();
        tResponse.setRet(status.getRet());
        tResponse.setMsg(status.getMsg());
        tResponse.setData(data);
        return tResponse;
    }

    public static <T> TResponse<T> valueOf(String ret, String msg, T data) {
        TResponse tResponse = new TResponse();
        tResponse.setRet(ret);
        tResponse.setMsg(msg);
        tResponse.setData(data);
        return tResponse;
    }

    @JsonIgnore
    public String getRet() {
        return Ret;
    }

    public void setRet(String ret) {
        Ret = ret;
    }

    @JsonIgnore
    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
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

    public enum Status {

        OK("0", "OK"), GENERAL_ERROR("1", "General error"), ILLEGAL_PARAMETER("2", "Illegal parameter"), UNSUPPORTED_OPERATION("2", "Unsupported operation"),;

        Status(String ret, String msg) {
            this.ret = ret;
            this.msg = msg;
        }

        private String ret;
        private String msg;

        public String getRet() {
            return ret;
        }

        public void setRet(String ret) {
            this.ret = ret;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

}
