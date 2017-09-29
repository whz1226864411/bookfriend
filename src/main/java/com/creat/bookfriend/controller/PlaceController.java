package com.creat.bookfriend.controller;

import com.creat.bookfriend.po.*;
import com.creat.bookfriend.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by whz on 2017/9/24.
 */
@RestController
@RequestMapping("/place")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = "/getAllProvince",method = {RequestMethod.POST},
                    produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message getAllProvince(){
        List<Province> provinces = placeService.getAllProvince();
        ProvinceMessage message = new ProvinceMessage();
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功！");
        message.setProvinces(provinces);
        return message;
    }

    @RequestMapping(value = "/getCitiesByProvinceId",method = {RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message getCitiesByProvinceId(Long provinceId){
        CityMessage message = new CityMessage();
        List<City> cities = placeService.getCitiesByProvinceId(provinceId);
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功！");
        message.setCities(cities);
        return message;
    }

    @RequestMapping(value = "/getDistrictsByCityId",method = {RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message getDistrictsByCityId(Long cityId){
        DistrictMessage message = new DistrictMessage();
        List<District> districts = placeService.getDistrictsByCityId(cityId);
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功！");
        message.setDistricts(districts);
        return message;
    }

}
