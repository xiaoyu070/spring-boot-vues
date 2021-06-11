package com.trkj.projects.mybatis.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * expenseincome
 * @author 
 */
@Data
public class Expenseincome implements Serializable {
    /**
     * id
     */
    private Integer sid;

    /**
     * 项目名称
     */
    private Integer entryid;

    /**
     * 总金额
     */
    private BigDecimal amount;


    /**
     * 日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    /**
     * 经办人
     */
    private Integer agentid;

    /**
     * 总店/分店
     */
    private Integer branchid;

    /**
     * 付款/收款账户
     */
    private Integer accountid;

    /**
     * 费用金额（消费金额）
     */
    private BigDecimal cost;

    /**
     * 收入金额
     */
    private BigDecimal income;

    /**
     * 操作员
     */
    private String operator;

    /**
     * 备注
     */
    private String remarks;

    private static final long serialVersionUID = 1L;
}