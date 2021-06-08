package com.trkj.projects.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class DocumentlistVo {
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
     * 供货商名称
     */
    private String suppliername;

    /**
     * 仓库名称
     */
    private String wname;
    /**
     * 应付金额
     */
    private double dlyfje;
    /**
     * 实付金额
     */
    private double dlsfje;
    /**
     * 欠款金额
     */
    private double dlqkje;
    /**
     * 优惠金额
     */
    private double dlyhje;
    /**
     * 员工名称
     */
    private String agentname;
    /**
     * 操作员名称
     */
    private String username;
    /**
     * 单据状态名称
     */
    private String dlstatiename;
    /**
     * 单据类型名称
     */
    private String dltypename;
    /**
     * 备注
     */
    private String dlbeizhu;
    /**
     * 店面名称
     */
    private String branchname;
    /**
     * 店面id
     */
    private Integer branchid;

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

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public double getDlyfje() {
        return dlyfje;
    }

    public void setDlyfje(double dlyfje) {
        this.dlyfje = dlyfje;
    }

    public double getDlsfje() {
        return dlsfje;
    }

    public void setDlsfje(double dlsfje) {
        this.dlsfje = dlsfje;
    }

    public double getDlqkje() {
        return dlqkje;
    }

    public void setDlqkje(double dlqkje) {
        this.dlqkje = dlqkje;
    }

    public double getDlyhje() {
        return dlyhje;
    }

    public void setDlyhje(double dlyhje) {
        this.dlyhje = dlyhje;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDlstatiename() {
        return dlstatiename;
    }

    public void setDlstatiename(String dlstatiename) {
        this.dlstatiename = dlstatiename;
    }

    public String getDltypename() {
        return dltypename;
    }

    public void setDltypename(String dltypename) {
        this.dltypename = dltypename;
    }

    public String getDlbeizhu() {
        return dlbeizhu;
    }

    public void setDlbeizhu(String dlbeizhu) {
        this.dlbeizhu = dlbeizhu;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }
}
