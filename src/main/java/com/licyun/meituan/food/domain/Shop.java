package com.licyun.meituan.food.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "meituan_shop")
@org.hibernate.annotations.Table(appliesTo = "meituan_shop",comment = "商家信息表")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "shop_id", unique = true,
            columnDefinition = " int(11) comment '商家id' ")
    private Integer shopId;

    @Column(name = "shop_name",
            columnDefinition = " varchar(100) comment '商家名称' ")
    private String shopName;

    @Column(name = "shop_address",
            columnDefinition = " varchar(100) comment '商家地址' ")
    private String shopAddress;

    @Column(name = "shop_phone",
            columnDefinition = " varchar(100) comment '商家电话' ")
    private  String shopPhone;

    @Column(name = "shop_city_id",
            columnDefinition = " int(11) comment '所属城市id' ")
    private Integer shopCityId;

    @Column(name = "shop_district_id",
            columnDefinition = " int(11) comment '所属区级id' ")
    private Integer shopDistrictId;

    @Column(name = "shop_street_id",
            columnDefinition = " int(11) comment '所属街道id' ")
    private Integer shopStreetId;

    @Column(name = "shop_collect_date",
            columnDefinition ="datetime comment '采集时间' ")
    private Date shopCollectDate;

    @Transient
    private String shopCityName;
    @Transient
    private String shopDistrictName;
    @Transient
    private String shopStreetName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }

    public Integer getShopCityId() {
        return shopCityId;
    }

    public void setShopCityId(Integer shopCityId) {
        this.shopCityId = shopCityId;
    }

    public Integer getShopDistrictId() {
        return shopDistrictId;
    }

    public void setShopDistrictId(Integer shopDistrictId) {
        this.shopDistrictId = shopDistrictId;
    }

    public Integer getShopStreetId() {
        return shopStreetId;
    }

    public void setShopStreetId(Integer shopStreetId) {
        this.shopStreetId = shopStreetId;
    }

    public Date getShopCollectDate() {
        return shopCollectDate;
    }

    public void setShopCollectDate(Date shopCollectDate) {
        this.shopCollectDate = shopCollectDate;
    }

    public String getShopCityName() {
        return shopCityName;
    }

    public void setShopCityName(String shopCityName) {
        this.shopCityName = shopCityName;
    }

    public String getShopDistrictName() {
        return shopDistrictName;
    }

    public void setShopDistrictName(String shopDistrictName) {
        this.shopDistrictName = shopDistrictName;
    }

    public String getShopStreetName() {
        return shopStreetName;
    }

    public void setShopStreetName(String shopStreetName) {
        this.shopStreetName = shopStreetName;
    }
}
