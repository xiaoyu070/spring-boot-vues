package com.trkj.projects.mybatis.entity;

import java.io.Serializable;

/**
 * (DocumentListType)实体类
 *
 * @author makejava
 * @since 2021-06-03 22:07:53
 */
public class DocumentListType implements Serializable {
    private static final long serialVersionUID = -88320883725428723L;
    /**
     * 单据类型id
     */
    private Integer dlTypeId;
    /**
     * 单据类型名称
     */
    private String dlTypeName;


    public Integer getDlTypeId() {
        return dlTypeId;
    }

    public void setDlTypeId(Integer dlTypeId) {
        this.dlTypeId = dlTypeId;
    }

    public String getDlTypeName() {
        return dlTypeName;
    }

    public void setDlTypeName(String dlTypeName) {
        this.dlTypeName = dlTypeName;
    }

}
