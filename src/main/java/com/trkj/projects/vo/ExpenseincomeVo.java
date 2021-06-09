package com.trkj.projects.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ExpenseincomeVo {
    /**
     * id
     */
    private Integer sid;

    /**
     * 项目名称
     */
    private String typeName;

    /**
     * 日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 经办人
     */
    private String agent;

    /**
     * 操作员
     */
    private String operator;

    /**
     * 备注
     */
    private String remarks;
}
