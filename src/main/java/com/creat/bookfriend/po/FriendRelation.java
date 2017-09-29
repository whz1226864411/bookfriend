package com.creat.bookfriend.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class FriendRelation {
    private Long id;

    private Long srcUserInfoId;

    private Long friendUserInfoId;
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

    public Long getSrcUserInfoId() {
        return srcUserInfoId;
    }

    public void setSrcUserInfoId(Long srcUserInfoId) {
        this.srcUserInfoId = srcUserInfoId;
    }

    public Long getFriendUserInfoId() {
        return friendUserInfoId;
    }

    public void setFriendUserInfoId(Long friendUserInfoId) {
        this.friendUserInfoId = friendUserInfoId;
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