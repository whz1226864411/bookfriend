package com.creat.bookfriend.dao;

import com.creat.bookfriend.mapper.UserAccountMapper;
import com.creat.bookfriend.po.UserAccount;
import com.creat.bookfriend.po.UserAccountExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by whz on 2017/9/23.
 */
@Repository
public class UserAccountDAO {
    @Autowired
    private UserAccountMapper userAccountMapper;

    public void saveUserAccount(UserAccount userAccount){
        userAccountMapper.insert(userAccount);
    }

    public UserAccount getUserAccountById(Long userAccountId){
        return userAccountMapper.selectByPrimaryKey(userAccountId);
    }

    public UserAccount getUserAccountByTel(String userTel){
        UserAccountExample example = new UserAccountExample();
        UserAccountExample.Criteria criteria = example.createCriteria();
        criteria.andUserTelEqualTo(userTel);
        List<UserAccount> userAccountList = userAccountMapper.selectByExample(example);
        if(userAccountList.size() == 0){
            return null;
        }else {
            return userAccountList.get(0);
        }
    }
}
