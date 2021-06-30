package com.trkj.projects.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (PdReport)实体类
 *
 * @author makejava
 * @since 2021-06-17 19:01:47
 */
@Data
public class PdReport implements Serializable {
    private static final long serialVersionUID = -91031250346059689L;
    /**
     * 盘点id
     */
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

    private Integer pdNumber;


}
