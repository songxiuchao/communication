package com.sandu.erp.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/3/27 11:01
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/3/27 11:01     xiaobing          v1.0.0           Created
 */
@Data
public class IpConfig implements Serializable {

    private Long id;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 置业顾问id
     */
    private String propertyId;
}
