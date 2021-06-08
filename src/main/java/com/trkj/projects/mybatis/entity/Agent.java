package com.trkj.projects.mybatis.entity;

import java.io.Serializable;

/**
 * (Agent)实体类
 *
 * @author makejava
 * @since 2021-06-03 18:50:09
 */
public class Agent implements Serializable {
    private static final long serialVersionUID = 705091058135213311L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 员工工号
     */
    private Integer agentId;
    /**
     * 员工姓名
     */
    private String agentName;
    /**
     * 所属店面外键id
     */
    private Integer branchid;
    /**
     * 员工职务
     */
    private String agentZw;
    /**
     * 员工提成 默认0.1
     */
    private Double agentTicheng;
    /**
     * 员工联系电话
     */
    private String agentPhone;
    /**
     * 员工地址
     */
    private String agentAddress;
    /**
     * 备注信息
     */
    private String agentBz;
    /**
     * 采购权限 0:可用 1:禁用
     */
    private Integer purchasePom;
    /**
     * 销售权限 0:可用 1:禁用
     */
    private Integer salePom;
    /**
     * 库存权限 0:可用 1:禁用
     */
    private Integer stockPom;
    /**
     * 是否禁用 0:可用 1:禁用
     */
    private Integer agentStatie;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public String getAgentZw() {
        return agentZw;
    }

    public void setAgentZw(String agentZw) {
        this.agentZw = agentZw;
    }

    public Double getAgentTicheng() {
        return agentTicheng;
    }

    public void setAgentTicheng(Double agentTicheng) {
        this.agentTicheng = agentTicheng;
    }

    public String getAgentPhone() {
        return agentPhone;
    }

    public void setAgentPhone(String agentPhone) {
        this.agentPhone = agentPhone;
    }

    public String getAgentAddress() {
        return agentAddress;
    }

    public void setAgentAddress(String agentAddress) {
        this.agentAddress = agentAddress;
    }

    public String getAgentBz() {
        return agentBz;
    }

    public void setAgentBz(String agentBz) {
        this.agentBz = agentBz;
    }

    public Integer getPurchasePom() {
        return purchasePom;
    }

    public void setPurchasePom(Integer purchasePom) {
        this.purchasePom = purchasePom;
    }

    public Integer getSalePom() {
        return salePom;
    }

    public void setSalePom(Integer salePom) {
        this.salePom = salePom;
    }

    public Integer getStockPom() {
        return stockPom;
    }

    public void setStockPom(Integer stockPom) {
        this.stockPom = stockPom;
    }

    public Integer getAgentStatie() {
        return agentStatie;
    }

    public void setAgentStatie(Integer agentStatie) {
        this.agentStatie = agentStatie;
    }

}
