package com.renguangli.quartz;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * spring-boot-quartz
 * Created by renguangli at 2018/12/25 15:28
 *
 * @since JDK1.8
 */

//将该标记放在属性上，如果该属性为NULL则不参与序列化
//如果放在类上边,那对这个类的全部属性起作用
//Include.Include.ALWAYS 默认
//Include.NON_DEFAULT 属性为默认值不序列化
//Include.NON_EMPTY 属性为 空（“”） 或者为 NULL 都不序列化
//Include.NON_NULL 属性为NULL 不序列化
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseResult {

    private Integer code;

    private String message;

    private Boolean success;

    private Object data;

    private String error;

    public ResponseResult(){}

    public ResponseResult(String message) {
        this.message = message;
    }

    public ResponseResult(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public ResponseResult(String message, Boolean success, Object data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public ResponseResult(Integer code, String message, Boolean success, Object data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", success=" + success +
                ", data=" + data +
                ", error='" + error + '\'' +
                '}';
    }
}
