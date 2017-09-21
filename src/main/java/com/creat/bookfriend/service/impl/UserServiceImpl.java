package com.creat.bookfriend.service.impl;

import com.creat.bookfriend.service.UserService;
import com.creat.bookfriend.utils.sms.MessageSendUtil;
import com.creat.bookfriend.utils.sms.SMSException;
import com.creat.bookfriend.utils.sms.SMSParam;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/21.
 */
@Service
public class UserServiceImpl implements UserService{
    //注入短信参数
    @Autowired
    private SMSParam smsParam;


    public void sendSMS(String userTel,String codeValue) throws SMSException {
        Map<String,String> param = new HashMap<>();
        param.put(smsParam.getParamName(),codeValue);
        MessageSendUtil messageSend = new MessageSendUtil(smsParam);
        messageSend.send(JSONObject.fromObject(param).toString(),userTel);
    }
}
