package com.creat.bookfriend.mapper;

import com.creat.bookfriend.po.BookTag;
import com.creat.bookfriend.po.BookTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookTagMapper {
    int countByExample(BookTagExample example);

    int deleteByExample(BookTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BookTag record);

    int insertSelective(BookTag record);

    List<BookTag> selectByExample(BookTagExample example);

    BookTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BookTag record, @Param("example") BookTagExample example);

    int updateByExample(@Param("record") BookTag record, @Param("example") BookTagExample example);

    int updateByPrimaryKeySelective(BookTag record);

    int updateByPrimaryKey(BookTag record);
}