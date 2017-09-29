package com.creat.bookfriend.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BookTag {
    private Integer id;

    private String tagName;

    private Integer categoryId;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Shanghai")
    private Date gmtCreate;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Shanghai")
    private Date gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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