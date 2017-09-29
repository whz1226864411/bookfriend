package com.creat.bookfriend.po;

import java.util.List;

/**
 * Created by whz on 2017/9/27.
 */
public class BooksMessage extends Message{

    private List<BookInfo> bookInfoList;

    public List<BookInfo> getBookInfoList() {
        return bookInfoList;
    }

    public void setBookInfoList(List<BookInfo> bookInfoList) {
        this.bookInfoList = bookInfoList;
    }
}
