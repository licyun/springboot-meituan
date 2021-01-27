package com.licyun.meituan.food.domain;

import javax.persistence.*;

@Entity
@Table(name = "meituan_province")
@org.hibernate.annotations.Table(appliesTo = "meituan_province",comment = "省份信息表")
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getProvinceIsCollect() {
        return provinceIsCollect;
    }

    public void setProvinceIsCollect(Integer provinceIsCollect) {
        this.provinceIsCollect = provinceIsCollect;
    }
}
