package com.creat.bookfriend.controller;

import com.creat.bookfriend.po.*;
import com.creat.bookfriend.service.UserService;
import com.creat.bookfriend.service.impl.UserException;
import com.creat.bookfriend.utils.random.RandomNum;
import com.creat.bookfriend.utils.sms.SMSException;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * Created by whz on 2017/9/21.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserInfoById",method = {RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message getUserInfoById(Long userInfoId){
        UserInfoMessage message = new UserInfoMessage();
        message.setUserInfo(userService.getUserInfoByUserInfoId(userInfoId));
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功!");
        return message;
    }

    @RequestMapping(value = "/getUserNameByUserInfoId",method = {RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message getUserNameByUserInfoId(Long userInfoId){
        UserNameMessage message = new UserNameMessage();
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功!");
        message.setUserName(userService.getUserInfoByUserInfoId(userInfoId).getUserName());
        return message;
    }

    //获取感兴趣的用户
    @RequestMapping(value = "/getInterestUser",method = {RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message getInterestUser(Integer num, HttpSession session){
        UserInfosMessage message = new UserInfosMessage();
        if(num == null){
            message.setCode(Message.PARAMS_ERROR);
            message.setMsg("参数错误!");
            return message;
        }
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        Long userInfoId = null;
        if(userInfo != null){
            userInfoId = userInfo.getId();
        }
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功!");
        message.setUserInfoList(userService.getInterestUser(userInfoId,num));
        return message;
    }

    //修改信息
    @RequestMapping(value = "/modifyUserInfo",method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message modifyUserInfo(UserInfo userInfo,HttpSession session){
        Message message = new Message();
        UserInfo userInfoInSession = (UserInfo) session.getAttribute("userInfo");
        modifyUserInfoInSession(userInfo,userInfoInSession);
        userService.updateUserInfo(userInfoInSession);
        return message;
    }

    /**
     * 退出
     * @param session
     * @return
     */
    @RequestMapping(value = "/quit",method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message quit(HttpSession session){
        Message message = new Message();
        session.invalidate();
        message.setCode(Message.SUCCESS);
        message.setMsg("退出成功！");
        return message;
    }

    /**
     * 获取已登录用户信息
     * @param session
     * @return
     */
    @RequestMapping(value = "/getLoginUserInfo",method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message getLoginUserInfo(HttpSession session){
        UserInfoMessage message = new UserInfoMessage();
        message.setCode(Message.SUCCESS);
        message.setUserInfo((UserInfo) session.getAttribute("userInfo"));
        return message;
    }
    /**
     * 登录
     * @param userAccount
     * @param session
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message login(UserAccount userAccount,HttpSession session){
        UserInfoMessage message = new UserInfoMessage();
        try {
            UserInfo userInfo = userService.login(userAccount);
            if(userInfo != null){
                message.setCode(Message.SUCCESS);
                message.setMsg("登录成功！");
                message.setUserInfo(userInfo);
                session.setAttribute("userInfo",userInfo);
            }else {
                message.setCode(UserInfoMessage.ACCOUNT_OR_PW_ERROR);
                message.setMsg("账号或密码错误！");
            }
        } catch (NoSuchAlgorithmException e) {
            message.setCode(Message.UNKNOWN_ERROR);
            message.setMsg("未知错误！");
            logger.error(e.getMessage());
        }
        return message;
    }
    /**
     * 发送短信验证码
     * @param userTel
     * @param session
     * @return
     */
    @RequestMapping(value = "/sendSMS",method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message sendSMS(String userTel, HttpSession session){
        Message message = new Message();
        if(userTel == null || userTel.trim().length() != 11){
            message.setCode(Message.PARAMS_ERROR);
            message.setMsg("手机号不能为空!必须为11位");
        }
        try {
            VerifyCode verifyCodeInSession = (VerifyCode) session.getAttribute("verifyCode");
            if(verifyCodeInSession != null
                    && (verifyCodeInSession.getCreateTime().getTime()+60*1000) > new Date().getTime()){
                message.setCode(Message.CAN_NOT_SEND_ERROR);
                message.setMsg("60内无法发送！");
                return message;
            }
            String codeValue = new RandomNum().getNum(6);
            userService.sendSMS(userTel,codeValue);
            VerifyCode verifyCode = wrapVerifyCode(codeValue);
            session.setAttribute("verifyCode",verifyCode);
            message.setCode(Message.SUCCESS);
        } catch (SMSException e) {
            message.setCode(Message.UNKNOWN_ERROR);
            message.setMsg(e.getMessage());
            logger.error("手机号:"+userTel+"->"+e.getMessage());
        }
        return message;
    }

    /**
     * 注册
     * @param registerDto
     * @param session
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message register(RegisterDto registerDto, HttpSession session){
        Message message = null;
        String verifyCodeIn = registerDto.getVerifyCode();
        VerifyCode verifyCodeSession = (VerifyCode) session.getAttribute("verifyCode");
        message = verifyCode(verifyCodeSession,verifyCodeIn);
        try {
            if(message.getCode().equals(Message.SUCCESS)){
                userService.register(registerDto,changeToUserInfor(registerDto));
            }else {
                message.setMsg("验证码错误！");
            }
        } catch (NoSuchAlgorithmException e) {
            message.setCode(Message.UNKNOWN_ERROR);
            message.setMsg("未知错误！");
            logger.error(e.getMessage());
        } catch (UserException e) {
            message.setCode(Message.HAS_BEEN_REGISTER);
            message.setMsg(e.getMessage());
        }
        if(verifyCodeSession!=null){
            session.removeAttribute("verifyCode");
        }
        return message;
    }

    /**
     * 从RegisterDto中提取UserInfo
     * @param registerDto
     * @return
     */
    private UserInfo changeToUserInfor(RegisterDto registerDto){
        UserInfo userInfo = new UserInfo();
        userInfo.setProvinceId(registerDto.getProvinceId());
        userInfo.setCityId(registerDto.getCityId());
        userInfo.setDistrictId(registerDto.getDistrictId());
        return userInfo;
    }
    /**
     * 校验验证码，
     * @param verifyCodeSession
     * @param verifyCodeIn
     * @return
     */
    private Message verifyCode(VerifyCode verifyCodeSession,String verifyCodeIn){
        Message message = new Message();
        if(verifyCodeSession != null
                && (verifyCodeSession.getCreateTime().getTime()+
                verifyCodeSession.getValidTime()*60*1000)> new Date().getTime()
                && verifyCodeSession.getCodeValue().equals(verifyCodeIn)){
            message.setCode(Message.SUCCESS);
        }else {
            message.setCode(Message.VERIFY_CODE_ERROR);
            message.setMsg("验证码错误！");
        }
        return message;
    }

    /**
     * 封装验证码
     * @param codeValue
     * @return
     */
    private VerifyCode wrapVerifyCode(String codeValue){
        VerifyCode verifyCode = new VerifyCode();
        verifyCode.setCodeValue(codeValue);
        verifyCode.setCreateTime(new Date());
        verifyCode.setValidTime(5);
        return verifyCode;
    }

    private void modifyUserInfoInSession(UserInfo userInfo,UserInfo userInfoInSession){
        userInfoInSession.setUserName(userInfo.getUserName());
        userInfoInSession.setFaviconUrl(userInfo.getFaviconUrl());
        userInfoInSession.setSignature(userInfo.getSignature());
        userInfoInSession.setSex(userInfo.getSex());
        userInfoInSession.setGmtModified(new Date());
    }
}
