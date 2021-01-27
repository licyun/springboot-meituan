package com.licyun.meituan.food.repository;

import com.licyun.meituan.food.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    List<City> findAllByCityParentCode(Integer cityParentCode);

    City findByCityId(Integer cityId);
}
