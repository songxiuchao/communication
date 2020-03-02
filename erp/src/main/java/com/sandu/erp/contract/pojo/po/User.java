package com.sandu.erp.contract.pojo.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 用户 实体类
 * Module: User.java
 *
 * @author xiaobing
 * @since JDK 1.8
 * @version 1.1
 * @date 2020-03-02
 * @Descriptions:
*/
@Getter
@Setter
@ToString
@TableName(value = "user")
public class User {


    /**
    id
    */
    @TableId(value = "id", type = IdType.ID_WORKER)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
    姓名
    */
    @TableField(value = "name",strategy = FieldStrategy.NOT_EMPTY)
    @ApiModelProperty(value = "姓名")
    private String name;

}