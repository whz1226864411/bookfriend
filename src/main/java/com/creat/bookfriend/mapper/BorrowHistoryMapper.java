package com.creat.bookfriend.mapper;

import com.creat.bookfriend.po.BorrowHistory;
import com.creat.bookfriend.po.BorrowHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowHistoryMapper {
    int countByExample(BorrowHistoryExample example);

    int deleteByExample(BorrowHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BorrowHistory record);

    int insertSelective(BorrowHistory record);

    List<BorrowHistory> selectByExample(BorrowHistoryExample example);

    BorrowHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BorrowHistory record, @Param("example") BorrowHistoryExample example);

    int updateByExample(@Param("record") BorrowHistory record, @Param("example") BorrowHistoryExample example);

    int updateByPrimaryKeySelective(BorrowHistory record);

    int updateByPrimaryKey(BorrowHistory record);
}