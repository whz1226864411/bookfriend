package com.creat.bookfriend.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Province {
    private Long provinceId;

    private String provinceName;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Shanghai")
    private Date gmtCreate;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Shanghai")
    private Date gmtModified;

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
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