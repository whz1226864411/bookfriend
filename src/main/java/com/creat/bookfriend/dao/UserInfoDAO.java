package com.creat.bookfriend.dao;

import com.creat.bookfriend.mapper.UserInfoCustomMapper;
import com.creat.bookfriend.mapper.UserInfoMapper;
import com.creat.bookfriend.po.UserInfo;
import com.creat.bookfriend.po.UserInfoCustom;
import com.creat.bookfriend.po.UserInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by whz on 2017/9/23.
 */
@Repository
public class UserInfoDAO {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserInfoCustomMapper userInfoCustomMapper;

    public void saveUserInfo(UserInfo userInfo){
        userInfoMapper.insert(userInfo);
    }

    public UserInfoCustom getUserInforCustomByUaId(Long userAccountId){
        return userInfoCustomMapper.selectUserInfoByUaId(userAccountId);
    }
    public UserInfo getUserInfoById(Long userInfoId){
        return userInfoMapper.selectByPrimaryKey(userInfoId);
    }



    //数据模拟
    public List<UserInfo> getUserInfoLimit(Integer num){
        return userInfoMapper.getUserInfoListLimit(num);
    }
    public void updateUserInfo(UserInfo userInfo){
        userInfoMapper.updateByPrimaryKey(userInfo);
    }

}
