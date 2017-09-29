package com.creat.bookfriend.controller;

import com.creat.bookfriend.po.Message;
import com.creat.bookfriend.po.UserInfo;
import com.creat.bookfriend.po.UserInfosMessage;
import com.creat.bookfriend.service.UserAttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by whz on 2017/9/30.
 */
@RestController
@RequestMapping("/attention")
public class UserAttentionController {

    @Autowired
    private UserAttentionService userAttentionService;

    @RequestMapping(value = "/attentUser",method = {RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message attentUser(Long userInfoId, HttpSession session){
        Message message = new Message();
        UserInfo userInfoInSession = (UserInfo) session.getAttribute("userInfo");
        userAttentionService.attentUser(userInfoId,userInfoInSession.getId());
        message.setCode(Message.SUCCESS);
        message.setMsg("关注成功!");
        return message;
    }

    @RequestMapping(value = "/myFriend",method = {RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message myFriend(HttpSession session){
        UserInfosMessage message = new UserInfosMessage();
        UserInfo userInfoInSession = (UserInfo) session.getAttribute("userInfo");
        message.setUserInfoList(userAttentionService.getUserAttentionByUserInfoId(userInfoInSession.getId()));
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功!");
        return message;
    }

    @RequestMapping(value = "/cancelAttention",method = {RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message cancelAttention(Long userInfoId, HttpSession session){
        Message message = new Message();
        UserInfo userInfoInSession = (UserInfo) session.getAttribute("userInfo");
        userAttentionService.cancelAttentUser(userInfoId,userInfoInSession.getId());
        message.setCode(Message.SUCCESS);
        message.setMsg("取消关注成功!");
        return message;
    }
}
