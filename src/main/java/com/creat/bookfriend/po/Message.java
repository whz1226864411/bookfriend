package com.creat.bookfriend.po;

/**
 * Created by whz on 2017/9/21.
 */
public class Message {
    public static final String SUCCESS = "200";
    public static final String UNKNOWN_ERROR = "201";
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
