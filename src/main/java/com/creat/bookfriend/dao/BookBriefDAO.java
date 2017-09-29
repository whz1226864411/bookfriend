package com.creat.bookfriend.dao;

import com.creat.bookfriend.mapper.BookBriefMapper;
import com.creat.bookfriend.po.BookBrief;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by whz on 2017/9/26.
 */
@Repository
public class BookBriefDAO {
    @Autowired
    private BookBriefMapper bookBriefMapper;

    public void saveBookBrief(BookBrief bookBrief){
        bookBriefMapper.insert(bookBrief);
    }
}
