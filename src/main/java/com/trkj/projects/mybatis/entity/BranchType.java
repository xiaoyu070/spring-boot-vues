package com.trkj.projects.mybatis.entity;

import java.io.Serializable;

/**
 * (BranchType)实体类
 *
 * @author makejava
 * @since 2021-06-10 14:35:01
 */
public class BranchType implements Serializable {
    private static final long serialVersionUID = -26564043865652821L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 店面类型id
     */
    private Integer branchTypeId;
    /**
     * 店面类型名称
     */
    private String branchTypeName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBranchTypeId() {
        return branchTypeId;
    }

    public void setBranchTypeId(Integer branchTypeId) {
        this.branchTypeId = branchTypeId;
    }

    public String getBranchTypeName() {
        return branchTypeName;
    }

    public void setBranchTypeName(String branchTypeName) {
        this.branchTypeName = branchTypeName;
    }

}
