package com.licyun.meituan.food.domain;

import javax.persistence.*;

@Entity
@Table(name = "meituan_city")
@org.hibernate.annotations.Table(appliesTo = "meituan_city",comment = "城市信息表")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "city_id", unique = true,
            columnDefinition = " int(11) not null comment '城市id' ")
    private Integer cityId;

    @Column(name = "city_parent_code",
            columnDefinition = " int(11) comment '城市所属省份编码' ")
    private Integer cityParentCode;

    @Column(name = "city_name",
            columnDefinition = " varchar(100) comment '城市名称' ")
    private String cityName;

    @Column(name = "city_pinyin",
            columnDefinition = " varchar(100) comment '城市拼音' ")
    private String cityPinyin;

    @Column(name = "city_acronym",
            columnDefinition = " varchar(100) comment '城市首字母缩写' ")
    private String cityAcronym;

    @Column(name = "city_is_collect",
            columnDefinition = " int(1) comment '城市采集标示: 0 未采集, 1 已采集, 2 中断采集' ")
    private Integer cityIsCollect;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCityParentCode() {
        return cityParentCode;
    }

    public void setCityParentCode(Integer cityParentCode) {
        this.cityParentCode = cityParentCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityPinyin() {
        return cityPinyin;
    }

    public void setCityPinyin(String cityPinyin) {
        this.cityPinyin = cityPinyin;
    }

    public String getCityAcronym() {
        return cityAcronym;
    }

    public void setCityAcronym(String cityAcronym) {
        this.cityAcronym = cityAcronym;
    }

    public Integer getCityIsCollect() {
        return cityIsCollect;
    }

    public void setCityIsCollect(Integer cityIsCollect) {
        this.cityIsCollect = cityIsCollect;
    }
}
