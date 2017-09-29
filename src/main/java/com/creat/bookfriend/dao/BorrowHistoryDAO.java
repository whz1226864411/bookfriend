package com.creat.bookfriend.dao;

import com.creat.bookfriend.mapper.BorrowHistoryMapper;
import com.creat.bookfriend.po.BorrowHistory;
import com.creat.bookfriend.po.BorrowHistoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by whz on 2017/9/29.
 */
@Repository
public class BorrowHistoryDAO {

    @Autowired
    private BorrowHistoryMapper borrowHistoryMapper;

    public List<BorrowHistory> getBorrowedBook(Long userInfoId,Long bookInfoId){
        BorrowHistoryExample example = new BorrowHistoryExample();
        BorrowHistoryExample.Criteria criteria = example.createCriteria();
        criteria.andUserInfoIdEqualTo(userInfoId);
        criteria.andBookInfoIdEqualTo(bookInfoId);
        criteria.andStateEqualTo(new Byte("0"));
        return borrowHistoryMapper.selectByExample(example);
    }

   public void updateBorrowHistory(BorrowHistory borrowHistory){
        borrowHistoryMapper.updateByPrimaryKey(borrowHistory);
   }
}
