package com.creat.bookfriend.service;

import com.creat.bookfriend.utils.sms.SMSException;

/**
 * Created by whz on 2017/9/21.
 */
public interface UserService {
    void sendSMS(String userTel,String codeValue) throws SMSException;
}
