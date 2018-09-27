package com.renguangli.mybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Set;


/*
 * 全局异常处理
 * Created by renguangli at 2018/9/1 12:01
 * @since JDK1.8
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 请求方法不支持异常处理
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e){
        Set<HttpMethod> supportedHttpMethods = e.getSupportedHttpMethods();
        return new Result(e.getMessage() + "; Only supported " + supportedHttpMethods + " methods.");
    }

    /**
     * 防止用户传入不正确的参数类型
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException e){
        return new Result(e.getMessage());
    }

    /**
     * 参数校验异常处理
     */
    @ExceptionHandler(BindException.class)
    public Result bindExceptionHandler(BindException e){
        FieldError fieldError = e.getBindingResult().getFieldError();
        return new Result(fieldError.getDefaultMessage());
    }

    /**
     * 服务器异常处理
     */
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e){
        log.error(e.getMessage());
        return new Result(e.getMessage());
    }

}
