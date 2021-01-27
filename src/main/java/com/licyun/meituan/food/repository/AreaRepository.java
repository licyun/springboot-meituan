package com.licyun.meituan.food.repository;

import com.licyun.meituan.food.domain.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {

    List<Area> findAllByAreaParentId(Integer areaParentId);

    Area findByAreaId(Integer areaId);
}
