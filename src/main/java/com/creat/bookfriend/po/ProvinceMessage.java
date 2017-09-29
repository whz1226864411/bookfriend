package com.creat.bookfriend.po;

import java.util.List;

/**
 * Created by whz on 2017/9/24.
 */
public class ProvinceMessage extends Message{
    private List<Province> provinces;

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }
}
