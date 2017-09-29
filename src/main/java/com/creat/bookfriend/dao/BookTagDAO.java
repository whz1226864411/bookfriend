package com.creat.bookfriend.dao;

import com.creat.bookfriend.mapper.BookTagMapper;
import com.creat.bookfriend.po.BookTag;
import com.creat.bookfriend.po.BookTagExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by whz on 2017/9/26.
 */
@Repository
public class BookTagDAO {

    @Autowired
    private BookTagMapper bookTagMapper;

    public List<BookTag> getBookTagsByCategoryId(Integer bookCategoryId){
        BookTagExample example = new BookTagExample();
        BookTagExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(bookCategoryId);
        return bookTagMapper.selectByExample(example);
    }
}
