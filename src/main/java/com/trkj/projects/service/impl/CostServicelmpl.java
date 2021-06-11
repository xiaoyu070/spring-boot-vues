package com.trkj.projects.service.impl;

import com.trkj.projects.mybatis.dao.CostDao;
import com.trkj.projects.mybatis.entity.Cost;
import com.trkj.projects.service.CostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.*;
import java.util.List;

@Service("CostService")
public class CostServicelmpl implements CostService {
    @Resource
    private CostDao dao;
    @Override
    public List<Cost> selectAll(String Projecttype) {
        return dao.selectall(Projecttype);
    }
}
