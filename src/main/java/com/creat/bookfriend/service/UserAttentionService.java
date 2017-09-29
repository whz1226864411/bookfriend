package com.creat.bookfriend.service;

import com.creat.bookfriend.po.UserInfo;

import java.util.List;

/**
 * Created by whz on 2017/9/30.
 */
public interface UserAttentionService {

    void attentUser(Long attUserInfoId,Long srcUserInfoId);
    void cancelAttentUser(Long attUserInfoId,Long srcUserInfoId);
    List<UserInfo> getUserAttentionByUserInfoId(Long userInfoId);
}
