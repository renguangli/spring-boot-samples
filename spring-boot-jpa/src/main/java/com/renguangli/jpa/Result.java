package com.renguangli.jpa;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {

    private int code;

    private String msg = "SUCCESS";

    private Object data;

    private Long count;

    private Integer page;

    private Integer size;

    public Result() {}

    public Result(Object data, Long count) {
        this.data = data;
        this.count = count;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
                "code=" + code +
                ", msg=" + msg +
                ", data=" + data +
                ", count=" + count +
                ", page=" + page +
                ", size=" + size +
                "}";
    }

}
