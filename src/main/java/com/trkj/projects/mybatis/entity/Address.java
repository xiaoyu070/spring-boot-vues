package com.trkj.projects.mybatis.entity;

import java.io.Serializable;

/**
 * (Address)实体类
 *
 * @author makejava
 * @since 2021-06-01 16:23:47
 */
public class Address implements Serializable {
    private static final long serialVersionUID = 828026444878995126L;
    /**
     * 地区id
     */
    private Integer addressid;
    /**
     * 地区名称
     */
    private String address;


    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
