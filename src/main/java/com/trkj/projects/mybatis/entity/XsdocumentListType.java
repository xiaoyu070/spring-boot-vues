package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (XsdocumentListType)实体类
 *
 * @author makejava
 * @since 2021-06-10 16:23:03
 */
@Data
public class XsdocumentListType implements Serializable {
    private static final long serialVersionUID = 889921497703183660L;
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
