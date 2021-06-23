package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (XsdocumentShop)实体类
 *
 * @author makejava
 * @since 2021-06-18 15:46:50
 */
@Data
public class XsdocumentShop implements Serializable {
    private static final long serialVersionUID = 682222646721732923L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 单据表外键单据号
     */
    private String dlNumber;
    /**
     * 分店id
     */
    private Integer branchid;
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
     * 售价
     */
    private Double spPresetPrice;
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
     * 销售商品状态，1：退货
     */
    private Integer xsSpState;
    /**
     * 原始单号
     */
    private String ysDlNumber;


}
