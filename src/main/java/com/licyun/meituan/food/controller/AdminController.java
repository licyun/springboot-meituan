package com.licyun.meituan.food.controller;

import com.licyun.meituan.food.domain.*;
import com.licyun.meituan.food.repository.AreaRepository;
import com.licyun.meituan.food.repository.CityRepository;
import com.licyun.meituan.food.repository.ProvinceRepository;
import com.licyun.meituan.food.service.ProvinceService;
import com.licyun.meituan.food.service.ShopService;
import com.licyun.meituan.food.utils.ResultUtil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

    @Resource
    private ProvinceService provinceService;

    @Resource
    private ShopService shopService;

    @Resource
    private ProvinceRepository provinceRepository;

    @Resource
    private CityRepository cityRepository;

    @Resource
    private AreaRepository areaRepository;

    @GetMapping("/")
    public String meituanAdmin(Model model){

        return "/admin/index";
    }

    @GetMapping("/shops")
    public String meituanShop(Model model){
        List<Province> provinces = provinceService.findAllProvinces();
        model.addAttribute("provinces", provinces);
        return "/admin/shops";
    }

    @ResponseBody
    @GetMapping(value = "/get-menu")
    public ResultData<?> getMenu(){
        ResultData<?> resultData = ResultUtil.error();
        return resultData;
    }

    @ResponseBody
    @GetMapping(value = "/get-shops-by-{shopId}")
    public Page<Shop> getShopsByAreaId(@PathVariable Integer shopId,
                                       Integer page,
                                       Integer limit){
        Page<Shop> shopPage = shopService.findByShopCityId(shopId, page, limit);
        return  shopPage;
    }

    @ResponseBody
    @GetMapping(value = "/get-shops-by-{areaId}-{areaType}")
    public ResultData<?> getShopsByAreaIdAndType(@PathVariable Integer areaId,
                                                 @PathVariable Integer areaType, Integer page, Integer limit){

        ResultData<?> resultData = shopService.findAllByAreaTypeAndId(areaId, areaType, page, limit);
        return resultData;
    }


    @GetMapping(value = "/get-provinces")
    @ResponseBody
    public List<Province> findAllProvince() {
        List<Province> provinces = provinceRepository.findAll();
        return provinces;
    }

    /**
     * 根据省份代码查找所有城市
     * @param provinceCode
     * @return
     */
    @GetMapping(value = "/get-cities-{provinceCode}")
    @ResponseBody
    public List<City> findCityByProvinceCode(@PathVariable("provinceCode") Integer provinceCode){
        System.out.println("provinceCode:" + provinceCode);
        List<City> cities = cityRepository.findAllByCityParentCode(provinceCode);
        return cities;
    }

    /**
     * 根据城市id查到地区
     * @param areaParentId
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/get-areas-{areaParentId}")
    public List<Area> findAllByAreaParentId(
            @PathVariable("areaParentId") Integer areaParentId){

        List<Area> areas = areaRepository.findAllByAreaParentId(areaParentId);
        return areas;
    }
}
