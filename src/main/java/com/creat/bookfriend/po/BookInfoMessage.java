package com.creat.bookfriend.po;

/**
 * Created by whz on 2017/9/27.
 */
public class BookInfoMessage extends Message{

    public static final String NOT_GET_BOOK_INFO = "401";

    private BookInfo bookInfo;

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }
}
