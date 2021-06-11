package com.trkj.projects.vo;

import lombok.Data;

import java.util.Date;

@Data
public class BranchVo {
    /**
     * 店面id
     */
    private Integer branchid;
    /**
     * 店面名称
     */
    private String branchname;
    /**
     * 店面类型id
     */
    private Integer branchtypeid;
    /**
     * 店面类型名称
     */
    private String branchtypename;
    /**
    /**
     *
     * 联系地址
     */
    private String lxaddress;
    /**
     * 联系方式
     */
    private String lxphone;
    /**
     * 支付配置
     */
    private String zhifu;
    /**
     * 相关说明
     */
    private String shuoming;
    /**
     * 创建时间
     */
    private Date cjtime;
}
