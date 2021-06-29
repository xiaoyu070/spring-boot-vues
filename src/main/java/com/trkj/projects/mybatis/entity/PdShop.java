package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (PdShop)实体类
 *
 * @author makejava
 * @since 2021-06-17 19:07:01
 */
@Data
public class PdShop implements Serializable {
    private static final long serialVersionUID = 443716458603589023L;
    /**
     * 盘点商品id
     */
    private Integer id;
    /**
     * 盘点单号
     */
    private String pdId;
    /**
     * 盘点商品编号
     */
    private String spShopid;
    /**
     * 盘点商品名称
     */
    private String spName;
    /**
     * 单价
     */
    private Double spJprice;
    /**
     * 单位
     */
    private String spCompany;
    /**
     * 规格型号
     */
    private String spSpecifications;
    /**
     * 颜色
     */
    private String spColor;
    /**
     * 库存数量
     */
    private Integer skNumber;
    /**
     * 盘点数量
     */
    private Integer pdNumber;
    /**
     * 盘点金额
     */
    private Double pdJiner;
    /**
     * 库存金额
     */
    private Double kcJiner;
    /**
     * 仓库id
     */
    private Integer wid;
    /**
     * 数量差额
     */
    private Double slchaer;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPdId() {
        return pdId;
    }

    public void setPdId(String pdId) {
        this.pdId = pdId;
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

    public Double getSpJprice() {
        return spJprice;
    }

    public void setSpJprice(Double spJprice) {
        this.spJprice = spJprice;
    }

    public String getSpCompany() {
        return spCompany;
    }

    public void setSpCompany(String spCompany) {
        this.spCompany = spCompany;
    }

    public String getSpSpecifications() {
        return spSpecifications;
    }

    public void setSpSpecifications(String spSpecifications) {
        this.spSpecifications = spSpecifications;
    }

    public String getSpColor() {
        return spColor;
    }

    public void setSpColor(String spColor) {
        this.spColor = spColor;
    }

    public Integer getSkNumber() {
        return skNumber;
    }

    public void setSkNumber(Integer skNumber) {
        this.skNumber = skNumber;
    }

    public Integer getPdNumber() {
        return pdNumber;
    }

    public void setPdNumber(Integer pdNumber) {
        this.pdNumber = pdNumber;
    }

    public Double getPdJiner() {
        return pdJiner;
    }

    public void setPdJiner(Double pdJiner) {
        this.pdJiner = pdJiner;
    }

    public Double getKcJiner() {
        return kcJiner;
    }

    public void setKcJiner(Double kcJiner) {
        this.kcJiner = kcJiner;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Double getSlchaer() {
        return slchaer;
    }

    public void setSlchaer(Double slchaer) {
        this.slchaer = slchaer;
    }

}
