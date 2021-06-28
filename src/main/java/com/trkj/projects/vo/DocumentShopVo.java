package com.trkj.projects.vo;

import lombok.Data;

import java.util.Date;

@Data
public class DocumentShopVo {
    /**
     * id
     */
    private Integer id;
    /**
     * 单据号
     */
    private String dlNumber;
    /**
     * 供货商外键id
     */
    private Integer supperlierid;
    /**
     * 所在店面外键id
     */
    private Integer branchid;
    /**
     * 分店名称
     */
    private String branchname;
    /**
     * 客户外键
     */
    private Integer customerid;

    /**
     * 所在仓库外键id
     */
    private Integer wid;
    /**
     * 商品编号
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
     * 售价
     */
    private Double spPresetPrice;
    /**
     * 当前库存
     */
    private Integer sk_number;
    /**
     * 数量
     */
    private Integer numbers;
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
     * 单据时间
     */
    private Date dlDate;
}