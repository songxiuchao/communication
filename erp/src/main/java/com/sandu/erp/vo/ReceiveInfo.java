package com.sandu.erp.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
public class ReceiveInfo extends UserInfo implements Serializable {

    private static final long serialVersionUID = -2602680272717872L;

    /**
     * 楼盘id
     */
    private String propertyId;


    /**
     * 用户信息
     */
    private UserInfo userInfo;
}
