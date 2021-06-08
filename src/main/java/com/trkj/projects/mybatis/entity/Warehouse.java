package com.trkj.projects.mybatis.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Warehouse)实体类
 *
 * @author makejava
 * @since 2021-05-31 20:00:07
 */
public class Warehouse implements Serializable {
    private static final long serialVersionUID = 687120343796019853L;
    /**
     * 仓库编号
     */
    private Integer wid;
    /**
     * 仓库名称
     */
    private String wname;
    /**
     * 负责人
     */
    private String charge;
    /**
     * 联系电话
     */
    private String lxphone;
    /**
     * 仓库地址
     */
    private String waddress;
    /**
     * 是否默认
     */
    private Integer ismoren;
    /**
     * 所属分店
     */
    private Integer branchid;
    /**
     * 创建时间
     */
    private Date cjdate;
    /**
     * 备注
     */
    private String beizhu;


    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getLxphone() {
        return lxphone;
    }

    public void setLxphone(String lxphone) {
        this.lxphone = lxphone;
    }

    public String getWaddress() {
        return waddress;
    }

    public void setWaddress(String waddress) {
        this.waddress = waddress;
    }

    public Integer getIsmoren() {
        return ismoren;
    }

    public void setIsmoren(Integer ismoren) {
        this.ismoren = ismoren;
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public Date getCjdate() {
        return cjdate;
    }

    public void setCjdate(Date cjdate) {
        this.cjdate = cjdate;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

}
