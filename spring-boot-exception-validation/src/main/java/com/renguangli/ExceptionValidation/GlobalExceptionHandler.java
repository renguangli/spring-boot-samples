package com.renguangli.ExceptionValidation;

import com.renguangli.ExceptionValidation.common.Code;
import com.renguangli.ExceptionValidation.common.Result;
import org.springframework.util.ClassUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


/*
 * 全局异常处理
 * Created by renguangli at 2018/9/1 12:01
 * @since JDK1.8
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result bindExceptionHandler(BindException e){
        FieldError fieldError = e.getBindingResult().getFieldError();
        return new Result(Code.INTERNAL_SERVER_ERROR.getCode(), fieldError.getDefaultMessage());
    }

    /**
     * 拦截 IllegalStateException 异常
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public Result methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException e){
        Class<?> requiredType = e.getRequiredType();
        String message = "参数类型错误，请传入" + ClassUtils.getQualifiedName(requiredType) + "类型参数！";
        return new Result(Code.INTERNAL_SERVER_ERROR.getCode(), message);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e){
        return new Result(Code.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }

}
