package com.creat.bookfriend.service;

import com.creat.bookfriend.po.City;
import com.creat.bookfriend.po.District;
import com.creat.bookfriend.po.Province;

import java.util.List;

/**
 * Created by whz on 2017/9/24.
 */
public interface PlaceService {

    List<Province> getAllProvince();

    List<City> getCitiesByProvinceId(Long provinceId);

    List<District> getDistrictsByCityId(Long provinceId);

    City getCityByCityName(String cityName);
}
