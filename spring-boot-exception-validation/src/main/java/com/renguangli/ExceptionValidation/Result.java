package com.renguangli.ExceptionValidation;

/*
 *
 * Created by renguangli at 2018/9/1 13:38
 * @since JDK1.8
 */
public class Result {

    private int code;

    private String message;

    public Result(){}

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
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

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
