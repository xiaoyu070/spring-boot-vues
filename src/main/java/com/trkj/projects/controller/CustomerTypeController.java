package com.trkj.projects.controller;

import com.trkj.projects.mybatis.entity.CustomerType;
import com.trkj.projects.mybatis.entity.Suppliertype;
import com.trkj.projects.service.CustomerTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CustomerType)表控制层
 *
 * @author makejava
 * @since 2021-06-16 19:35:22
 */
@RestController
@RequestMapping("customerType")
public class CustomerTypeController {
    /**
     * 服务对象
     */
    @Resource
    private CustomerTypeService customerTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CustomerType selectOne(Integer id) {
        return this.customerTypeService.queryById(id);
    }
    /*
    *查询客户类型
     */
    @GetMapping("suptype")
    public List<CustomerType> findall(){
        return customerTypeService.findall();
    }

}
