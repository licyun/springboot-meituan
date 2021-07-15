package com.licyun.meituan.food.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "mt_province")
@org.hibernate.annotations.Table(appliesTo = "mt_province",comment = "省份信息表")
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "province_code", unique = true,
            columnDefinition = " int(11) not null comment '省份行政区域代码' ")
    private Integer provinceCode;

    @Column(name = "province_name",
            columnDefinition = " varchar(100) not null comment '省份名称' ")
    private String provinceName;

    @Column(name = "province_is_collect",
            columnDefinition = " int(1) comment '省份采集标示: 0 未采集, 1 已采集, 2 中断采集 '")
    private Integer provinceIsCollect;


}
