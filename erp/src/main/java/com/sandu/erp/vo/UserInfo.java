package com.sandu.erp.vo;

import lombok.Data;

import java.io.Serializable;
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
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -2960393893061932503L;

    private Long id;

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

    //新增的字段=======================

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
    private String classify;

    /**
     * 关联客户信息
     */
    private List<JoinUserInfo> joinUserInfo;

}
