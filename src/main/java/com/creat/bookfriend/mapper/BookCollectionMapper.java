package com.creat.bookfriend.mapper;

import com.creat.bookfriend.po.BookCollection;
import com.creat.bookfriend.po.BookCollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookCollectionMapper {
    int countByExample(BookCollectionExample example);

    int deleteByExample(BookCollectionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BookCollection record);

    int insertSelective(BookCollection record);

    List<BookCollection> selectByExample(BookCollectionExample example);

    BookCollection selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BookCollection record, @Param("example") BookCollectionExample example);

    int updateByExample(@Param("record") BookCollection record, @Param("example") BookCollectionExample example);

    int updateByPrimaryKeySelective(BookCollection record);

    int updateByPrimaryKey(BookCollection record);
}