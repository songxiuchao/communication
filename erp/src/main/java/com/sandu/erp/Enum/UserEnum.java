package com.sandu.erp.Enum;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/3/25 10:07
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/3/25 10:07     xiaobing          v1.0.0           Created
 */
public enum UserEnum {
    STATUS();



    /**
     * id
     */
    private String id;

    /**
     * ip
     */
    private String ip;

    /**
     * ip对应的用户标识
     */
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static UserEnum getUserStatus(String ip){
        UserEnum[] values = UserEnum.values();

        for (UserEnum value : values) {
            if (value.getIp() == ip) {
                return value;
            }
        }

        return null;
    }
}
