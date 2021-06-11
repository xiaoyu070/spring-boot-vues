package com.trkj.projects.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class SpxsmxVo {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dlDate;
    private String dlNumber;
    private Double dlYSje;
    private Double dlSSje;
    private String dlBeiZhu;
    private String agentName;
    private String WName;
    private String supplierName;
    private String userName;
    private String dlTypeName;
    private String cContacts;
}
