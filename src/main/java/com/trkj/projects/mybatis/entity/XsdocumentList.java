package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (XsdocumentList)实体类
 *
 * @author makejava
 * @since 2021-06-10 16:19:57
 */
@Data
public class XsdocumentList implements Serializable {
    private static final long serialVersionUID = -33487032155509375L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 单据号
     */
    private String dlNumber;
    /**
     * 开单时间
     */
    private Date dlDate;
    /**
     * 客户外键id
     */
    private Integer customerid;
    /**
     * 所属仓库外键id
     */
    private Integer wid;
    /**
     * 所在店面id
     */
    private Integer branchid;
    /**
     * 应收金额
     */
    private Double dlYsje;
    /**
     * 实收金额
     */
    private Double dlSsje;
    /**
     * 欠款金额
     */
    private Double dlQkje;
    /**
     * 优惠金额
     */
    private Double dlYhje;
    /**
     * 总金额
     */
    private Double dlzonje;
    /**
     * 员工外键id（经办人）
     */
    private Integer agentId;
    /**
     * 操作员id
     */
    private Integer admin;
    /**
     * 类型外键id
     */
    private Integer dlTypeId;
    /**
     * 状态外键id
     */
    private Integer dlStatieId;
    /**
     * 备注
     */
    private String dlBeizhu;


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

    public Date getDlDate() {
        return dlDate;
    }

    public void setDlDate(Date dlDate) {
        this.dlDate = dlDate;
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

    public Double getDlYsje() {
        return dlYsje;
    }

    public void setDlYsje(Double dlYsje) {
        this.dlYsje = dlYsje;
    }

    public Double getDlSsje() {
        return dlSsje;
    }

    public void setDlSsje(Double dlSsje) {
        this.dlSsje = dlSsje;
    }

    public Double getDlQkje() {
        return dlQkje;
    }

    public void setDlQkje(Double dlQkje) {
        this.dlQkje = dlQkje;
    }

    public Double getDlYhje() {
        return dlYhje;
    }

    public void setDlYhje(Double dlYhje) {
        this.dlYhje = dlYhje;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public Integer getDlTypeId() {
        return dlTypeId;
    }

    public void setDlTypeId(Integer dlTypeId) {
        this.dlTypeId = dlTypeId;
    }

    public Integer getDlStatieId() {
        return dlStatieId;
    }

    public void setDlStatieId(Integer dlStatieId) {
        this.dlStatieId = dlStatieId;
    }

    public String getDlBeizhu() {
        return dlBeizhu;
    }

    public void setDlBeizhu(String dlBeizhu) {
        this.dlBeizhu = dlBeizhu;
    }

}
