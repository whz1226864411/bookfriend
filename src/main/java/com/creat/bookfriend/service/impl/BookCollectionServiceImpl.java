package com.creat.bookfriend.service.impl;

import com.creat.bookfriend.dao.BookCollectionDAO;
import com.creat.bookfriend.po.BookCollection;
import com.creat.bookfriend.service.BookCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by whz on 2017/9/28.
 */
@Service
public class BookCollectionServiceImpl implements BookCollectionService{

    @Autowired
    private BookCollectionDAO bookCollectionDAO;

    @Override
    @Transactional
    public void collectBook(Long bookInfoId, Long userInfoId) {
        BookCollection bookCollection = completeCollection(bookInfoId, userInfoId);
        bookCollectionDAO.saveBookCollection(bookCollection);
    }

    private BookCollection completeCollection(Long bookInfoId, Long userInfoId){
        BookCollection bookCollection = new BookCollection();
        bookCollection.setBookInfoId(bookInfoId);
        bookCollection.setUserInfoId(userInfoId);
        bookCollection.setGmtCreate(new Date());
        bookCollection.setGmtModified(new Date());
        return bookCollection;
    }
}
