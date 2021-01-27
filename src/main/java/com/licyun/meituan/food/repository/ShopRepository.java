package com.licyun.meituan.food.repository;

import com.licyun.meituan.food.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

    @Query(nativeQuery=true, value = "select * from meituan_shop where shop_city_id = ?1  LIMIT ?2, ?3")
    List<Shop> findAllByShopCityIdWithLimit(Integer cityId, Integer page, Integer size);

    List<Shop> findAllByShopCityId(Integer cityId);

    @Query(nativeQuery=true, value = "select * from meituan_shop where shop_district_id = ?1  LIMIT ?2, ?3")
    List<Shop> findAllByShopDistrictIdWithLimit(Integer districtId, Integer page, Integer size);

    List<Shop> findAllByShopDistrictId(Integer districtId);

    @Query(nativeQuery=true, value = "select * from meituan_shop where shop_street_id = ?1  LIMIT ?2, ?3")
    List<Shop> findAllByShopStreetIdWithLimit(Integer streetId, Integer page, Integer size);

    List<Shop> findAllByShopStreetId(Integer streetId);

    Integer countByShopCityId(Integer cityId);

    Integer countByShopDistrictId(Integer districtId);

    Integer countByShopStreetId(Integer streetId);
}
