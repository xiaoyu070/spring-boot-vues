package com.trkj.projects.vo;


import com.trkj.projects.mybatis.entity.Branch;
import com.trkj.projects.mybatis.entity.Shop;
import com.trkj.projects.mybatis.entity.Warehouse;
import lombok.Data;

@Data
public class StockVov {

    private Integer skLossNumber;
    private Shop shop;
    private Branch branch;
    private Warehouse warehouse;
    private String spShopId;//商品编号
    private String spName;//商品名称
    private String spCompany;//商品单位
    private String spSpecifications;//商品规格
    private String spColor;//商品颜色
    private Double spJprice;//商品进价
    private Integer number;//商品库存
    private String spBarCode;//商品条码
    private String spManufacturer;//生产厂商
    private String spBeizhu;//备注
}
