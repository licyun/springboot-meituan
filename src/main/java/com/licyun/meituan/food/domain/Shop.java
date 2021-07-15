package com.licyun.meituan.food.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity

@Table(name = "mt_shop")
@org.hibernate.annotations.Table(appliesTo = "mt_shop",comment = "商家信息表")
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

}
