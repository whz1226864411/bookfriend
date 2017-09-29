package com.creat.bookfriend.service;

import com.creat.bookfriend.po.UserAccount;
import com.creat.bookfriend.po.UserInfo;
import com.creat.bookfriend.service.impl.UserException;
import com.creat.bookfriend.utils.sms.SMSException;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by whz on 2017/9/21.
 */
public interface UserService {
    void sendSMS(String userTel,String codeValue) throws SMSException;
    void register(UserAccount userAccount, UserInfo userInfo) throws NoSuchAlgorithmException, UserException;
    UserInfo login(UserAccount userAccount) throws NoSuchAlgorithmException;
    void updateUserInfo(UserInfo userInfo);
    List<UserInfo> getInterestUser(Long userInfoId, Integer num);
    UserInfo getUserInfoByUserInfoId(Long userInfoId);
}
