package com.creat.bookfriend.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UserAttention {
    private Long id;

    private Long srcUserInforId;

    private Long attUserInfoId;
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

    public Long getSrcUserInforId() {
        return srcUserInforId;
    }

    public void setSrcUserInforId(Long srcUserInforId) {
        this.srcUserInforId = srcUserInforId;
    }

    public Long getAttUserInfoId() {
        return attUserInfoId;
    }

    public void setAttUserInfoId(Long attUserInfoId) {
        this.attUserInfoId = attUserInfoId;
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