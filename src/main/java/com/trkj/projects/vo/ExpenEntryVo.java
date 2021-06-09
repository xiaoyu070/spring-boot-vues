package com.trkj.projects.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExpenEntryVo {
    /**
     * 项目名称
     */
    private String typeName;

    /**
     * 总金额
     */
    private BigDecimal income;
    /**
     * 费用类型
     */
    private String projecttype;
    /**
     * 附加说明
     */
    private String additional;
}
