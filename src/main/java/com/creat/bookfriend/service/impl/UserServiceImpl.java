package com.creat.bookfriend.service.impl;

import com.creat.bookfriend.dao.UserAccountDAO;
import com.creat.bookfriend.dao.UserInfoDAO;
import com.creat.bookfriend.po.UserAccount;
import com.creat.bookfriend.po.UserInfo;
import com.creat.bookfriend.service.UserService;
import com.creat.bookfriend.utils.md5.Encryption;
import com.creat.bookfriend.utils.sms.MessageSendUtil;
import com.creat.bookfriend.utils.sms.SMSException;
import com.creat.bookfriend.utils.sms.SMSParam;
import com.creat.bookfriend.utils.uutil.UUIDUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by whz on 2017/9/21.
 */
@Service
public class UserServiceImpl implements UserService{
    //注入短信参数
    @Autowired
    private SMSParam smsParam;
    @Autowired
    private UserAccountDAO userAccountDAO;
    @Autowired
    private UserInfoDAO userInfoDAO;

    @Override
    public void sendSMS(String userTel,String codeValue) throws SMSException {
        Map<String,String> param = new HashMap<>();
        param.put(smsParam.getParamName(),codeValue);
        MessageSendUtil messageSend = new MessageSendUtil(smsParam);
        messageSend.send(JSONObject.fromObject(param).toString(),userTel);
    }

    @Override
    @Transactional
    public void register(UserAccount userAccount, UserInfo userInfo) throws NoSuchAlgorithmException, UserException {
        UserAccount accountExist = userAccountDAO.getUserAccountByTel(userAccount.getUserTel());
        if(accountExist != null){
            throw new UserException("手机号已被注册！");
        }
        completeUserAccount(userAccount);
        userAccountDAO.saveUserAccount(userAccount);
        completeUserInfo(userInfo,userAccount.getId());
        userInfoDAO.saveUserInfo(userInfo);
    }

    @Override
    @Transactional
    public UserInfo login(UserAccount userAccount) throws NoSuchAlgorithmException {
        UserAccount userAccountExist = userAccountDAO.getUserAccountByTel(userAccount.getUserTel());
        if(userAccountExist != null &&
                Encryption.equalMD5(userAccount.getUserPw(),userAccountExist.getUserPw())){
            return userInfoDAO.getUserInforCustomByUaId(userAccountExist.getId());
        }else {
            return null;
        }
    }

    @Override
    @Transactional
    public void updateUserInfo(UserInfo userInfo) {
        userInfoDAO.updateUserInfo(userInfo);
    }

    @Override
    @Transactional
    public List<UserInfo> getInterestUser(Long userInfoId, Integer num) {
        //暂时进行数据模拟
        return userInfoDAO.getUserInfoLimit(num);
    }

    @Override
    @Transactional
    public UserInfo getUserInfoByUserInfoId(Long userInfoId) {
        return userInfoDAO.getUserInfoById(userInfoId);
    }

    private void completeUserAccount(UserAccount userAccount) throws NoSuchAlgorithmException {
        userAccount.setGmtCreate(new Date());
        userAccount.setGmtModified(new Date());
        userAccount.setUserPw(Encryption.stringMD5(userAccount.getUserPw()));
    }

    private void completeUserInfo(UserInfo userInfo,Long userAccountId){
        userInfo.setUserAccountId(userAccountId);
        userInfo.setAttentionNum(0);
        userInfo.setFansNum(0);
        userInfo.setSex(Boolean.TRUE);
        userInfo.setUserName(UUIDUtil.getUUID().substring(15));
        userInfo.setGmtCreate(new Date());
        userInfo.setGmtModified(new Date());
    }
}
