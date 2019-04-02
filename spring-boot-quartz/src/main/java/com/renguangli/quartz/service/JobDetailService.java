package com.renguangli.quartz.service;

import com.github.pagehelper.PageInfo;
import com.renguangli.quartz.bean.JobDetail;

/**
 * spring-boot-quartz
 * Created by renguangli at 2018/12/25 15:51
 *
 * @since JDK1.8
 */
public interface JobDetailService {

    PageInfo<JobDetail> listJobDetails(JobDetail jobDetail, int page, int size);
}
