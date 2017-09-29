package com.creat.bookfriend.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BookBrief {
    private Long id;

    private String briefText;
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

    public String getBriefText() {
        return briefText;
    }

    public void setBriefText(String briefText) {
        this.briefText = briefText == null ? null : briefText.trim();
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