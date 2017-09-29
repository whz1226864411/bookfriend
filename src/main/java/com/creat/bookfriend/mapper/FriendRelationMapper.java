package com.creat.bookfriend.mapper;

import com.creat.bookfriend.po.FriendRelation;
import com.creat.bookfriend.po.FriendRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendRelationMapper {
    int countByExample(FriendRelationExample example);

    int deleteByExample(FriendRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FriendRelation record);

    int insertSelective(FriendRelation record);

    List<FriendRelation> selectByExample(FriendRelationExample example);

    FriendRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FriendRelation record, @Param("example") FriendRelationExample example);

    int updateByExample(@Param("record") FriendRelation record, @Param("example") FriendRelationExample example);

    int updateByPrimaryKeySelective(FriendRelation record);

    int updateByPrimaryKey(FriendRelation record);
}