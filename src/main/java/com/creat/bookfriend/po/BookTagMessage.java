package com.creat.bookfriend.po;

import java.util.List;

/**
 * Created by whz on 2017/9/26.
 */
public class BookTagMessage extends Message{

    private List<BookTag> bookTags;

    public List<BookTag> getBookTags() {
        return bookTags;
    }

    public void setBookTags(List<BookTag> bookTags) {
        this.bookTags = bookTags;
    }
}
