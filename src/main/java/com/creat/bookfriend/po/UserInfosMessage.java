package com.creat.bookfriend.po;

import java.util.List;

/**
 * Created by whz on 2017/9/28.
 */
public class UserInfosMessage extends Message{
    private List<UserInfo> userInfoList;

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }
}
