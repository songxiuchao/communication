package com.sandu.erp.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
public class UserPropertyVo implements Serializable {

    private static final long serialVersionUID = 614907255411567730L;

    private Long id;

    /**
     * 楼盘id
     */
    private String propertyId;

    /**
     * 客户id
     */
    private Long userId;
}
