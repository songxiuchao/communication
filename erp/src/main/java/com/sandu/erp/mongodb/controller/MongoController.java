package com.sandu.erp.mongodb.controller;

import com.sandu.erp.mongodb.config.LogAssistant;
import com.sandu.erp.vo.FailLogVo.FailLog;
import com.sandu.erp.vo.UserInfoKh;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @program: demo
 * @description: mongodb测试类
 **/
@Slf4j
@RestController
@RequestMapping("/mongo")
public class MongoController {

    @Autowired
    private LogAssistant logAssistant;

    @PostMapping("/save")
    public void saveLog(){
        FailLog failLog = new FailLog();
        failLog.setNumber(1);
        failLog.setUserKey("key");
        failLog.setUserValue("value");
        failLog.setTime(new Date());
        failLog.setStatus(0);
        logAssistant.saveFailLog(failLog);
    }

    @PostMapping("/getLogInfo")
    public List<FailLog> getLogInfo(){
        return logAssistant.getFailLog("1");
    }

}
