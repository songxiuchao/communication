package com.sandu.erp.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 中间表
 * @author Administrator
 */

@Data
public class MiddleTable implements Serializable {

    private static final long serialVersionUID = 3729487752789356850L;

    private Long id;

    /**
     * 楼盘id
     */
    private String seccode;

    /**
     * 房源id
     */
    private Long  code;

    /**
     * 换房后的楼栋房源id
     */
    private Long targetId;

    /**
     * 楼栋名称
     */
    private String loft;

    /**
     * 楼层号
     */
    private String floor;

    /**
     * 所属单元
     */
    private String cell;

    /**
     * 户号
     */
    private String roomCode;

    /**
     * 建筑面积
     */
    private BigDecimal area;

    /**
     * 建筑单价 表单价
     */
    private BigDecimal unitPrice;

    /**
     * 标准总价
     */
    private BigDecimal sumPrice;

    /**
     * 房间状态0待售，1销控，2预销控，3预约，4认购，5签约
     */
    private int saleState;

    /**
     * 客户id
     */
    private Long serialNo;

    /**
     * 客户姓名
     */
    private String cusName;

    /**
     * 客户联系方式
     */
    private String sj;

    /**
     * 客户状态 0问询 1来访 2认筹 3认购 4签约
     */
    private int ftSale;

    /**
     * 认购金额
     */
    private BigDecimal subscribeAmount;

    /**
     * 认购时间
     */
    private Date subscribeDate;
    /**
     * 签约金额
     */
    private BigDecimal signAmount;

    /**
     * 签约时间
     */
    private Date signDate;
    /**
     * 1: 未更新 2：已更新了的
     */
    private int processState;

}
