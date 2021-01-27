package com.licyun.meituan.food.controller;

import com.licyun.meituan.food.domain.Province;
import com.licyun.meituan.food.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class ProvinceController {

    @Resource
    ProvinceRepository provinceRepository;

    @GetMapping(value = "/admin/get-provinces")
    @ResponseBody
    public List<Province> findAllProvince() {
        List<Province> provinces = provinceRepository.findAll();
        return provinces;
    }



}
