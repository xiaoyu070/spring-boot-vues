package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (CustomerType)实体类
 *
 * @author makejava
 * @since 2021-06-15 21:12:14
 */
@Data
public class CustomerType implements Serializable {
    private static final long serialVersionUID = 795411853310587335L;
    /**
     * id
     */
    private Integer typeid;
    /**
     * 类型名称
     */
    private String typeName;


    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


}
