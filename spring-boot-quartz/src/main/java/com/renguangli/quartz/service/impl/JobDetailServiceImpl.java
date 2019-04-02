package com.renguangli.quartz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.renguangli.quartz.bean.JobDetail;
import com.renguangli.quartz.mapper.JobDetailMapper;
import com.renguangli.quartz.service.JobDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * spring-boot-quartz
 * Created by renguangli at 2018/12/25 18:01
 *
 * @since JDK1.8
 */
@Service("jobDetailService")
public class JobDetailServiceImpl implements JobDetailService {

    private final JobDetailMapper jobDetailMapper;

    @Autowired
    public JobDetailServiceImpl(JobDetailMapper jobDetailMapper) {
        this.jobDetailMapper = jobDetailMapper;
    }

    @Override
    public PageInfo<JobDetail> listJobDetails(JobDetail jobDetail, int page, int size) {
        PageHelper.startPage(page, size);
        List<JobDetail> jobDetails = jobDetailMapper.listJobDetails(jobDetail);
        return new PageInfo<>(jobDetails);
    }
}
