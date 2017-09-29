package com.creat.bookfriend.po;

/**
 * Created by whz on 2017/9/23.
 */
public class UserInfoCustom extends UserInfo{
    private String cityName;
    private String provinceName;
    private String districtName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}
