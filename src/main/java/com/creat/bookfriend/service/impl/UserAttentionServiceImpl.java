package com.creat.bookfriend.service.impl;

import com.creat.bookfriend.dao.UserAttentionDAO;
import com.creat.bookfriend.dao.UserInfoDAO;
import com.creat.bookfriend.po.UserAttention;
import com.creat.bookfriend.po.UserInfo;
import com.creat.bookfriend.service.UserAttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by whz on 2017/9/30.
 */
@Service
public class UserAttentionServiceImpl implements UserAttentionService{
    @Autowired
    private UserInfoDAO userInfoDAO;
    @Autowired
    private UserAttentionDAO userAttentionDAO;

    @Override
    @Transactional
    public void attentUser(Long attUserInfoId, Long srcUserInfoId) {
        UserInfo attUserInfo = userInfoDAO.getUserInfoById(attUserInfoId);
        attUserInfo.setFansNum(attUserInfo.getFansNum()+1);
        attUserInfo.setGmtModified(new Date());
        userInfoDAO.updateUserInfo(attUserInfo);
        UserInfo srcUserInfo = userInfoDAO.getUserInfoById(srcUserInfoId);
        srcUserInfo.setAttentionNum(srcUserInfo.getAttentionNum()+1);
        srcUserInfo.setGmtModified(new Date());
        userInfoDAO.updateUserInfo(srcUserInfo);
        UserAttention userAttention = completeUserAttention(attUserInfoId,srcUserInfoId);
        userAttentionDAO.saveUserAttention(userAttention);
    }

    @Override
    @Transactional
    public void cancelAttentUser(Long attUserInfoId, Long srcUserInfoId) {
        UserInfo attUserInfo = userInfoDAO.getUserInfoById(attUserInfoId);
        attUserInfo.setFansNum(attUserInfo.getFansNum()-1);
        attUserInfo.setGmtModified(new Date());
        userInfoDAO.updateUserInfo(attUserInfo);
        UserInfo srcUserInfo = userInfoDAO.getUserInfoById(srcUserInfoId);
        srcUserInfo.setAttentionNum(srcUserInfo.getAttentionNum()-1);
        srcUserInfo.setGmtModified(new Date());
        userInfoDAO.updateUserInfo(srcUserInfo);
        userAttentionDAO.deleteAttention(attUserInfoId,srcUserInfoId);
    }

    @Override
    @Transactional
    public List<UserInfo> getUserAttentionByUserInfoId(Long userInfoId) {
        return userAttentionDAO.getUserInfoBySrcId(userInfoId);
    }

    private UserAttention completeUserAttention(Long attUserInfoId, Long srcUserInfoId){
        UserAttention userAttention = new UserAttention();
        userAttention.setSrcUserInforId(srcUserInfoId);
        userAttention.setAttUserInfoId(attUserInfoId);
        userAttention.setGmtCreate(new Date());
        userAttention.setGmtModified(new Date());
        return userAttention;
    }
}
