package com.trkj.projects.mybatis.entity;

import java.io.Serializable;

/**
 * (BsByType)实体类
 *
 * @author makejava
 * @since 2021-06-10 14:53:22
 */
public class BsByType implements Serializable {
    private static final long serialVersionUID = -16750357094920630L;
    /**
     * 报损报溢状态id
     */
    private Integer bsByByid;
    /**
     * 报损报溢状态名称
     */
    private String bsByByname;


    public Integer getBsByByid() {
        return bsByByid;
    }

    public void setBsByByid(Integer bsByByid) {
        this.bsByByid = bsByByid;
    }

    public String getBsByByname() {
        return bsByByname;
    }

    public void setBsByByname(String bsByByname) {
        this.bsByByname = bsByByname;
    }

}
