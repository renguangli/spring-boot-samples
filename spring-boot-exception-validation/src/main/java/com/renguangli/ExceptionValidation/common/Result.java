package com.renguangli.ExceptionValidation.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result implements Serializable {

    private int code = Code.SUCCESS.getCode();

    private String message = Code.SUCCESS.getMessage();

    private Long count;

    private Object data;

    public Result() {}

    public Result(Long count, Object data) {
        this.count = count;
        this.data = data;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, Long count, Object data) {
        this.code = code;
        this.message = message;
        this.count = count;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message=" + message +
                ", count=" + count +
                ", data=" + data +
                "}";
    }
}
