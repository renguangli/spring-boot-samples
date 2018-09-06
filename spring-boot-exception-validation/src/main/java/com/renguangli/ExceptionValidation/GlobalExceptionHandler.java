package com.renguangli.ExceptionValidation;

import com.renguangli.ExceptionValidation.common.Code;
import com.renguangli.ExceptionValidation.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
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

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result bindException(BindException e){
        FieldError fieldError = e.getBindingResult().getFieldError();
        return new Result(Code.INTERNAL_SERVER_ERROR.getCode(), fieldError.getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e){
        log.error(e.getMessage());
        return new Result(Code.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }

}
