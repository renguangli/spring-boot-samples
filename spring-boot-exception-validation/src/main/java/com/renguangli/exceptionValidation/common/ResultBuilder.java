package com.renguangli.exceptionValidation.common;


/*
 * ResultBuilder
 * Created by renguangli at 2018/9/5 23:13
 * @since JDK1.8
 */
public class ResultBuilder {

    private Result result = new Result();

    public static ResultBuilder custom() {
        return new ResultBuilder();
    }

    public ResultBuilder setCode(int code) {
        result.setCode(code);
        return this;
    }

    public ResultBuilder setMessage(String message) {
        result.setMessage(message);
        return this;
    }

    public ResultBuilder setData(Object data) {
        result.setData(data);
        return this;
    }

    public ResultBuilder setCount(Long count) {
        result.setCount(count);
        return this;
    }

    public Result build() {
        return result;
    }
}
