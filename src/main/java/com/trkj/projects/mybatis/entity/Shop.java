package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Shop)实体类
 *
 * @author makejava
 * @since 2021-05-31 19:30:26
 */
@Data
public class Shop implements Serializable {
    private static final long serialVersionUID = -58659415091849695L;
    /**
     * 自增id
     */
    private Integer spId;
    /**
     * 商品编号
     */
    private Integer spShopId;
    /**
     * 商品名称
     */
    private String spName;
    /**
     * 条码
     */
    private String spBarCode;
    /**
     * 商品类型id
     */
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
    /**
     * 商品颜色
     */
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
    /**
     * 商品备注
     */
    private String spBeizhu;
    /**
     * 不知道是啥玩意 知道的告诉我一下我是oys
     */
    private Date spTime;
    /**
     * 商品图片
     */
    private String shImg;
    /**
     * 商品所在仓库外键id
     */
    private Integer warehouse_id;

}
