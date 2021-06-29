package com.trkj.projects.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Documentlistshopstatiezreojinhuomingxivo {
    private String suppliername;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dldate;
    private String dlnumber;
    private int spshopid;
    private String spname;
    private double spPresetprice;
    private String spspecifications;
    private double spjprice;
    private int number;
    private double zje;
    private String spcompany;
    private String spcolor;
    private String beizhu;
    private String agentname;
    private String wname;
}
