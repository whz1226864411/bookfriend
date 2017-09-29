package com.creat.bookfriend.mapper;

import com.creat.bookfriend.po.UserInfo;
import com.creat.bookfriend.po.UserInfoCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by whz on 2017/9/23.
 */
public interface UserInfoCustomMapper {
    UserInfoCustom selectUserInfoByUaId(Long userAccountId);
    List<UserInfo> selectFriendInfo(@Param("srcUserInfoId") Long srcUserInfoId);
}
