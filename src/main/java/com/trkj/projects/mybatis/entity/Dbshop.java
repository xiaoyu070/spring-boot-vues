package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Dbshop)实体类
 *
 * @author makejava
 * @since 2021-06-28 11:39:06
 */
@Data
public class Dbshop implements Serializable {
    private static final long serialVersionUID = -26526100130791026L;
    /**
     * 调拨单据id
     */
    private Integer id;
    /**
     * 商品编号
     */
    private String spShopid;
    /**
     * 商品名称
     */
    private String spName;
    /**
     * 颜色
     */
    private String spColor;
    /**
     * 规格型号
     */
    private String spSpecifications;
    /**
     * 单位
     */
    private String spCompany;
    /**
     * 数量
     */
    private Integer shulian;
    /**
     * 进价
     */
    private Double spJprice;
    /**
     * 售价
     */
    private Double spPresetPrice;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpShopid() {
        return spShopid;
    }

    public void setSpShopid(String spShopid) {
        this.spShopid = spShopid;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }

    public String getSpColor() {
        return spColor;
    }

    public void setSpColor(String spColor) {
        this.spColor = spColor;
    }

    public String getSpSpecifications() {
        return spSpecifications;
    }

    public void setSpSpecifications(String spSpecifications) {
        this.spSpecifications = spSpecifications;
    }

    public String getSpCompany() {
        return spCompany;
    }

    public void setSpCompany(String spCompany) {
        this.spCompany = spCompany;
    }

    public Integer getShulian() {
        return shulian;
    }

    public void setShulian(Integer shulian) {
        this.shulian = shulian;
    }

    public Double getSpJprice() {
        return spJprice;
    }

    public void setSpJprice(Double spJprice) {
        this.spJprice = spJprice;
    }

    public Double getSpPresetPrice() {
        return spPresetPrice;
    }

    public void setSpPresetPrice(Double spPresetPrice) {
        this.spPresetPrice = spPresetPrice;
    }

}
