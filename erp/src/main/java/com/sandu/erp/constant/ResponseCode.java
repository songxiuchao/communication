package com.sandu.erp.constant;

/**
 * @description: 错误码
 **/
public class ResponseCode {
    /**
     * 执行成功
     */
    public static final String SUCCESS = "200";

    /**
     * 参数验证错误
     */
    public static final String ERROR_PARAMS_VALIDATOR = "300";

    /**
     * 业务验证错误
     */
    public static final String ERROR_SERVICE_VALIDATOR = "400";

    /**
     * 系统数据错误
     */
    public static final String ERROR_DATA_VALIDATOR = "500";

    /**
     * Token失效
     */
    public static final String ERROR_TOKEN_INVALID = "600";

    /**
     * 上传文件异常
     */
    public static final String ERROR_FILE_UPLOAD = "777";

    /**
     * 系统异常
     */
    public static final String ERROR_999 = "999";
}
