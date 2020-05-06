package com.sandu.erp.config.quartz;

import com.alibaba.fastjson.JSONObject;
import com.sandu.erp.service.Impl.ListingUserServiceImpl;
import com.sandu.erp.util.ApplicationContextUtil;
import com.sandu.erp.vo.ListingUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: demo
 * @description: quartz定时任务(抓取数据发送给云客)
 **/
@Slf4j
@Component
public class QuartzJob1 implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("=====job1===开始执行 {}",System.currentTimeMillis());
        //======================业务逻辑==========================
            //将信息推送给云客
            ListingUserServiceImpl listingUserService = (ListingUserServiceImpl) ApplicationContextUtil.getBean("listingUserService");
        JSONObject listingInfo = listingUserService.getListingInfo();
        log.info("发送结果"+listingInfo);
        //=======================================================
        log.info("=====job1===结束执行 {}",System.currentTimeMillis());
    }
}
