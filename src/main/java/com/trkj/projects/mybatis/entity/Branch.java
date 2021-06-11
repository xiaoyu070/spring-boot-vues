package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Branch)实体类
 *
 * @author makejava
 * @since 2021-05-31 21:13:22
 */
@Data
public class Branch implements Serializable {
    private static final long serialVersionUID = 426367523299193273L;
    /**
     * 店面id
     */
    private Integer branchid;
    /**
     * 店面名称
     */
    private String branchname;
    /**
     * 店面类型id
     */
    private Integer branchtypeid;
    /**
     * 联系地址
     */
    private String lxaddress;
    /**
     * 联系方式
     */
    private String lxphone;
    /**
     * 支付配置
     */
    private String zhifu;
    /**
     * 相关说明
     */
    private String shuoming;
    /**
     * 创建时间
     */
    private Date cjtime;

    public Integer getBranchtypeid() {
        return branchtypeid;
    }

    public void setBranchtypeid(Integer branchtypeid) {
        this.branchtypeid = branchtypeid;
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public String getLxaddress() {
        return lxaddress;
    }

    public void setLxaddress(String lxaddress) {
        this.lxaddress = lxaddress;
    }

    public String getLxphone() {
        return lxphone;
    }

    public void setLxphone(String lxphone) {
        this.lxphone = lxphone;
    }

    public String getZhifu() {
        return zhifu;
    }

    public void setZhifu(String zhifu) {
        this.zhifu = zhifu;
    }

    public String getShuoming() {
        return shuoming;
    }

    public void setShuoming(String shuoming) {
        this.shuoming = shuoming;
    }

    public Date getCjtime() {
        return cjtime;
    }

    public void setCjtime(Date cjtime) {
        this.cjtime = cjtime;
    }

}
