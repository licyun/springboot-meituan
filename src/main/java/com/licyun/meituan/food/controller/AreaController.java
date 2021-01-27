package com.licyun.meituan.food.controller;

import com.licyun.meituan.food.domain.Area;
import com.licyun.meituan.food.repository.AreaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class AreaController {

    @Resource
    AreaRepository areaRepository;

    /** 根据父级id查找所有城市 */
    @ResponseBody
    @GetMapping(value = "/admin/get-areas-{areaParentId}")
    public List<Area> findAllByAreaParentId(
            @PathVariable("areaParentId") Integer areaParentId){

        List<Area> areas = areaRepository.findAllByAreaParentId(areaParentId);
        return areas;
    }
}
