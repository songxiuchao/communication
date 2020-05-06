package com.sandu.erp.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class DoPostJson {
    public  static  String doPostJson(String url,String key,String json){
        try {
            String postURL=url;
            PostMethod postMethod = null;
            postMethod = new PostMethod(postURL) ;
            postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8") ;
            postMethod.addParameter(key,json);  //传参数
            HttpClient httpClient = new HttpClient();
            int response = httpClient.executeMethod(postMethod); // 执行POST方法
            InputStream responseBodyAsStream = postMethod.getResponseBodyAsStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while((len = responseBodyAsStream.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            bos.close();

            return new String(bos.toByteArray());
        } catch (Exception e) {

            throw new RuntimeException(e.getMessage());
        }


    }
}
