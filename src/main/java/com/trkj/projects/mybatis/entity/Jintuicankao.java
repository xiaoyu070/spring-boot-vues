package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Jintuicankao)实体类
 *
 * @author makejava
 * @since 2021-06-22 19:55:43
 */
@Data
public class Jintuicankao implements Serializable {
    private static final long serialVersionUID = -28372932301166583L;
    /**
     * 进货参考id
     */
    private Integer id;
    /**
     * 商品编号id
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
     * 规格型号
     */
    private String spSpecifications;
    /**
     * 颜色
     */
    private String spColor;
    /**
     * 供货商id
     */
    private Integer sId;
    /**
     * 参考退货数量
     */
    private Integer ckTuihuonumber;
    /**
     * 库存数量
     */
    private Integer skNumber;
    /**
     * 添加日期
     */
    private Date adddate;
    private String suppliername;



    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSId() {
        return sId;
    }

    public void setSId(Integer sId) {
        this.sId = sId;
    }

    public Integer getCkTuihuonumber() {
        return ckTuihuonumber;
    }

    public void setCkTuihuonumber(Integer ckTuihuonumber) {
        this.ckTuihuonumber = ckTuihuonumber;
    }

    public Integer getSkNumber() {
        return skNumber;
    }

    public void setSkNumber(Integer skNumber) {
        this.skNumber = skNumber;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

}
