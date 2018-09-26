package com.renguangli.exceptionValidation;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {

    private String error;

    private Object data;

    private Long count;

    private Integer page;

    private Integer size;

    public Result() {}

    public Result(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Result{" +
                "error=" + error +
                ", data=" + data +
                ", count=" + count +
                ", page=" + page +
                ", size=" + size +
                "}";
    }
}
