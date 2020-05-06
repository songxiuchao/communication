package com.sandu.erp.vo;

import com.alibaba.fastjson.JSON;

import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/3/25 9:06
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/3/25 9:06     xiaobing          v1.0.0           Created
 */
public class MessageDecoder implements Decoder.Text<Message> {

    @Override
    public void destroy() {
    }

    @Override
    public void init(EndpointConfig arg0) {
    }

    @Override
    public Message decode(String user) {
        return JSON.parseObject(user, Message.class);
    }

    @Override
    public boolean willDecode(String arg0) {
        return true;
    }

}
