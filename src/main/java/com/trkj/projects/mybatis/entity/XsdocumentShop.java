package com.trkj.projects.mybatis.entity;

import java.io.Serializable;

/**
 * (XsdocumentShop)实体类
 *
 * @author makejava
 * @since 2021-06-18 17:06:58
 */
public class XsdocumentShop implements Serializable {
    private static final long serialVersionUID = -31515895454076459L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 单据表外键单据号
     */
    private String dlNumber;
    /**
     * 分店id
     */
    private Integer branchid;
    /**
     * 客户外键
     */
    private Integer customerid;
    /**
     * 所在仓库外键id
     */
    private Integer wid;
    /**
     * 商品编号外键id
     */
    private Integer spShopid;
    /**
     * 商品名称
     */
    private String spName;
    /**
     * 单位
     */
    private String spCompany;
    /**
     * 售价
     */
    private Double spPresetPrice;
    /**
     * 数量
     */
    private Integer number;
    /**
     * 损耗后数量
     */
    private Integer lossNumber;
    /**
     * 总金额
     */
    private Double zje;
    /**
     * 规格型号
     */
    private String spSpecifications;
    /**
     * 颜色
     */
    private String spColor;
    /**
     * 备注
     */
    private String beizhu;
    /**
     * 销售商品状态，1：退货
     */
    private Integer xsSpState;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDlNumber() {
        return dlNumber;
    }

    public void setDlNumber(String dlNumber) {
        this.dlNumber = dlNumber;
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getSpShopid() {
        return spShopid;
    }

    public void setSpShopid(Integer spShopid) {
        this.spShopid = spShopid;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }

    public String getSpCompany() {
        return spCompany;
    }

    public void setSpCompany(String spCompany) {
        this.spCompany = spCompany;
    }

    public Double getSpPresetPrice() {
        return spPresetPrice;
    }

    public void setSpPresetPrice(Double spPresetPrice) {
        this.spPresetPrice = spPresetPrice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getLossNumber() {
        return lossNumber;
    }

    public void setLossNumber(Integer lossNumber) {
        this.lossNumber = lossNumber;
    }

    public Double getZje() {
        return zje;
    }

    public void setZje(Double zje) {
        this.zje = zje;
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

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public Integer getXsSpState() {
        return xsSpState;
    }

    public void setXsSpState(Integer xsSpState) {
        this.xsSpState = xsSpState;
    }

}
