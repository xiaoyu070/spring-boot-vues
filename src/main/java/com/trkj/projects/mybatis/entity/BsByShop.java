package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (BsByShop)实体类
 *
 * @author makejava
 * @since 2021-06-15 23:00:56
 */
@Data
public class BsByShop implements Serializable {
    private static final long serialVersionUID = -30514821561970983L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 报损报溢单据号
     */
    private String bsLossReport;
    /**
     * 报损报溢商品编号
     */
    private Integer spShopid;
    /**
     * 商品名称
     */
    private String spName;
    /**
     * 商品类型id
     */
    private Integer spTypeId;
    /**
     * 商品库存数量
     */
    private Integer skNumber;
    /**
     * 报损/报溢数量
     */
    private Integer bsNumbers;
    /**
     * 报损/报溢后数量
     */
    private Integer bsBaosunhou;
    /**
     * 颜色
     */
    private String spColor;
    /**
     * 规格型号
     */
    private String spSpecifications;
    /**
     * 总金额
     */
    private Double zje;
    /**
     * 单价
     */
    private Double spJprice;
    /**
     * 单位
     */
    private String spCompany;
    /**
     * 数量
     */
    private Integer number;
    /**
     * 报损报溢备注
     */
    private String beizu;

    private Integer wid;
    private Integer branchid;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer Wid) {
        this.branchid = Wid;
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.wid = branchid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getbsLossReport() {
        return bsLossReport;
    }

    public void setbsLossReport(String bsLossReport) {
        this.bsLossReport = bsLossReport;
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

    public Integer getSpTypeId() {
        return spTypeId;
    }

    public void setSpTypeId(Integer spTypeId) {
        this.spTypeId = spTypeId;
    }

    public Integer getSkNumber() {
        return skNumber;
    }

    public void setSkNumber(Integer skNumber) {
        this.skNumber = skNumber;
    }

    public Integer getBsNumbers() {
        return bsNumbers;
    }

    public void setBsNumbers(Integer bsNumbers) {
        this.bsNumbers = bsNumbers;
    }

    public Integer getBsBaosunhou() {
        return bsBaosunhou;
    }

    public void setBsBaosunhou(Integer bsBaosunhou) {
        this.bsBaosunhou = bsBaosunhou;
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

    public Double getZje() {
        return zje;
    }

    public void setZje(Double zje) {
        this.zje = zje;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getBeizu() {
        return beizu;
    }

    public void setBeizu(String beizu) {
        this.beizu = beizu;
    }

}
