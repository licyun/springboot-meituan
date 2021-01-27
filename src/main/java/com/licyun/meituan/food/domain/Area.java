package com.licyun.meituan.food.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "meituan_area")
@org.hibernate.annotations.Table(appliesTo = "meituan_area",comment = "区与街道信息表")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "area_id", unique = true,
            columnDefinition = " int(11) comment '美团地域id' ")
    private Integer areaId;

    @Column(name = "area_type",
            columnDefinition = " int(11) comment '地域类型 1.城市 2.区 3.街道' ")
    private Integer areaType;

    @Column(name = "area_parent_id",
            columnDefinition = " int(11) comment '地域父级id' ")
    private Integer areaParentId;

    @Column(name = "area_name",
            columnDefinition = " varchar(100) comment '地域名称' ")
    private String areaName;

    @Column(name = "area_shop_number",
            columnDefinition = "  int(11) comment '该地域美食商家数量' ")
    private Integer areaShopNumber;

    @Column(name = "area_collect_date",
            columnDefinition = " datetime comment '采集该地域的时间' ")
    private Date areaCollectDate;

    @Column(name = "area_is_collect",
            columnDefinition = " int(1) comment '该地域采集标示: 0 未采集, 1 已采集, 2 中断采集' ")
    private Integer areaIsCollect;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getAreaType() {
        return areaType;
    }

    public void setAreaType(Integer areaType) {
        this.areaType = areaType;
    }

    public Integer getAreaParentId() {
        return areaParentId;
    }

    public void setAreaParentId(Integer areaParentId) {
        this.areaParentId = areaParentId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getAreaShopNumber() {
        return areaShopNumber;
    }

    public void setAreaShopNumber(Integer areaShopNumber) {
        this.areaShopNumber = areaShopNumber;
    }

    public Date getAreaCollectDate() {
        return areaCollectDate;
    }

    public void setAreaCollectDate(Date areaCollectDate) {
        this.areaCollectDate = areaCollectDate;
    }

    public Integer getAreaIsCollect() {
        return areaIsCollect;
    }

    public void setAreaIsCollect(Integer areaIsCollect) {
        this.areaIsCollect = areaIsCollect;
    }
}
