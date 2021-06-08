package com.trkj.projects.vo;

import lombok.Data;

import java.util.Date;

@Data
public class SpcgmxVo {
    private int number;
    private int lossNumber;
    private double zje;
    private int spShopId;
    private String spName;
    private String spCompany;
    private String spSpecifications;
    private String spColor;
    private String spBeiZhu;
    private String dlNumber;
    private Date dlDate;
    private String  spTypeName;
    private String WName ;
    private String agentName;
    private String supplierName;
}
