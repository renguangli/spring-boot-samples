package com.renguangli.quartz.quartz.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * ExampleQuartzJob
 * Created by renguangli at 2018/12/24 18:05
 *
 * @since JDK1.8
 */
public class SampleQuartzJob extends QuartzJobBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleQuartzJob.class);

    private static long l = System.currentTimeMillis();

    @Override
    protected void executeInternal(JobExecutionContext jec) throws JobExecutionException {
        System.out.println("定时任务正在执行。。。。。");
        LOGGER.info("name={},group={}", jec.getTrigger().getJobKey().getName(), jec.getTrigger().getJobKey().getGroup());
        System.out.println("time = " + (System.currentTimeMillis() - l));

    }

}
