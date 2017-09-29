package com.creat.bookfriend.service;

import com.creat.bookfriend.po.BookInfo;
import com.creat.bookfriend.po.BookInfoCustom;
import com.creat.bookfriend.po.BookInfoDetail;

import java.io.IOException;
import java.util.List;

/**
 * Created by whz on 2017/9/26.
 */
public interface BookInfoService {
    void saveBookInfoCustom(BookInfoCustom bookInfoCustom);
    BookInfo getBookInfoByIsbn(Long isbn) throws IOException;
    BookInfoCustom getBookInfoCustomById(Long bookInfoId);
    BookInfoDetail getBookInfoDetailById(Long bookInfoId);
    List<BookInfo> getBookInfoByUserInfoId(Long userInfoId);
    List<BookInfo> getSameCityBooks(Long cityId, Integer num);
    List<BookInfo> getInterestBooks(Long userInfoId, Integer num);
    List<BookInfo> selectBooksByBookName(String bookName);
    List<BookInfo> getBorrowedBooks(Long userInfoId, Integer rows);
    List<BookInfo> getReadBooks(Long userInfoId, Integer rows);
    List<BookInfo> getCollectionBooks(Long userInfoId, Integer rows);
    void finishReadBook(Long bookInfoId,Long userInfoId);
}
