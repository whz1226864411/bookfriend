package com.creat.bookfriend.po;

import java.util.List;

/**
 * Created by whz on 2017/9/26.
 */
public class BookCategoryMessage extends Message{

    private List<BookCategory> bookCategories;

    public List<BookCategory> getBookCategories() {
        return bookCategories;
    }

    public void setBookCategories(List<BookCategory> bookCategories) {
        this.bookCategories = bookCategories;
    }
}
