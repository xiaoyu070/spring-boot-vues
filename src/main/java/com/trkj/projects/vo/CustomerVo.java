package com.trkj.projects.vo;

import com.trkj.projects.mybatis.entity.Address;
import com.trkj.projects.mybatis.entity.Branch;
import com.trkj.projects.mybatis.entity.CustomerType;
import lombok.Data;

import java.util.Date;

@Data
public class CustomerVo {
    /**
     * 主键
     */
    private Integer cId;
    /**
     * 客户类型外键
     */
    private Integer cTypeid;
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
