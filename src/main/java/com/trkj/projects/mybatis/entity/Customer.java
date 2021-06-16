package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Customer)实体类
 *
 * @author makejava
 * @since 2021-06-05 21:45:21
 */
@Data
public class Customer implements Serializable {
    private static final long serialVersionUID = 380705243512913607L;
    /**
     * 主键
     */
    private Integer cId;
    /**
     * 客户类型外键
     */
    private Integer cTypeid;

    private Integer vtypeid;
    private double vtypeck;
    /**
     * 联系人
     */
    private String cContacts;
    /**
     * 所属地区外键
     */
    private Integer addressid;
    /**
     * 联系电话
     */
    private String cPhone;
    /**
     * 初期应收
     */
    private Double cMoney;
    /**
     * 所属分店id
     */
    private Integer branchid;
    /**
     * 所属用户外键
     */
    private Integer userid;
    /**
     * 联系地址
     */
    private String cLxaddress;
    /**
     * 备注
     */
    private String beizhu;
    /**
     * 创建时间
     */
    private Date cTime;
    /**
     * 0:正常，1:禁用
     */
    private Integer cState;
    /**
     * 0:正常，1:默认
     */
    private Integer cIsmoren;


    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public Integer getCTypeid() {
        return cTypeid;
    }

    public void setCTypeid(Integer cTypeid) {
        this.cTypeid = cTypeid;
    }

    public String getCContacts() {
        return cContacts;
    }

    public void setCContacts(String cContacts) {
        this.cContacts = cContacts;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public String getCPhone() {
        return cPhone;
    }

    public void setCPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public Double getCMoney() {
        return cMoney;
    }

    public void setCMoney(Double cMoney) {
        this.cMoney = cMoney;
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getCLxaddress() {
        return cLxaddress;
    }

    public void setCLxaddress(String cLxaddress) {
        this.cLxaddress = cLxaddress;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public Date getCTime() {
        return cTime;
    }

    public void setCTime(Date cTime) {
        this.cTime = cTime;
    }

    public Integer getCState() {
        return cState;
    }

    public void setCState(Integer cState) {
        this.cState = cState;
    }

    public Integer getCIsmoren() {
        return cIsmoren;
    }

    public void setCIsmoren(Integer cIsmoren) {
        this.cIsmoren = cIsmoren;
    }

}
