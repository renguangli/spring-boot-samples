package com.renguangli.exceptionValidation;

import com.renguangli.exceptionValidation.common.Code;
import com.renguangli.exceptionValidation.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


/*
 * 全局异常处理
 * Created by renguangli at 2018/9/1 12:01
 * @since JDK1.8
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 防止用户传入不正确的参数类型
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException e){
        Class<?> requiredType = e.getRequiredType();
        String parameterName = e.getParameter().getParameterName();
        String message = "[" + parameterName + "]参数类型错误，请传入" + ClassUtils.getQualifiedName(requiredType) + "类型参数！";
        return new Result(Code.BAD_REQUEST.getCode(), message);
    }

    /**
     * 参数校验异常处理
     */
    @ExceptionHandler(BindException.class)
    public Result bindExceptionHandler(BindException e){
        FieldError fieldError = e.getBindingResult().getFieldError();
        return new Result(Code.BAD_REQUEST.getCode(), fieldError.getDefaultMessage());
    }

    /**
     * 服务器异常处理
     */
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e){
        return new Result(Code.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }

}
