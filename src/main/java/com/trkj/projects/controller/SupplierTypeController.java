package com.trkj.projects.controller;



import com.trkj.projects.mybatis.entity.Suppliertype;
import com.trkj.projects.service.SupplierTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("suppliertype")
public class SupplierTypeController {
    @Resource
    private SupplierTypeService supplierTypeService;

    @GetMapping("suptype")
    public List<Suppliertype> findall(){
        return supplierTypeService.findall();
    }

    //---------------------------------------------


}
