package com.renguangli.quartz.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * spring-boot-quartz
 * Created by renguangli at 2018/12/25 12:59
 *
 * @since JDK1.8
 */
@Component("quartzManager")
public class QuartzManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuartzManager.class);

    private final Scheduler scheduler;

    @Autowired
    public QuartzManager(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void addJob(Class<? extends Job> clazz, String name, String group, String cron, String description) throws SchedulerException {
        // 构建job信息
        JobDetail jobDetail = JobBuilder.newJob(clazz)
                .withIdentity(name, group)
                .withDescription(description)
                .build();

        // 表达式调度构建器(即任务执行的时间)
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);

        // 按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(name, group)
                .withDescription(description)
                .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, trigger);
        LOGGER.info("定时任务添加成功[name:{},group:{},cron:{}]", name, group, cron);
    }

    public void updateJob(String name, String group, String cron, String description) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(name, group);

        // cron 表达式调度构建器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);

        // 按新的 cron 表达式重新构建
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        trigger = trigger.getTriggerBuilder()
                .withIdentity(triggerKey)
                .withDescription(description)
                .withSchedule(scheduleBuilder)
                .build();
        scheduler.rescheduleJob(triggerKey, trigger);// 按新的trigger重新设置job执行
    }

    public void deleteJob(String name, String group) throws SchedulerException {
        scheduler.pauseTrigger(TriggerKey.triggerKey(name, group));
        scheduler.unscheduleJob(TriggerKey.triggerKey(name, group));
        scheduler.deleteJob(JobKey.jobKey(name, group));
    }

    public void pauseJob(String name, String group) throws SchedulerException {
        scheduler.pauseJob(JobKey.jobKey(name, group));
    }

    public void resumeJob(String name, String group) throws SchedulerException {
        scheduler.resumeJob(JobKey.jobKey(name, group));
    }

}
