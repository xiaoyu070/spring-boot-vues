package com.trkj.projects.mybatis.entity;

import java.io.Serializable;

/**
 * (Suppliertype)实体类
 *
 * @author makejava
 * @since 2021-06-01 16:26:29
 */
public class Suppliertype implements Serializable {
    private static final long serialVersionUID = 832205306694920074L;
    /**
     * 供货商类型id
     */
    private Integer suptypeid;
    /**
     * 供货商类型名称
     */
    private String supname;


    public Integer getSuptypeid() {
        return suptypeid;
    }

    public void setSuptypeid(Integer suptypeid) {
        this.suptypeid = suptypeid;
    }

    public String getSupname() {
        return supname;
    }

    public void setSupname(String supname) {
        this.supname = supname;
    }

}
