package com.creat.bookfriend.po;

/**
 * Created by whz on 2017/9/23.
 */
public class UserInfoMessage extends Message{

    public static final String ACCOUNT_OR_PW_ERROR = "400";
    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
