package com.trkj.projects.vo;

import java.util.Date;

public class DbdanjuVo {
    /**
     * 调拨单据id
     */
    private Integer id;
    /**
     * 调拨单号
     */
    private String dbid;
    /**
     * 调出仓库id
     */
    private Integer wid;
    /**
     * 调入仓库id
     */
    private Integer widR;
    /**
     * 经办人id
     */
    private Integer jingbanren;
    /**
     * 操作员id
     */
    private Integer adminid;
    /**
     * 备注
     */
    private String beizu;
    /**
     * 调拨日期
     */
    private Date dbdate;
    /**
     * 商品编号
     */
    private String spShopid;
    /**
     * 商品名称
     */
    private String spName;
    /**
     * 颜色
     */
    private String spColor;
    /**
     * 规格型号
     */
    private String spSpecifications;
    /**
     * 单位
     */
    private String spCompany;
    /**
     * 数量
     */
    private Integer shulian;
    /**
     * 进价
     */
    private Double spJprice;
    /**
     * 售价
     */
    private Double spPresetPrice;

    /**
     * 调拨名称
     */
    private String dbname;
}
