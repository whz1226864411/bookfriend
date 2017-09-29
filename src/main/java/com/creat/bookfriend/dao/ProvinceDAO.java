package com.creat.bookfriend.dao;

import com.creat.bookfriend.mapper.ProvinceMapper;
import com.creat.bookfriend.po.Province;
import com.creat.bookfriend.po.ProvinceExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by whz on 2017/9/24.
 */
@Repository
public class ProvinceDAO {
    @Autowired
    private ProvinceMapper provinceMapper;

    public List<Province> getAllProvinces(){
        return provinceMapper.selectByExample(null);
    }
}
