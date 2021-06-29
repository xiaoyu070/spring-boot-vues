package com.trkj.projects.vo;

import lombok.Data;

import java.util.Date;
@Data
public class StockVo {
    /**
     * 商品库存数量
     */
    private Integer skNumber;
    /**
     * 最低库存(用于库存报警)
     */
    private Integer spNumber;
    /**
     * 商品状态（0:启用，1:禁用）
     */
    private Integer spState;
    /**
     * 商品编号(根据商品编号查询该商品的库存)
     */
    private String spShopid;
    /**
     * 商品名称
     */
    private String spName;
    /**
     * 商品条码
     */
    private String spBarCode;

    /**
     * 单位
     */
    private String spCompany;
    /**
     * 规格
     */
    private String spSpecifications;
    /**
     * 预设售价
     */
    private Double spPresetPrice;
    /**
     * 预设进价
     */
    private Double spJprice;
    /**
     * 生产厂商
     */
    private String spManufacturer;
    /**
     * 颜色
     */
    private String spColor;
    /**
     * 备注
     */
    private String spBeizhu;
    /**
     * 时间
     */
    private Date spTime;
    /**
     * 商品类型名称
     */
    private String spTypeName;
    /**
     * 类型id
     */
    private Integer spTypeId;

    /**
     * 仓库名称
     */
    private String wname;
    /**
     * 分店名称
     */
    private String branchname;

    private Integer pdNumber;

    private Integer number;
    /**
     * 供货商
     */
    private String suppliername;


}
