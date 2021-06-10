package com.trkj.projects.mybatis.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * cost
 * @author 
 */
@Data
public class Cost implements Serializable {
    /**
     * id编号
     */
    private Integer fid;

    /**
     * 附加说明
     */
    private String additional;

    /**
     * 项目类型（费用/收入）
     */
    private String projecttype;

    /**
     * 类型名称
     */
    private String typename;

    private static final long serialVersionUID = 1L;
}