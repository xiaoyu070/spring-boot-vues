package com.trkj.projects.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (DocumentList)实体类
 *
 * @author makejava
 * @since 2021-06-03 22:06:09
 */
@Data
public class DocumentList implements Serializable {
    private static final long serialVersionUID = 189653453656644391L;
    /**
     * 自增id
     */
    private Integer id;
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
     * 供货商外键id
     */
    private Integer supplierid;
    /**
     * 客户外键id
     */
    private Integer customerid;
    /**
     * 所属仓库外键id
     */
    private Integer wid;
    /**
     * 应付金额
     */
    private Double dlYfje;
    /**
     * 实付金额
     */
    private Double dlSfje;
    /**
     * 欠款金额
     */
    private Double dlQkje;
    /**
     * 优惠金额
     */
    private Double dlYhje;
    /**
     * 员工外键id（经办人）
     */
    private Integer agentId;
    /**
     * 操作员id
     */
    private Integer admin;
    /**
     * 类型外键id
     */
    private Integer dlTypeId;
    /**
     * 状态外键id
     */
    private Integer dlStatieId;
    /**
     * 备注
     */
    private String dlBeizhu;





}
