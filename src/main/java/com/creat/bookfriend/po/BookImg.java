package com.creat.bookfriend.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BookImg {
    private Long id;

    private String realImg;

    private Long bookInfoId;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Shanghai")
    private Date gmtCreate;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Shanghai")
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealImg() {
        return realImg;
    }

    public void setRealImg(String realImg) {
        this.realImg = realImg == null ? null : realImg.trim();
    }

    public Long getBookInfoId() {
        return bookInfoId;
    }

    public void setBookInfoId(Long bookInfoId) {
        this.bookInfoId = bookInfoId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}