package com.licyun.meituan.food.service;

import com.licyun.meituan.food.domain.City;
import com.licyun.meituan.food.domain.Shop;
import com.licyun.meituan.food.domain.ShopResult;
import com.licyun.meituan.food.repository.AreaRepository;
import com.licyun.meituan.food.repository.CityRepository;
import com.licyun.meituan.food.repository.ShopRepository;
import com.licyun.meituan.food.utils.ShopResultUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ShopService {

    @Resource
    CityRepository cityRepository;

    @Resource
    AreaRepository areaRepository;

    @Resource
    ShopRepository shopRepository;


    public ShopResult findAllByAreaTypeAndId(Integer areaId, Integer areaType, Integer page, Integer size){
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
        ShopResult shopResult = ShopResultUtil.success(shopList, count);
        return shopResult;
    }

    public List<Shop> transferShopTable(List<Shop> shops){
        for( int i = 0; i < shops.size(); i++){
            Shop shop = shops.get(i);
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
