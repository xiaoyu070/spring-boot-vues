package com.trkj.projects.service;

import com.trkj.projects.mybatis.entity.Cost;

import java.util.List;

public interface CostService {
    //查询所有类型
    public List<Cost> selectAll(String Projecttype);
}
