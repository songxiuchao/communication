package com.sandu.erp.controller;

import com.sandu.erp.config.WebSocketServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/3/26 9:34
 * @Description Modification History: 发送用户信息测试类（可删除）  (已调通 已调通 已调通)
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/3/26 9:34     xiaobing          v1.0.0           Created
 */
@RestController
@RequestMapping("/send")
public class SendMessageController {

    @RequestMapping("/sendMessage")
    public void sendMessage(String message,String param){
        WebSocketServer webSocketServer=new WebSocketServer();
        webSocketServer.sendToUser(message,param);
    }


}
