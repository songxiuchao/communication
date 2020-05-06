package com.sandu.erp.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ChangeUserHouseInfo implements Serializable {

    private static final long serialVersionUID = -9067270522977278540L;

    private Long id;

    /**
     * 楼盘id
     */
    private String houseId;
    /**
     * 楼栋房源id
     */
    private Long houseBuildingId;

    /**
     * 换房后的楼栋房源id
     */
    private Long targetId;

    /**
     * 楼栋名称
     */
    private String houseBuilding;

    /**
     * 楼层号
     */
    private String floor;

    /**
     * 所属单元
     */
    private String houseUnit;

    /**
     * 户号
     */
    private String houseName;
    /**
     * 建筑面积
     */
    private BigDecimal buildingArea;

    /**
     * 建筑单价
     */
    private BigDecimal buildingPrice;
    /**
     * 标准总价
     */
    private BigDecimal price;

    /**
     * 房间状态0待售，1销控，2预销控，3预约，4认购，5签约
     */
    private String houseStatus;

    /**
     * 客户id
     */
    private Long customerId;
    /**
     * 客户姓名
     */
    private String name;
    /**
     * 客户联系方式
     */
    private String mobile;

    /**
     * 客户状态 0问询 1来访 2认筹 3认购 4签约
     */
    private int customerStatus;

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

    /**
     * 是否退房 0否 1：是
     */
    private int isCheckOut;

    /**
     * 是否换房 0否 1：是
     */
    private int isRoomChange;
}
