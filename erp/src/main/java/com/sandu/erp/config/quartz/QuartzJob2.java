package com.sandu.erp.config.quartz;

import com.sandu.erp.config.Properties;
import com.sandu.erp.config.WebSocketServer;
import com.sandu.erp.service.Impl.UserErrorMessageServiceImpl;
import com.sandu.erp.util.ApplicationContextUtil;
import com.sandu.erp.vo.UserErrorMessage.UserErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: demo
 * @description: quartz定时任务(重新发送用户信息)
 **/
@Slf4j
@Component
public class QuartzJob2 implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("=====job2===开始执行 {}",System.currentTimeMillis());
        //======================业务逻辑==========================
            //将信息推送给云客
        UserErrorMessageServiceImpl userErrorMessageService = (UserErrorMessageServiceImpl) ApplicationContextUtil.getBean("userErrorMessageService");
        List<UserErrorMessage> errorUserMessageInfo = userErrorMessageService.getErrorUserMessageInfo();
        if (errorUserMessageInfo.size() == 0){
            log.info("没有要重发的消息");
        }else {
            errorUserMessageInfo.stream().forEach(list ->{
                log.info("开始发送失败消息");
                Properties properties = (Properties) ApplicationContextUtil.getBean("properties");
                if (list.getNumber()<properties.getNumber()){
                    String message = list.getUserValue();
                    Long id = list.getId();
                    WebSocketServer webSocketServer=new WebSocketServer();
                    webSocketServer.sendToUser(message,properties.getMyIp()+id);
                    log.info("发送结果"+message);
                }else {
                    log.info("重试次数达到上限");
                }

            });
        }

        //=======================================================
        log.info("=====job2===结束执行 {}",System.currentTimeMillis());
    }
}
