package com.trkj.projects.controller;


import com.trkj.projects.mybatis.entity.Customer;
import com.trkj.projects.mybatis.entity.Supplier;
import com.trkj.projects.service.CustomerService;
import com.trkj.projects.service.impl.CustomerServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Customer)表控制层
 *
 * @author makejava
 * @since 2021-06-05 21:45:34
 */
@RestController
@RequestMapping("customer")
public class CustomerController {
    /**
     * 服务对象
     */
    @Resource
    private CustomerService customerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Customer selectOne(Integer id) {
        return this.customerService.queryById(id);
    }

    /**
     * 根据分店编号查询单个仓库信息
     * @param id
     * @return
     */
    @GetMapping("selectOnes")
    public List<Customer> selectones(Integer id){
        return this.customerService.queryByBranchId(id);
    }
    @GetMapping("findallcus")
    public List<Customer> findall(){
        return customerService.findall();
    }
/**
 * 新增
 */
    @PostMapping("addcustomer")
    public Integer addcustomer(@RequestBody Customer customer){
        System.out.println(customer.toString());
        return customerService.addcustomer(customer);
}
}
