package com.trkj.projects.mybatis.entity;

import java.io.Serializable;

/**
 * (Stock)实体类
 *
 * @author makejava
 * @since 2021-06-04 14:19:25
 */
public class Stock implements Serializable {
    private static final long serialVersionUID = -16598816924764650L;
    /**
     * 商品编号外键
     */
    private Integer skShopid;
    /**
     * 所在店面id外键
     */
    private Integer spStorefrontId;
    /**
     * 仓库id外键
     */
    private Integer spWarehouseId;
    /**
     * 商品库存数量
     */
    private Integer skNumber;
    /**
     * 最低库存(用于库存报警)
     */
    private Integer spNumber;

    /**
     * 损耗后数量
     * @return
     */
    private Integer skLossnumber;

    public Integer getSkLossnumber() {
        return skLossnumber;
    }

    public void setSkLossnumber(Integer skLossnumber) {
        this.skLossnumber = skLossnumber;
    }

    public Integer getSkShopid() {
        return skShopid;
    }

    public void setSkShopid(Integer skShopid) {
        this.skShopid = skShopid;
    }

    public Integer getSpStorefrontId() {
        return spStorefrontId;
    }

    public void setSpStorefrontId(Integer spStorefrontId) {
        this.spStorefrontId = spStorefrontId;
    }

    public Integer getSpWarehouseId() {
        return spWarehouseId;
    }

    public void setSpWarehouseId(Integer spWarehouseId) {
        this.spWarehouseId = spWarehouseId;
    }

    public Integer getSkNumber() {
        return skNumber;
    }

    public void setSkNumber(Integer skNumber) {
        this.skNumber = skNumber;
    }

    public Integer getSpNumber() {
        return spNumber;
    }

    public void setSpNumber(Integer spNumber) {
        this.spNumber = spNumber;
    }

}
