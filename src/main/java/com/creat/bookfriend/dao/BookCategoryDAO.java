package com.creat.bookfriend.dao;

import com.creat.bookfriend.mapper.BookCategoryMapper;
import com.creat.bookfriend.po.BookCategory;
import com.creat.bookfriend.po.BookCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by whz on 2017/9/26.
 */
@Repository
public class BookCategoryDAO {

    @Autowired
    private BookCategoryMapper bookCategoryMapper;

    public List<BookCategory> getAllBookCategory(){
        return bookCategoryMapper.selectByExample(null);
    }
}
