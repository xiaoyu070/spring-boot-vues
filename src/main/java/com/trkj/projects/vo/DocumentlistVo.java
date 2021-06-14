package com.trkj.projects.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class DocumentlistVo {
    /**
     * 单据号
     */
    private String dlNumber;
    /**
     * 仓库外键id
     */
    private Integer wid;
    /**
     * 开单时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dlDate;
    /**
     * 供货商名称
     */
    private String suppliername;
    /**
     * 供货商id
     */
    private Integer supplierid;
    /**
     * 客户名称
     */
    private String contacts;

    /**
     * 仓库名称
     */
    private String wname;
    /**
     * 应付金额
     */
    private double dlyfje;
    /**
     * 实付金额
     */
    private double dlsfje;
    /**
     * 欠款金额
     */
    private double dlqkje;
    /**
     * 优惠金额
     */
    private double dlyhje;
    /**
     * 员工名称
     */
    private String agentname;
    /**
     * 操作员名称
     */
    private String username;
    /**
     * 单据状态名称
     */
    private String dlstatiename;
    /**
     * 单据类型名称
     */
    private String dltypename;
    /**
     * 单据类型名称
     */
    private Integer dltypeid;
    /**
     * 备注
     */
    private String dlbeizhu;
    /**
     * 店面名称
     */
    private String branchname;
    /**
     * 店面id
     */
    private Integer branchid;
    /**
     * 经办人外键id（员工）
     */
    private Integer agentid;
}
