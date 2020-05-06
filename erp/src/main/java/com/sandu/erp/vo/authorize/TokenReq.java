package com.sandu.erp.vo.authorize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenReq {
    
    @JsonProperty
    private String OperatorID;
    @JsonProperty
    private String OperatorSecret;
    @JsonIgnore
    public String getOperatorID() {
        return OperatorID;
    }
    @JsonIgnore
    public void setOperatorID(String operatorID) {
        OperatorID = operatorID;
    }
    @JsonIgnore
    public String getOperatorSecret() {
        return OperatorSecret;
    }
    @JsonIgnore
    public void setOperatorSecret(String operatorSecret) {
        OperatorSecret = operatorSecret;
    }

}
