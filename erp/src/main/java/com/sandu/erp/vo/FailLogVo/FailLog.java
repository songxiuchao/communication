package com.sandu.erp.vo.FailLogVo;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "fail_log")
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class FailLog implements Serializable {

    private static final long serialVersionUID = -654824800925796459L;

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

    /**
     * 成功/失败
     */
    private String state;

    public FailLog(String userKey, String userValue, int status, int number, Date time, String state) {
        this.userKey = userKey;
        this.userValue = userValue;
        this.status = status;
        this.number = number;
        this.time = time;
        this.state = state;
    }
}
