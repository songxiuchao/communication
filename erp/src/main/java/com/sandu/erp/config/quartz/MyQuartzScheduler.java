package com.sandu.erp.config.quartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @program: demo
 * @description: 创建job和Trigger
 * @author: xiuchao Song
 * @create: 2019-11-11 08:46
 **/
@Configuration
public class MyQuartzScheduler {

    // 任务调度
    @Autowired
    private  Scheduler scheduler;

    @Value("${quartz.cron1}")
    private String cron1;

    @Value("${quartz.cron2}")
    private String cron2;

    /**
     * 开始执行所有任务
     *
     * @throws SchedulerException
     */
    public  void startJob() throws SchedulerException {
        startJob1(scheduler);
        startJob2(scheduler);
        scheduler.start();
    }

    public void endJob() throws SchedulerException {
        scheduler.shutdown();
    }



    /**
     * 注入Job1任务(抓取本地数据发送给云客)
     * @param scheduler
     * @throws SchedulerException
     */
    private  void startJob1(Scheduler scheduler) throws SchedulerException {
        // 通过JobBuilder构建JobDetail实例，JobDetail规定只能是实现Job接口的实例
        // JobDetail 是具体Job实例
        JobDetail jobDetail = JobBuilder.newJob(QuartzJob1.class).withIdentity("job1", "group1").build();
        // 基于表达式构建触发器
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron1); //  "*/5 * * * * ?"
        // CronTrigger表达式触发器 继承于Trigger
        // TriggerBuilder 用于构建触发器实例
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("job1", "group1")
                .withSchedule(cronScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

    /**
     * 注入Job2任务（重新发送用户信息）
     * @param scheduler
     * @throws SchedulerException
     */
    private  void startJob2(Scheduler scheduler) throws SchedulerException {
        // 通过JobBuilder构建JobDetail实例，JobDetail规定只能是实现Job接口的实例
        // JobDetail 是具体Job实例
        JobDetail jobDetail = JobBuilder.newJob(QuartzJob2.class).withIdentity("job2", "group2").build();
        // 基于表达式构建触发器
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron2); //  "*/5 * * * * ?"  cron2
        // CronTrigger表达式触发器 继承于Trigger
        // TriggerBuilder 用于构建触发器实例
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("job2", "group2")
                .withSchedule(cronScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }


}
