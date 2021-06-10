package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (XsdocumentListStatic)实体类
 *
 * @author makejava
 * @since 2021-06-10 16:22:17
 */
@Data
public class XsdocumentListStatic implements Serializable {
    private static final long serialVersionUID = -97005883348986664L;
    /**
     * 单据状态id
     */
    private Integer dlStatieId;
    /**
     * 单据状态名称
     */
    private String dlStatieName;


    public Integer getDlStatieId() {
        return dlStatieId;
    }

    public void setDlStatieId(Integer dlStatieId) {
        this.dlStatieId = dlStatieId;
    }

    public String getDlStatieName() {
        return dlStatieName;
    }

    public void setDlStatieName(String dlStatieName) {
        this.dlStatieName = dlStatieName;
    }

}
