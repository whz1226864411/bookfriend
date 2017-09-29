package com.creat.bookfriend.po;

import java.util.List;

/**
 * Created by whz on 2017/9/24.
 */
public class CityMessage extends Message{
    private List<City> cities;

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
