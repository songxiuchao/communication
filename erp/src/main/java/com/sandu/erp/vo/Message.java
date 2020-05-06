package com.sandu.erp.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/3/25 9:06
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/3/25 9:06     xiaobing          v1.0.0           Created
 */
@Data
public class Message implements Serializable {

    private static final long serialVersionUID = -8536099947438729456L;

    private Long id;

    /**
     * 发送的内容
     */
    private UserInfo  userInfo;
    /**
     * 用户ip
     */
    private String ip;

    /**
     * 楼盘id
     */
    private String propertyId;

    /**
     * 用户id
     */
    private Long userId;

    //==================给删除提供的主键==============================
    /**
     * userinfo表的主键id，主要用来传递id
     */
    private Long userInfoId;

    /**
     * joinUserInfo表的主键id
     */
    private Long joinUserInfoId;

    /**
     * userproperty表的主键id
     */
    private Long userPropertyId;

}