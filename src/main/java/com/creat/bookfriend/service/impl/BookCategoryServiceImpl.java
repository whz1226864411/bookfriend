package com.creat.bookfriend.service.impl;

import com.creat.bookfriend.dao.BookCategoryDAO;
import com.creat.bookfriend.po.BookCategory;
import com.creat.bookfriend.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by whz on 2017/9/26.
 */
@Service
public class BookCategoryServiceImpl implements BookCategoryService{
    @Autowired
    private BookCategoryDAO bookCategoryDAO;

    @Override
    @Transactional
    public List<BookCategory> getAllBookCategory() {
        return bookCategoryDAO.getAllBookCategory();
    }
}
