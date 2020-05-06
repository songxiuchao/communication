package com.sandu.erp.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class ListingUserInfo implements Serializable {

    private static final long serialVersionUID = 6858953337714057101L;

    private Long id;

    /**
     * 楼盘项目代码 如：CSYY
     */
    private String secCode;

    /**
     * 客户编号（唯一）	数据形式：楼盘项目代码：Section +客户id：Code
     */
    private String serialNo;

    /**
     * 楼栋名称	如：1#、1号楼
     */
    private String loft;

    /**
     * 楼层id
     */
    private String floorId;

    /**
     * 楼层号
     */
    private String floorNumber;


    /**
     * 房号 如：1-201
     */
    private String roomCode;

    /**
     * 单元号
     */
    private int cell;

    /**
     * 换房前客户状态交易状态(如果为换房为0)
     * 1—认筹（只更新客户状态）
     * 2—认购（更新客户状态和房源状态）
     * 3—签约
     */
    private int beforeTransactionState;

    /**
     * 换房后客户状态交易状态 (如果为换房为0)
     * 1—认筹（只更新客户状态）
     * 2—认购（更新客户状态和房源状态）
     * 3—签约
     */
    private int afterTransactionState;

    /**
     * 成交单价	认购、签约的成交单价
     */
    private BigDecimal transactionPrice;

    /**
     * 成交总价	认购、签约的成交总价
     */
    private BigDecimal transactionSumPrice;

    /**
     * 建筑面积
     */
    private Double area;

    /**
     * 房源状态 SaleState=1未售，SaleState=2认购，SaleState=3签约，SaleState=4预留，
     * SaleState=5小定
     */
    private int saleState;

    /**
     * 表单价
     */
    private BigDecimal unitPrice;

    /**
     * 表总价
     */
    private BigDecimal sumPrice;

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
     * 认购金额
     */
    private BigDecimal subscriptionAmount;
    /**
     * 认购日期
     */
    private Date subscriptionDate;

    /**
     * 签约金额
     */
    private BigDecimal signedAmount;
    /**
     * 签约日期
     */
    private Date signedDate;
}
