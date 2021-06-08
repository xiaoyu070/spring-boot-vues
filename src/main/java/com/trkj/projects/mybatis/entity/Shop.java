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

    private Integer spId;

    private Integer spShopId;

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



    public Integer getSpId() {
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    public Integer getSpShopId() {
        return spShopId;
    }

    public void setSpShopId(Integer spShopId) {
        this.spShopId = spShopId;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }

    public String getSpBarCode() {
        return spBarCode;
    }

    public void setSpBarCode(String spBarCode) {
        this.spBarCode = spBarCode;
    }

    public Integer getSpTypeId() {
        return spTypeId;
    }

    public void setSpTypeId(Integer spTypeId) {
        this.spTypeId = spTypeId;
    }

    public Integer getSpState() {
        return spState;
    }

    public void setSpState(Integer spState) {
        this.spState = spState;
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

    public String getSpManufacturer() {
        return spManufacturer;
    }

    public void setSpManufacturer(String spManufacturer) {
        this.spManufacturer = spManufacturer;
    }

    public String getSpBeizhu() {
        return spBeizhu;
    }

    public void setSpBeizhu(String spBeizhu) {
        this.spBeizhu = spBeizhu;
    }

    public Date getSpTime() {
        return spTime;
    }

    public void setSpTime(Date spTime) {
        this.spTime = spTime;
    }

    public String getShImg() {
        return shImg;
    }

    public void setShImg(String shImg) {
        this.shImg = shImg;
    }

}
