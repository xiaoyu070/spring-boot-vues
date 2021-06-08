package com.trkj.projects.mybatis.entity;

import java.io.Serializable;

/**
 * (ShopType)实体类
 *
 * @author makejava
 * @since 2021-06-01 09:52:36
 */
public class ShopType implements Serializable {
    private static final long serialVersionUID = 999837662901844137L;
    /**
     * 商品类别id
     */
    private Integer spTypeId;
    /**
     * 商品类别名称
     */
    private String spTypeName;


    public Integer getSpTypeId() {
        return spTypeId;
    }

    public void setSpTypeId(Integer spTypeId) {
        this.spTypeId = spTypeId;
    }

    public String getSpTypeName() {
        return spTypeName;
    }

    public void setSpTypeName(String spTypeName) {
        this.spTypeName = spTypeName;
    }

}
