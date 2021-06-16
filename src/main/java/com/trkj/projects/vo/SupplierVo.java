package com.trkj.projects.vo;


import com.trkj.projects.mybatis.entity.Address;
import com.trkj.projects.mybatis.entity.Branch;
import com.trkj.projects.mybatis.entity.Suppliertype;
import lombok.Data;

import java.util.Date;

@Data
public class SupplierVo {
    private Integer sId;

    private Integer supplierid;
    /**
     * 供货商名称
     */
    private String suppliername;
    /**
     * 联系人
     */
    private String contacts;
    /**
     * 联系电话
     */
    private String contactnumber;
    /**
     * 供货商类型id
     */
    private Integer suptypeid;
    /**
     * 所属地区
     */
    private Integer addressid;
    /**
     * 应付金额
     */
    private Double payablemoney;
    /**
     * 所属分店
     */
    private Integer companyid;
    /**
     * 初期金额
     */
    private Double money;
    /**
     * 状态 0:正常 1:禁用
     */
    private Integer state;
    /**
     * 1:正常，0：默认客户
     */
    private Integer ismoren;
    /**
     * 联系地址
     */
    private String lxaddress;
    /**
     * 创建时间
     */
    private Date cjtime;
    /**
     * 备注
     */
    private String beizhu;

    private Address address;
    private Branch branch;
    private Suppliertype suppliertype;
}
