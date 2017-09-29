package com.creat.bookfriend.service.impl;

import com.creat.bookfriend.dao.BookTagDAO;
import com.creat.bookfriend.po.BookTag;
import com.creat.bookfriend.service.BookTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by whz on 2017/9/26.
 */
@Service
public class BookTagServiceImpl implements BookTagService{

    @Autowired
    private BookTagDAO bookTagDAO;

    @Override
    @Transactional
    public List<BookTag> getBookTagsByCategoryId(Integer categoryId) {
        return bookTagDAO.getBookTagsByCategoryId(categoryId);
    }
}
