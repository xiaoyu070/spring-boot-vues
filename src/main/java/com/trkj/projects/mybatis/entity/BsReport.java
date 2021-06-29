package com.trkj.projects.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (BsReport)实体类
 *
 * @author makejava
 * @since 2021-06-15 21:51:53
 */
@Data
public class BsReport implements Serializable {
    private static final long serialVersionUID = 376132486749466684L;
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

}
