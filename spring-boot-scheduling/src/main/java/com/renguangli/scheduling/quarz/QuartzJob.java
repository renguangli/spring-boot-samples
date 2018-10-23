package com.renguangli.scheduling.quarz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * QuartzJob
 *
 * @author renguangli 2018/1/5 16:38
 * @since JDK 1.8
 */
public class QuartzJob implements Job{

    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        String hello = (String) jobDataMap.get("hello");
        System.err.println(hello);
    }
    
}
