package com.creat.bookfriend.service.impl;

import com.creat.bookfriend.dao.CityDAO;
import com.creat.bookfriend.dao.DistrictDAO;
import com.creat.bookfriend.dao.ProvinceDAO;
import com.creat.bookfriend.mapper.ProvinceMapper;
import com.creat.bookfriend.po.City;
import com.creat.bookfriend.po.District;
import com.creat.bookfriend.po.Province;
import com.creat.bookfriend.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by whz on 2017/9/24.
 */
@Service
public class PlaceServiceImpl implements PlaceService{
    @Autowired
    private ProvinceDAO provinceDAO;
    @Autowired
    private CityDAO cityDAO;
    @Autowired
    private DistrictDAO districtDAO;

    @Override
    @Transactional
    public List<Province> getAllProvince() {
        return provinceDAO.getAllProvinces();
    }

    @Override
    @Transactional
    public List<City> getCitiesByProvinceId(Long provinceId) {
        return cityDAO.getCitiesByProvinceId(provinceId);
    }

    @Override
    @Transactional
    public List<District> getDistrictsByCityId(Long cityId) {
        return districtDAO.getDistrictsByCityId(cityId);
    }

    @Override
    @Transactional
    public City getCityByCityName(String cityName) {
        return cityDAO.getCityByCityName(cityName);
    }
}
