package com.creat.bookfriend.mapper;

import com.creat.bookfriend.po.BookBrief;
import com.creat.bookfriend.po.BookBriefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookBriefMapper {
    int countByExample(BookBriefExample example);

    int deleteByExample(BookBriefExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BookBrief record);

    int insertSelective(BookBrief record);

    List<BookBrief> selectByExample(BookBriefExample example);

    BookBrief selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BookBrief record, @Param("example") BookBriefExample example);

    int updateByExample(@Param("record") BookBrief record, @Param("example") BookBriefExample example);

    int updateByPrimaryKeySelective(BookBrief record);

    int updateByPrimaryKey(BookBrief record);
}