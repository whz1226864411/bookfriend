package com.creat.bookfriend.dao;

import com.creat.bookfriend.mapper.BookCollectionMapper;
import com.creat.bookfriend.po.BookCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by whz on 2017/9/28.
 */
@Repository
public class BookCollectionDAO {

    @Autowired
    private BookCollectionMapper bookCollectionMapper;

    public void saveBookCollection(BookCollection bookCollection){
        bookCollectionMapper.insert(bookCollection);
    }
}
