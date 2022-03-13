package com.cmx.entity;
import java.io.Serializable;
/**
 * 封装返回结果
 */
public class Result implements Serializable{
    private Integer code;//执行结果，200为执行成功 500为执行失败
    private Object data;//返回数据
    private String message;//返回提示信息，主要用于页面提示信息
    private Boolean success;//执行结果

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                ", success=" + success +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
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

    public Result(Integer code, Object data, String message, Boolean success) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.success = success;
    }

    public Result() {
    }
}
