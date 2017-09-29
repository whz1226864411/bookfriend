package com.creat.bookfriend.mapper;

import com.creat.bookfriend.po.BookImg;
import com.creat.bookfriend.po.BookImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookImgMapper {
    int countByExample(BookImgExample example);

    int deleteByExample(BookImgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BookImg record);

    int insertSelective(BookImg record);

    List<BookImg> selectByExample(BookImgExample example);

    BookImg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BookImg record, @Param("example") BookImgExample example);

    int updateByExample(@Param("record") BookImg record, @Param("example") BookImgExample example);

    int updateByPrimaryKeySelective(BookImg record);

    int updateByPrimaryKey(BookImg record);
}