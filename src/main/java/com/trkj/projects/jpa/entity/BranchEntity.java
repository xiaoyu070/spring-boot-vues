package com.trkj.projects.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;



@Entity
@Table(name = "branch", schema = "spring", catalog = "")
public class BranchEntity {
    private int branchid;
    private String branchname;
    private String lxaddress;
    private String lxphone;
    private String zhifu;
    private String shuoming;
    private Date cjtime;
    private WarehouseEntity warehouse;

    @Id
    @Column(name = "branchid")
    public int getBranchid() {
        return branchid;
    }

    public void setBranchid(int branchid) {
        this.branchid = branchid;
    }

    @Basic
    @Column(name = "branchname")
    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    @Basic
    @Column(name = "lxaddress")
    public String getLxaddress() {
        return lxaddress;
    }

    public void setLxaddress(String lxaddress) {
        this.lxaddress = lxaddress;
    }

    @Basic
    @Column(name = "lxphone")
    public String getLxphone() {
        return lxphone;
    }

    public void setLxphone(String lxphone) {
        this.lxphone = lxphone;
    }

    @Basic
    @Column(name = "zhifu")
    public String getZhifu() {
        return zhifu;
    }

    public void setZhifu(String zhifu) {
        this.zhifu = zhifu;
    }

    @Basic
    @Column(name = "shuoming")
    public String getShuoming() {
        return shuoming;
    }

    public void setShuoming(String shuoming) {
        this.shuoming = shuoming;
    }

    @Basic
    @Column(name = "cjtime")
    public Date getCjtime() {
        return cjtime;
    }

    public void setCjtime(Date cjtime) {
        this.cjtime = cjtime;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BranchEntity that = (BranchEntity) o;
        return branchid == that.branchid &&
                Objects.equals(branchname, that.branchname) &&
                Objects.equals(lxaddress, that.lxaddress) &&
                Objects.equals(lxphone, that.lxphone) &&
                Objects.equals(zhifu, that.zhifu) &&
                Objects.equals(shuoming, that.shuoming) &&
                Objects.equals(cjtime, that.cjtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchid, branchname, lxaddress, lxphone, zhifu, shuoming, cjtime);
    }

    @OneToOne
    @JoinColumn(name = "branchid", referencedColumnName = "branchid", nullable = false)
    @JsonIgnore//忽略序列化属性
    public WarehouseEntity getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseEntity warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "BranchEntity{" +
                "branchid=" + branchid +
                ", branchname='" + branchname + '\'' +
                ", lxaddress='" + lxaddress + '\'' +
                ", lxphone='" + lxphone + '\'' +
                ", zhifu='" + zhifu + '\'' +
                ", shuoming='" + shuoming + '\'' +
                ", cjtime=" + cjtime +
                '}';
    }
}
