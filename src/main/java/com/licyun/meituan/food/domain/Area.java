package com.licyun.meituan.food.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "mt_area")
@org.hibernate.annotations.Table(appliesTo = "mt_area",comment = "区与街道信息表")
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

}
