package com.trkj.projects.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class PdResponseVo {
    private Integer id;
    /**
     * 盘点单号
     */
    private String pdId;
    /**
     * 盘点时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pdDate;
    /**
     * 仓库外键id
     */
    private Integer wid;

    private String wname;
    private String userName;

    /**
     * 操作员外键id
     */
    private Integer userId;
    /**
     * 商品条数
     */
    private Integer pdShopTiao;
    /**
     * 商品数量
     */
    private Integer skNumber;
    /**
     * 备注
     */
    private String beizhu;
    /**
     * 盘点商品编号
     */
    private Integer spShopid;
    /**
     * 盘点商品名称
     */
    private String spName;
    /**
     * 单价
     */
    private Double spJprice;
    /**
     * 单位
     */
    private String spCompany;
    /**
     * 规格型号
     */
    private String spSpecifications;
    /**
     * 颜色
     */
    private String spColor;


    /**
     * 盘点数量
     */
    private Integer pdNumber;
    /**
     * 盘点金额
     */
    private Double pdJiner;
    /**
     * 库存金额
     */
    private Double kcJiner;

    /**
     * 数量差额
     */
    private Double slchaer;

}
