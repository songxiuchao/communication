package com.sandu.erp.vo;

import com.alibaba.fastjson.JSON;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/3/25 9:08
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/3/25 9:08     xiaobing          v1.0.0           Created
 */
public class MessageEncoder implements Encoder.Text<Message> {

    @Override
    public void destroy () {
    }

    @Override
    public void init (EndpointConfig arg0) {
    }

    @Override
    public String encode (Message object) throws EncodeException {
        return JSON.toJSONString(object);
    }
}