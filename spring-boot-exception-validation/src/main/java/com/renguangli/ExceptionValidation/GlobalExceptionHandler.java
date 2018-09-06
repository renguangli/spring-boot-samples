package com.renguangli.ExceptionValidation;

import com.renguangli.ExceptionValidation.common.Code;
import com.renguangli.ExceptionValidation.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/*
 * 全局异常处理
 * Created by renguangli at 2018/9/1 12:01
 * @since JDK1.8
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e){
        log.error(e.getMessage());
        return new Result(Code.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }

    /**
     * 拦截 CommonException 的异常
     * @param e Exception
     * @return aa
     */
    @ExceptionHandler(IllegalStateException.class)
    @ResponseBody
    public Result illegalStateExceptionHandler(IllegalStateException e){
        return new Result(Code.INTERNAL_SERVER_ERROR.getCode(), "参数类型错误！" + e.getMessage());
    }

}
