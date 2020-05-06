package com.sandu.erp.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class JoinUserInfo implements Serializable {

    private static final long serialVersionUID = 952125984839876072L;

    private Long id;

    /**
     * 关联客户id
     */
    private Long joinCustomerId;

    /**
     * userId
     */
    private Long userId;

    /**
     * 关联客户姓名
     */
    private String relatedUserName;

    /**
     * 关联客户性别
     */
    private int relatedUserSex;

    /**
     * 关联客户联系方式
     */
    private String relatedUserPhone;

}
