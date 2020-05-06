package com.sandu.erp.vo.UserErrorMessage;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserErrorMessage implements Serializable {

    private static final long serialVersionUID = 5439955478457950944L;

    private Long id;
    /**
     * 用户key
     */
    private String userKey;

    /**
     * 用户发送失败的消息
     */
    private String userValue;

    /**
     * 状态（0: 未发送 1：已发送）
     */
    private int status;

    /**
     * 重试次数
     */
    private int number;
    /**
     * 当前时间
     */
    private Date time;
}
