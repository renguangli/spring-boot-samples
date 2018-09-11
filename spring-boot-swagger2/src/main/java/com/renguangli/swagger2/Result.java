package com.renguangli.swagger2;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {

    private String error;

    private Long count;

    private Object data;

    public Result() {}

    public Result(String error) {
        this.error = error;
    }

    public Result(Object data) {
        this.data = data;
    }

    public Result(Long count, Object data) {
        this.count = count;
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
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
                "error=" + error +
                ", count=" + count +
                ", data=" + data +
                "}";
    }
}
