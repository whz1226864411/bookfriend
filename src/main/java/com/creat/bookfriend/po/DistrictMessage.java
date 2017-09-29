package com.creat.bookfriend.po;

import java.util.List;

/**
 * Created by whz on 2017/9/24.
 */
public class DistrictMessage extends Message{

    private List<District> districts;

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }
}
