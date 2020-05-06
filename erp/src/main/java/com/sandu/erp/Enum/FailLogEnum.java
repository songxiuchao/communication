package com.sandu.erp.Enum;

/**
 * @author sxc
 * @version 1.0
 * @date 2020/4/23 15:49
 */
public enum FailLogEnum {
    SUCCESS(1,"信息发送成功"),
    FAIL(2,"更新未发送的信息"),
    SAVE_FAIL(3,"保存未发送的信息");

    private int id;

    /**
     * 状态
     */
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    FailLogEnum(int id, String status) {
        this.id = id;
        this.status = status;
    }
}
