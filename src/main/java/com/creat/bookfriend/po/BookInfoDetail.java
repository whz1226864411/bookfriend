package com.creat.bookfriend.po;

import java.util.List;

/**
 * Created by whz on 2017/9/27.
 */
public class BookInfoDetail extends BookInfo{
    private String briefText;
    private List<BookImg> bookImgs;
    private String srcUserName;

    public String getSrcUserName() {
        return srcUserName;
    }

    public void setSrcUserName(String srcUserName) {
        this.srcUserName = srcUserName;
    }

    public List<BookImg> getBookImgs() {
        return bookImgs;
    }

    public void setBookImgs(List<BookImg> bookImgs) {
        this.bookImgs = bookImgs;
    }

    public String getBriefText() {
        return briefText;
    }

    public void setBriefText(String briefText) {
        this.briefText = briefText;
    }
}
