package com.renguangli.springbootmail.common;

/*
 * 通用返回码
 * Created by renguangli at 2018/9/5 23:30
 * @since JDK1.8
 */
public enum Code {

    SUCCESS(0,"success"),

    INTERNAL_SERVER_ERROR(5000,"internal server error");

    private final int code;

    private final String message;

    Code(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }
}
