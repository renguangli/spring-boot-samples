package com.renguangli.springbootmail;

import com.renguangli.springbootmail.common.Code;
import com.renguangli.springbootmail.common.Result;
import com.renguangli.springbootmail.common.ResultBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.Set;

/*
 *
 * Created by renguangli at 2018/9/5 23:10
 * @since JDK1.8
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 请求方法不支持异常处理
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e){
        Set<HttpMethod> supportedHttpMethods = e.getSupportedHttpMethods();
        return new Result(Code.NOT_SUPPORTED_METHOD.getCode(), e.getMessage() + "; Only supported " + supportedHttpMethods + " methods.");
    }

    /**
     * 拦截 MethodArgumentTypeMismatchException 异常
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException e){
        return new Result(Code.BAD_REQUEST.getCode(), e.getMessage());
    }

    /**
     * 参数校验异常处理
     */
    @ExceptionHandler(BindException.class)
    public Result bindExceptionHandler(BindException e){
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError : fieldErrors) {
            sb.append(fieldError.getDefaultMessage());
        }
        return new Result(Code.BAD_REQUEST.getCode(), sb.toString());
    }

    /**
     * 拦截所有运行时异常
     */
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e) {
        return ResultBuilder.custom()
                .setCode(Code.INTERNAL_SERVER_ERROR.getCode())
                .setMessage(Code.INTERNAL_SERVER_ERROR.getMessage() + " - " + e.getMessage())
                .build();
    }
}
