package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Shops {
    private Integer spId;

    private Integer spShopid;

    private String spName;
    /**
     * 条码
     */
    private String spBarCode;

    private Integer spTypeId;
    /**
     * 1:禁用0正常：
     */
    private Integer spState;
    /**
     * 单位
     */
    private String spCompany;
    /**
     * 规格型号：5w-40
     */
    private String spSpecifications;

    private String spColor;
    /**
     * 预设进价
     */
    private Double spJprice;
    /**
     * 预设售价
     */
    private Double spPresetPrice;
    /**
     * 生产厂商
     */
    private String spManufacturer;

    private String spBeizhu;

    private Date spTime;

    private String shImg;

    private ShopType shopType;

    private Supplier supplier;

}
