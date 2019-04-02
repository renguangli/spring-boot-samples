package com.renguangli.quartz.controller;

import com.github.pagehelper.PageInfo;
import com.renguangli.quartz.ResponseResult;
import com.renguangli.quartz.bean.JobDetail;
import com.renguangli.quartz.quartz.QuartzManager;
import com.renguangli.quartz.quartz.task.SampleQuartzJob;
import com.renguangli.quartz.service.JobDetailService;
import org.quartz.Job;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * spring-boot-quartz
 * Created by renguangli at 2018/12/25 18:07
 *
 * @since JDK1.8
 */
@RestController
public class JobDetailController {

    @Resource
    private JobDetailService jobDetailService;

    @Resource
    private QuartzManager quartzManager;

    @GetMapping("/jobDetails")
    public PageInfo<JobDetail> listJobDetails(JobDetail jobDetail
            , @RequestParam(defaultValue = "1") int page
            , @RequestParam(defaultValue = "10")int size) {
        return jobDetailService.listJobDetails(jobDetail, page, size);
    }

    @PostMapping("/job/add")
    public ResponseResult addJob(String jobClassName, String name, String group, String cron, String description) throws SchedulerException {
        quartzManager.addJob(SampleQuartzJob.class, name, group, cron, description);
        return new ResponseResult("定时任务添加成功！");
    }

    @PostMapping("/job/update")
    public ResponseResult updateJob(String jobClassName, String name, String group, String cron, String description) throws SchedulerException {
        quartzManager.updateJob(name, group, cron, description);
        return new ResponseResult("定时任务修改成功！");
    }

    @PostMapping("/job/del")
    public ResponseResult deleteJob(String name, String group) throws SchedulerException {
        quartzManager.deleteJob(name, group);
        return new ResponseResult("定时任务删除成功！");
    }

    @PostMapping("/job/pause")
    public ResponseResult pauseJob(String name, String group) throws SchedulerException {
        quartzManager.pauseJob(name, group);
        return new ResponseResult("定时任务已暂停！");
    }

    @PostMapping("/job/resume")
    public ResponseResult resumeJob(String name, String group) throws SchedulerException {
        quartzManager.resumeJob(name, group);
        return new ResponseResult("定时任务已恢复！");
    }

    private Class<? extends Job> getClass(String jobClassName){
        try {
            Class<?> clazz = Class.forName(jobClassName);
            Job job = (Job) clazz.newInstance();
            return job.getClass();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
