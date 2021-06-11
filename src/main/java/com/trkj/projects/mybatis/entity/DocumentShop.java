package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (DocumentShop)实体类
 *
 * @author makejava
 * @since 2021-06-04 10:36:18
 */
@Data
public class DocumentShop implements Serializable {
    private static final long serialVersionUID = 685057535899346093L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 单据表外键单据号
     */
    private String dlNumber;
    /**
     * 供货商外键id
     */
    private Integer supperlierid;
    /**
     * 客户外键
     */
    private Integer customerid;

    /**
     * 所在仓库外键id
     */
    private Integer wid;
    /**
     * 商品编号外键id
     */
    private Integer spShopid;
    /**
     * 商品名称
     */
    private String spName;
    /**
     * 单位
     */
    private String spCompany;
    /**
     * 单价
     */
    private Double spJprice;
    /**
     * 数量
     */
    private Integer number;
    /**
     * 损耗后数量
     */
    private Integer lossNumber;
    /**
     * 总金额
     */
    private Double zje;
    /**
     * 规格型号
     */
    private String spSpecifications;
    /**
     * 颜色
     */
    private String spColor;
    /**
     * 备注
     */
    private String beizhu;

}
