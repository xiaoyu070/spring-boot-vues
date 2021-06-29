package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (XtdocumentShop)实体类
 *
 * @author makejava
 * @since 2021-06-18 10:41:10
 */
@Data
public class XtdocumentShop implements Serializable {
    private static final long serialVersionUID = -75965457628788454L;
    /**
     * 销售退货商品表id
     */
    private Integer id;
    /**
     * 单据号
     */
    private String dlNumber;
    /**
     * 分店id
     */
    private Integer branchid;
    /**
     * 客户id
     */
    private Integer customerid;
    /**
     * 仓库id
     */
    private Integer wid;
    /**
     * 商品id
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
    private double spPresetPrice;
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
    /**
     * 原始单号
     */
    private String ysDlNumber;




}
