package com.renguangli.springbootmail;

import com.renguangli.springbootmail.common.Code;
import com.renguangli.springbootmail.common.Result;
import com.renguangli.springbootmail.common.ResultBuilder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 *
 * Created by renguangli at 2018/9/5 23:10
 * @since JDK1.8
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e) {
        return ResultBuilder.custom()
                .setCode(Code.INTERNAL_SERVER_ERROR.getCode())
                .setMessage(Code.INTERNAL_SERVER_ERROR.getMessage() + " - " + e.getMessage())
                .build();
    }
}
