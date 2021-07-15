package com.licyun.meituan.food.service;

import com.licyun.meituan.food.domain.*;
import com.licyun.meituan.food.repository.AreaRepository;
import com.licyun.meituan.food.repository.CityRepository;
import com.licyun.meituan.food.repository.ShopRepository;
import com.licyun.meituan.food.utils.ResultUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {

    @Resource
    CityRepository cityRepository;

    @Resource
    AreaRepository areaRepository;

    @Resource
    ShopRepository shopRepository;

    public Page<Shop> findByShopCityId(Integer shopId, Integer page, Integer limit){
        Pageable pageable = PageRequest.of(page, limit);
        Page<Shop> shopPage = shopRepository.findByShopCityId(shopId, pageable);
        return  shopPage;
    }

    public ResultData<?> findAllByAreaTypeAndId(Integer areaId, Integer areaType, Integer page, Integer size){
        List<Shop>  shopList = new ArrayList<>();
        Integer pageBegin = (page - 1) * size;
        Integer count = 0;
        if( areaType ==  1 ){
            shopList = shopRepository.findAllByShopCityIdWithLimit(areaId, pageBegin, size);
            count = shopRepository.countByShopCityId(areaId);
        }else if( areaType == 2 ){
            shopList = shopRepository.findAllByShopDistrictIdWithLimit(areaId, pageBegin, size);
            count = shopRepository.countByShopDistrictId(areaId);
        }else if( areaType == 3 ){
            shopList = shopRepository.findAllByShopStreetIdWithLimit(areaId, pageBegin, size);
            count = shopRepository.countByShopStreetId(areaId);
        }
        shopList = transferShopTable(shopList);
        ResultData<?> resultData = ResultUtil.success(
                ResultDataEnum.SUCCESS_SHOP.getCode(), ResultDataEnum.SUCCESS_SHOP.getMsg(), count, shopList);
        return resultData;
    }

    public List<Shop> transferShopTable(List<Shop> shops){
        for (Shop shop : shops) {
            // 设置城市名称
            Integer cityId = shop.getShopCityId();
            String cityName = cityRepository.findByCityId(cityId).getCityName();
            shop.setShopCityName(cityName);
            // 设置区名称
            Integer districtId = shop.getShopDistrictId();
            String districtName = areaRepository.findByAreaId(districtId).getAreaName();
            shop.setShopDistrictName(districtName);
            // 设置街道名称
            Integer streetId = shop.getShopStreetId();
            String streetName = areaRepository.findByAreaId(streetId).getAreaName();
            shop.setShopStreetName(streetName);

        }
        return shops;
    }
}
