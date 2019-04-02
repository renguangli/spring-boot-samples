package com.renguangli.quartz;

import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * Created by renguangli at 2018/12/25 16:03
 *
 * @since JDK1.8
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SchedulerException.class)
    public ResponseResult schedulerExceptionHandler(SchedulerException e) {
        return new ResponseResult("请求失败", e.getMessage());
    }

}
