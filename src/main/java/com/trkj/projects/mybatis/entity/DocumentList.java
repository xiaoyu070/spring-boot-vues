package com.trkj.projects.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (DocumentList)实体类
 *
 * @author makejava
 * @since 2021-06-03 22:06:09
 */
public class DocumentList implements Serializable {
    private static final long serialVersionUID = 189653453656644391L;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dlDate;
    /**
     * 供货商外键id
     */
    private Integer supplierid;
    /**
     * 所属仓库外键id
     */
    private Integer wid;
    /**
     * 应付金额
     */
    private Double dlYfje;
    /**
     * 实付金额
     */
    private Double dlSfje;
    /**
     * 欠款金额
     */
    private Double dlQkje;
    /**
     * 优惠金额
     */
    private Double dlYhje;
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

    public Integer getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Double getDlYfje() {
        return dlYfje;
    }

    public void setDlYfje(Double dlYfje) {
        this.dlYfje = dlYfje;
    }

    public Double getDlSfje() {
        return dlSfje;
    }

    public void setDlSfje(Double dlSfje) {
        this.dlSfje = dlSfje;
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
