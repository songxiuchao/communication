package com.sandu.erp.util;

import com.sandu.erp.config.Properties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.SortedMap;

/**
 * @author songxiuchao
 * @data 2019/9/17 下午 01:58
 */
@Slf4j
public class SDUtil {

    public static   String Sign(SortedMap<Object,Object> parameters,String operatorSecret,
                        String encryption){
        //排序
        String myParameters = SHA.Sort(parameters);
        //在拼接的字符串之后添加签名的key
        String  result=operatorSecret+myParameters+operatorSecret;
        //加密 并 转为大写
        String s = MD5Util.MD5Encode(result, "utf-8").toUpperCase();
        //String e = Encrypt.e(result).toUpperCase();
        //String s = SignUtil.content2Sign(result, encryption).toUpperCase();
        log.info("加密后的值："+s);
        return s;
    }

}
