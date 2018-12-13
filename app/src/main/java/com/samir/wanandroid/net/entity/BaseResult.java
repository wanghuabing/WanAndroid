package com.samir.wanandroid.net.entity;

/**
 * @Description:
 */
public class BaseResult<T> {
    private  int code;
    private  String errorMsg;
    private  T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "code ="+code+" errorMsg="+errorMsg+" data="+data;
    }
}
