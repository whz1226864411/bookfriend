package com.creat.bookfriend.dao;

import com.creat.bookfriend.mapper.UserAccountMapper;
import com.creat.bookfriend.mapper.UserAttentionMapper;
import com.creat.bookfriend.mapper.UserInfoCustomMapper;
import com.creat.bookfriend.po.UserAttention;
import com.creat.bookfriend.po.UserAttentionExample;
import com.creat.bookfriend.po.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by whz on 2017/9/30.
 */
@Repository
public class UserAttentionDAO {
    @Autowired
    private UserAttentionMapper userAttentionMapper;
    @Autowired
    private UserInfoCustomMapper userInfoCustomMapper;

    public void saveUserAttention(UserAttention userAttention){
        userAttentionMapper.insert(userAttention);
    }

    public List<UserAttention> getUserAttentionByAttId(Long attUserInfoId){
        UserAttentionExample example = new UserAttentionExample();
        UserAttentionExample.Criteria criteria = example.createCriteria();
        criteria.andAttUserInfoIdEqualTo(attUserInfoId);
        return userAttentionMapper.selectByExample(example);
    }

    public List<UserInfo> getUserInfoBySrcId(Long srcUserInfoId){
        return userInfoCustomMapper.selectFriendInfo(srcUserInfoId);
    }

    public void deleteAttention(Long attUserInfoId, Long srcUserInfoId){
        UserAttentionExample example = new UserAttentionExample();
        UserAttentionExample.Criteria criteria = example.createCriteria();
        criteria.andAttUserInfoIdEqualTo(attUserInfoId);
        criteria.andSrcUserInforIdEqualTo(srcUserInfoId);
        userAttentionMapper.deleteByExample(example);
    }

}
