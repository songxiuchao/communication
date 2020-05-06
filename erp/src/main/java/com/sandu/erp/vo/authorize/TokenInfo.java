package com.sandu.erp.vo.authorize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenInfo {
    
    
    @JsonProperty
    private int FailReason;
    @JsonProperty
    private String OperatorID;
    @JsonProperty
    private String AccessToken;
    @JsonProperty
    private int TokenAvailableTime;
    @JsonProperty
    private int SuccStat;
    @JsonIgnore
    public int getFailReason() {
        return FailReason;
    }
    @JsonIgnore
    public void setFailReason(int failReason) {
        FailReason = failReason;
    }
    @JsonIgnore
    public String getOperatorID() {
        return OperatorID;
    }
    @JsonIgnore
    public void setOperatorID(String operatorID) {
        OperatorID = operatorID;
    }
    @JsonIgnore
    public String getAccessToken() {
        return AccessToken;
    }
    @JsonIgnore
    public void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }
    @JsonIgnore
    public int getTokenAvailableTime() {
        return TokenAvailableTime;
    }
    @JsonIgnore
    public void setTokenAvailableTime(int tokenAvailableTime) {
        TokenAvailableTime = tokenAvailableTime;
    }
    @JsonIgnore
    public int getSuccStat() {
        return SuccStat;
    }
    @JsonIgnore
    public void setSuccStat(int succStat) {
        SuccStat = succStat;
    }

}
