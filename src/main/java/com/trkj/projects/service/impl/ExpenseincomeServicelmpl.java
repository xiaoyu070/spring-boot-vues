package com.trkj.projects.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.dao.ExpenseincomeDao;
import com.trkj.projects.mybatis.entity.Expenseincome;
import com.trkj.projects.mybatis.entity.Warehouse;
import com.trkj.projects.service.ExpenseincomeService;
import com.trkj.projects.vo.ExpenEntryVo;
import com.trkj.projects.vo.ExpenseincomeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseincomeServicelmpl implements ExpenseincomeService {
    @Autowired
    private ExpenseincomeDao dao;

    /**
     * 分页查询费用及收入上表
     * @param pageSize
     * @param size
     * @return
     */
    @Override
    public PageInfo<ExpenEntryVo> selectExpen(int pageSize, int size) {
        List<ExpenEntryVo> list = this.dao.selectExpen();
        System.out.println("---------------------------"+list);
        PageHelper.startPage(pageSize,size);
        List<ExpenEntryVo> list2 = this.dao.selectExpen();
        //封装到pageinfo再设置总条数获取第一个list的大小size()方法
        PageInfo<ExpenEntryVo> info = new PageInfo<>(list2);
        info.setTotal(list.size());
        System.out.println("--------------"+list);
        return info;
    }

    @Override
    public PageInfo<ExpenseincomeVo> selectEntry(int pageSize, int size, String typeName) {
        List<ExpenseincomeVo> list = this.dao.selectEntry(typeName);
        System.out.println("---------------------------"+list);
        PageHelper.startPage(pageSize,size);
        List<ExpenseincomeVo> list2 = this.dao.selectEntry(typeName);
        //封装到pageinfo再设置总条数获取第一个list的大小size()方法
        PageInfo<ExpenseincomeVo> info = new PageInfo<>(list2);
        info.setTotal(list.size());
        System.out.println("--------------"+list);
        return info;
    }
}
