package com.trkj.projects.service.impl;


import com.trkj.projects.mybatis.dao.SuppliertypeDao;
import com.trkj.projects.mybatis.entity.Suppliertype;
import com.trkj.projects.service.SupplierTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("supplierTypeService")
public class SupplierTypeServiceImpl implements SupplierTypeService {
    @Resource
    private SuppliertypeDao suppliertypeDao;

    @Override
    public List<Suppliertype> findall() {
        return suppliertypeDao.findAll();
    }
}
