package com.trkj.projects.mybatis.entity;

import java.io.Serializable;

/**
 * (DocumentListStatic)实体类
 *
 * @author makejava
 * @since 2021-06-03 22:07:32
 */
public class DocumentListStatic implements Serializable {
    private static final long serialVersionUID = 146159751228347723L;
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
