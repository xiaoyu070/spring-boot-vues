package com.trkj.projects.jpa.entity;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "warehouse", schema = "spring", catalog = "")
public class WarehouseEntity {
    private int wid;
    private String wname;
    private String charge;
    private String lxphone;
    private String waddress;
    private Integer ismoren;
    private Date cjdate;
    private String beizhu;
    private BranchEntity branchByBranchid;
    private BranchEntity branch;

    @Id
    @Column(name = "wid")
    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    @Basic
    @Column(name = "wname")
    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    @Basic
    @Column(name = "charge")
    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
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
    @Column(name = "waddress")
    public String getWaddress() {
        return waddress;
    }

    public void setWaddress(String waddress) {
        this.waddress = waddress;
    }

    @Basic
    @Column(name = "ismoren")
    public Integer getIsmoren() {
        return ismoren;
    }

    public void setIsmoren(Integer ismoren) {
        this.ismoren = ismoren;
    }

    @Basic
    @Column(name = "cjdate")
    public Date getCjdate() {
        return cjdate;
    }

    public void setCjdate(Date cjdate) {
        this.cjdate = cjdate;
    }

    @Basic
    @Column(name = "beizhu")
    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarehouseEntity that = (WarehouseEntity) o;
        return wid == that.wid &&
                Objects.equals(wname, that.wname) &&
                Objects.equals(charge, that.charge) &&
                Objects.equals(lxphone, that.lxphone) &&
                Objects.equals(waddress, that.waddress) &&
                Objects.equals(ismoren, that.ismoren) &&
                Objects.equals(cjdate, that.cjdate) &&
                Objects.equals(beizhu, that.beizhu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wid, wname, charge, lxphone, waddress, ismoren, cjdate, beizhu);
    }



    @ManyToOne
    @JoinColumn(name = "branchid", referencedColumnName = "branchid")
    public BranchEntity getBranchByBranchid() {
        return branchByBranchid;
    }

    public void setBranchByBranchid(BranchEntity branchByBranchid) {
        this.branchByBranchid = branchByBranchid;
    }

    @OneToOne(mappedBy = "warehouse")
    public BranchEntity getBranch() {
        return branch;
    }

    public void setBranch(BranchEntity branch) {
        this.branch = branch;
    }
}
