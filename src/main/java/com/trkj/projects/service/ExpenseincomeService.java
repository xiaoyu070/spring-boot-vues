package com.trkj.projects.service;

import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.Expenseincome;
import com.trkj.projects.vo.ExpenEntryVo;
import com.trkj.projects.vo.ExpenseincomeVo;

public interface ExpenseincomeService {
    /**
     * 分页查询费用及收入上表
     * @param pageSize
     * @param size
     * @return
     */
    public PageInfo<ExpenEntryVo> selectExpen(int pageSize, int size);

    /**
     * 根据项目名称查询
     * @param pageSize
     * @param size
     * @param
     * @return
     */
    public PageInfo<ExpenseincomeVo> selectEntry(int pageSize, int size,String typeName);
}
