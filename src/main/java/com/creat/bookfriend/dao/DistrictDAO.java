package com.creat.bookfriend.dao;

import com.creat.bookfriend.mapper.DistrictMapper;
import com.creat.bookfriend.po.District;
import com.creat.bookfriend.po.DistrictExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by whz on 2017/9/24.
 */
@Repository
public class DistrictDAO {
    @Autowired
    private DistrictMapper districtMapper;

    public List<District> getDistrictsByCityId(Long cityId) {
        DistrictExample districtExample = new DistrictExample();
        DistrictExample.Criteria criteria = districtExample.createCriteria();
        criteria.andCityIdEqualTo(cityId);
        return districtMapper.selectByExample(districtExample);
    }
}
