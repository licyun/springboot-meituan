package com.licyun.meituan.food.controller;

import com.licyun.meituan.food.domain.City;
import com.licyun.meituan.food.repository.CityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CityController {

    @Resource
    CityRepository cityRepository;

    @GetMapping(value = "/admin/get-cities-{provinceCode}")
    @ResponseBody
    public List<City> findCityByProvinceCode(@PathVariable("provinceCode") Integer provinceCode){
        System.out.println("provinceCode:" + provinceCode);
        List<City> cities = cityRepository.findAllByCityParentCode(provinceCode);
        return cities;
    }
}
