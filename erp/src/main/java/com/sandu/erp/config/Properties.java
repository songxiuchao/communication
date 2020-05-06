package com.sandu.erp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/4/3 10:33
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/4/3 10:33     xiaobing          v1.0.0           Created
 */
@Data
@Component
@ConfigurationProperties(prefix = "sd.config", ignoreUnknownFields = true)
public class Properties {
    /**
     * sign;
     */
    private String encryption;
    /**
     * 编码方式
     */
    private String characterEncoding;
    /**
     * 运营商标识（OperatorID）
     */
    private String operatorID;
    /**
     * 请求密钥
     */
    private String operatorSecret;
    /**
     *  请求地址
     */
    private String postUrl;
    /**
     * 使用CBC模式，需要一个向量iv，可增加加密算法的强度1234567890123456
     */
    private String dataSecretIv;

    /**
     * 本机Ip
     */
    private String myIp;

    /**
     * 失败消息重试次数
     */
    private int number;
}
