package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Jintuicankaoa)实体类
 *
 * @author makejava
 * @since 2021-06-28 18:41:15
 */
@Data
public class Jintuicankaoa implements Serializable {
    private static final long serialVersionUID = -28688053642298017L;

    private Integer id;

    private Integer spShopid;

    private String spName;

    private String spCompany;

    private String spSpecifications;

    private String spColor;

    private Integer sId;

    private Integer ckTuihuonumber;

    private Integer skNumber;

    private Date adddate;

    private String suppliername;


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

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

}
