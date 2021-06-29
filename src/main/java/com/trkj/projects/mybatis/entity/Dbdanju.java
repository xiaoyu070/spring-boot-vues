package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Dbdanju)实体类
 *
 * @author makejava
 * @since 2021-06-28 11:31:24
 */
@Data
public class Dbdanju implements Serializable {
    private static final long serialVersionUID = 163142366332217326L;
    /**
     * 调拨单据id
     */
    private Integer id;
    /**
     * 调拨单号
     */
    private String dbid;
    /**
     * 调出仓库id
     */
    private Integer wid;
    /**
     * 调入仓库id
     */
    private Integer widR;
    /**
     * 经办人id
     */
    private Integer jingbanren;
    /**
     * 操作员id
     */
    private Integer adminid;
    /**
     * 备注
     */
    private String beizu;
    /**
     * 调拨日期
     */
    private Date dbdate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDbid() {
        return dbid;
    }

    public void setDbid(String dbid) {
        this.dbid = dbid;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getWidR() {
        return widR;
    }

    public void setWidR(Integer widR) {
        this.widR = widR;
    }

    public Integer getJingbanren() {
        return jingbanren;
    }

    public void setJingbanren(Integer jingbanren) {
        this.jingbanren = jingbanren;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getBeizu() {
        return beizu;
    }

    public void setBeizu(String beizu) {
        this.beizu = beizu;
    }

    public Date getDbdate() {
        return dbdate;
    }

    public void setDbdate(Date dbdate) {
        this.dbdate = dbdate;
    }

}
