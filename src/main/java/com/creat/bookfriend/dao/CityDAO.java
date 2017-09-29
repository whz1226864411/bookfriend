package com.creat.bookfriend.dao;

import com.creat.bookfriend.mapper.CityMapper;
import com.creat.bookfriend.po.City;
import com.creat.bookfriend.po.CityExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by whz on 2017/9/24.
 */
@Repository
public class CityDAO {
    @Autowired
    private CityMapper cityMapper;

    public List<City> getCitiesByProvinceId(Long provinceId){
        CityExample cityExample = new CityExample();
        CityExample.Criteria criteria = cityExample.createCriteria();
        criteria.andProvinceIdEqualTo(provinceId);
        return cityMapper.selectByExample(cityExample);
    }

    public City getCityByCityName(String cityName){
        CityExample example = new CityExample();
        CityExample.Criteria criteria = example.createCriteria();
        criteria.andCityNameLike("%"+cityName+"%");
        List<City> cityList = cityMapper.selectByExample(example);
        if(cityList.size() > 0 ){
            return cityList.get(0);
        }else{
            return null;
        }
    }
}
