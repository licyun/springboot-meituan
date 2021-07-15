package com.licyun.meituan.food.service;

import com.licyun.meituan.food.domain.Province;
import com.licyun.meituan.food.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProvinceService {

    @Resource
    private ProvinceRepository provinceRepository;

    public List<Province> findAllProvinces(){
        return provinceRepository.findAll();
    }


}
