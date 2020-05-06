package com.sandu.erp.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Administrator
 */
@Data
public class ListingReturnUserInfo extends ListingUserInfo implements Serializable  {

    private static final long serialVersionUID = -3226460336170064340L;

    /**
     * 接口处理状态
     * 同步过了就不再理会该条数据了（更新客户状态和房源状态）
     * 1：未同步  2：已同步
     */
    @JsonIgnore
    private int processState;


    /**
     * 建筑面积
     */
    //private Double Area;

    /**
     * 房源状态 SaleState=1未售，SaleState=2认购，SaleState=3签约，SaleState=4预留，
     * SaleState=5小定
     */
    //private int SaleState;

    /**
     * 户型
     */
    //private String RoomType;

    /**
     * 表单价
     */
   // private BigDecimal UnitPrice;

    /**
     * 表总价
     */
    //private BigDecimal SumPrice;
}
