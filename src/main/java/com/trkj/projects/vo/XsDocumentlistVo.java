package com.trkj.projects.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class XsDocumentlistVo {
    /**
     * 单据号
     */
    private String dlNumber;
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
     * 客户名称
     */
    private String contacts;
    /**
     * 客户会员折扣id
     */
    private double v_type_ck;

    /**
     * 仓库名称
     */
    private String wname;
    /**
     * 应付金额
     */
    private double dlysje;
    /**
     * 实付金额
     */
    private double dlssje;
    /**
     * 欠款金额
     */
    private double dlqkje;
    /**
     * 优惠金额
     */
    private double dlyhje;
    /**
     * 总金额
     */
    private double dlzonje;
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


}
