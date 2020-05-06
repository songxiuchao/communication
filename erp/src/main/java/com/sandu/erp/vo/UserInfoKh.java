package com.sandu.erp.vo;

import lombok.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/3/27 9:11
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/3/27 9:11     xiaobing          v1.0.0           Created
 */
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
@Data
public class UserInfoKh implements Serializable {

    private static final long serialVersionUID = -2960393893061932503L;

    private Long id;

    /**
     * 楼盘id
     */
    private String propertyId;

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户性别
     */
    private int userSex;
    /**
     * 用户电话
     */
    private String userPhone;
    /**
     * 用户地址
     */
    private String userAddress;
    /**
     * 用户身份证
     */
    private String userCard;
    /**
     * 置业顾问id
     */
    private Long consultantId;
    /**
     * 置业顾问姓名
     */
    private String consultantName;


    /**
     * 意向级别
     */
    private String intentionLevel;

    /**
     * 客户来源
     */
    private String customerSource;

    /**
     * 客户状态
     */
    private int customerStatus;

    /**
     * 归属（公客或无效客户、其他置业顾问）。
     */
    //private String classify;

    /**
     * 关联客户信息
     */
    private List<JoinUserInfo> joinUserInfo;

    private String newJoinUserInfo;


    /**
     * 归属（公客或无效客户、其他置业顾问）。
     */
    private String classify;

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
    /**
     * 重发新信息表的id
     */
    private Long userErrormessageId;

    //================mongodb用到==============
    private SimpleDateFormat date;
}
