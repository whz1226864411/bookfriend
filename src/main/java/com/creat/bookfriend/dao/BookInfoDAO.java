package com.creat.bookfriend.dao;

import com.creat.bookfriend.mapper.BookInfoCustomMapper;
import com.creat.bookfriend.mapper.BookInfoDetailMapper;
import com.creat.bookfriend.mapper.BookInfoMapper;
import com.creat.bookfriend.po.BookInfo;
import com.creat.bookfriend.po.BookInfoCustom;
import com.creat.bookfriend.po.BookInfoDetail;
import com.creat.bookfriend.po.BookInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

/**
 * Created by whz on 2017/9/26.
 */
@Repository
public class BookInfoDAO {

    @Autowired
    private BookInfoMapper bookInfoMapper;
    @Autowired
    private BookInfoCustomMapper bookInfoCustomMapper;
    @Autowired
    private BookInfoDetailMapper bookInfoDetailMapper;

    public List<BookInfo> getReadBooks(Long userInfoId, Integer rows){
        return bookInfoCustomMapper.selectReadBook(userInfoId,rows);
    }

    public List<BookInfo> getBorrowedBooks(Long userInfoId, Integer rows){
        return bookInfoCustomMapper.selectBorrowedBook(userInfoId,rows);
    }

    public BookInfoCustom getBookCustomByBookInfoId(Long bookInfoId){
        return bookInfoCustomMapper.selectBookInfoCustomById(bookInfoId);
    }

    public BookInfoDetail getBookInfoDetailById(Long bookInfoId){
        return bookInfoDetailMapper.getBookInfoDetailById(bookInfoId);
    }
    public void saveBookInfo(BookInfo bookInfo){
        bookInfoMapper.insert(bookInfo);
    }

    public List<BookInfo> getBookInfoByUserInfoId(Long userInfoId){
        BookInfoExample example = new BookInfoExample();
        BookInfoExample.Criteria criteria = example.createCriteria();
        criteria.andUserInfoIdEqualTo(userInfoId);
        return bookInfoMapper.selectByExample(example);
    }

    public List<BookInfo> getBooksLimit(Integer num){
        return bookInfoCustomMapper.selectBooksLimit(num);
    }

    public List<BookInfo> getBookInfoByCityId(Long cityId, Integer rows){
        return bookInfoCustomMapper.selectBooksByCityId(cityId,rows);
    }

    public List<BookInfo> selectBookInfoByBookName(String bookName){
        BookInfoExample example = new BookInfoExample();
        BookInfoExample.Criteria criteria = example.createCriteria();
        criteria.andBookNameLike("%"+bookName+"%");
        return bookInfoMapper.selectByExample(example);
    }

    public List<BookInfo> getCollectionBooks(Long userInfoId, Integer rows) {
        return bookInfoCustomMapper.selectCollectionBook(userInfoId,rows);
    }
}
