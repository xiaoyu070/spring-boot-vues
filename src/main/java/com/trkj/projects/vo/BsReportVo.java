package com.trkj.projects.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class BsReportVo {
    /**
     * 报损id  自增
     */
    private Integer bsId;
    /**
     * 报损单号
     */
    private String bsLossReport;
    /**
     * 报损日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bsDate;
    /**
     * 仓库id
     */
    private Integer wid;
    /**
     * 经办人id
     */
    private Integer agentId;
    /**
     * 备注
     */
    private String beizhu;
    /**
     * 操作员id
     */
    private Integer userId;



    /**
     * 店面id
     */
    private Integer branchid;
    /**
     * 报损报溢类型0报损1报溢
     */
    private Integer documentsTypeId;
    /**
     * 仓库名称
     */
    private String wname;
    /**
     * 店面名称
     */
    private String branchname;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 员工姓名
     */
    private String agentName;



    /**
     * 报损报溢商品编号
     */
    private Integer spShopid;
    /**
     * 商品名称
     */
    private String spName;
    /**
     * 商品类型id
     */
    private Integer spTypeId;
    /**
     * 商品库存数量
     */
    private Integer skNumber;
    /**
     * 报损/报溢数量
     */
    private Integer bsNumbers;
    /**
     * 报损/报溢后数量
     */
    private Integer bsBaosunhou;
    /**
     * 颜色
     */
    private String spColor;
    /**
     * 规格型号
     */
    private String spSpecifications;
    /**
     * 总金额
     */
    private Double zje;
    /**
     * 单价
     */
    private Double spJprice;
    /**
     * 单位
     */
    private String spCompany;
    /**
     * 数量
     */
    private Integer number;
    /**
     * 报损报溢备注
     */
    private String beizu;
}
