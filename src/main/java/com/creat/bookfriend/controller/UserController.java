package com.creat.bookfriend.controller;

import com.creat.bookfriend.po.Message;
import com.creat.bookfriend.po.VerifyCode;
import com.creat.bookfriend.service.UserService;
import com.creat.bookfriend.utils.random.RandomNum;
import com.creat.bookfriend.utils.sms.SMSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by whz on 2017/9/21.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/sendSMS",method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Message sendSMS(String userTel, HttpSession session){
        Message message = new Message();
        try {
            String codeValue = new RandomNum().getNum(6);
            userService.sendSMS(userTel,codeValue);
            VerifyCode verifyCode = new VerifyCode();
            verifyCode.setCodeValue(codeValue);
            verifyCode.setCreateTime(new Date());
            verifyCode.setValidTime(5);
            session.setAttribute("verifyCode",verifyCode);
            message.setCode(Message.SUCCESS);
        } catch (SMSException e) {
            message.setCode(Message.UNKNOWN_ERROR);
            e.printStackTrace();
        }
        return message;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Message register(){
        Message message = new Message();
        return message;
    }
}
