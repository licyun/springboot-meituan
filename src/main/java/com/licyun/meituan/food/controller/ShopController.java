package com.licyun.meituan.food.controller;

import com.licyun.meituan.food.domain.ShopResult;
import com.licyun.meituan.food.domain.Shop;
import com.licyun.meituan.food.repository.ShopRepository;
import com.licyun.meituan.food.service.ShopService;
import com.licyun.meituan.food.utils.ShopResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ShopController {

    @Resource
    private ShopRepository shopRepository;

    @Resource
    private ShopService shopService;

    @ResponseBody
    @GetMapping(value = "/admin/get-shops-by-{areaId}-{areaType}")
    public ShopResult getShopsByAreaIdAndType(@PathVariable Integer areaId,
                                       @PathVariable Integer areaType, Integer page, Integer limit){

        ShopResult shopResult = shopService.findAllByAreaTypeAndId(areaId, areaType, page, limit);
        return shopResult;
    }


}
