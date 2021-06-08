package com.trkj.projects.mybatis.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Establishment)实体类
 *
 * @author makejava
 * @since 2021-06-06 21:45:36
 */
public class Establishment implements Serializable {
    private static final long serialVersionUID = -32053565802122436L;
    /**
     * xid
     */
    private Integer xid;
    /**
     * 银行名称
     */
    private String bank;
    /**
     * 余额
     */
    private Double opening;
    /**
     * 是否启用
     */
    private Integer enable;
    /**
     * 排序
     */
    private String sort;
    /**
     * 创建日期
     */
    private Date creationdate;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 分店外键
     */
    private Integer branchid;


    public Integer getXid() {
        return xid;
    }

    public void setXid(Integer xid) {
        this.xid = xid;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Double getOpening() {
        return opening;
    }

    public void setOpening(Double opening) {
        this.opening = opening;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

}
