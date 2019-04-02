package com.renguangli.quartz.mapper;

import com.renguangli.quartz.bean.JobDetail;

import java.util.List;

public interface JobDetailMapper {

    List<JobDetail> listJobDetails(JobDetail jobDetail);
}