package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Customer)实体类
 *
 * @author makejava
 * @since 2021-06-05 21:45:21
 */
@Data
public class Customer implements Serializable {
    private static final long serialVersionUID = 380705243512913607L;
    /**
     * 主键
     */
    private Integer cId;
    /**
     * 客户类型外键
     */
    private Integer cTypeid;

    private Integer vtypeid;
    private double vtypeck;
    /**
     * 联系人
     */
    private String cContacts;
    /**
     * 所属地区外键
     */
    private Integer addressid;
    /**
     * 联系电话
     */
    private String cPhone;
    /**
     * 初期应收
     */
    private Double cMoney;
    /**
     * 所属分店id
     */
    private Integer branchid;
    /**
     * 所属用户外键
     */
    private Integer userid;
    /**
     * 联系地址
     */
    private String cLxaddress;
    /**
     * 备注
     */
    private String beizhu;
    /**
     * 创建时间
     */
    private Date cTime;
    /**
     * 0:正常，1:禁用
     */
    private Integer cState;
    /**
     * 0:正常，1:默认
     */
    private Integer cIsmoren;

    private Address address;
    private CustomerType customerType;
    private Branch branch;

}
