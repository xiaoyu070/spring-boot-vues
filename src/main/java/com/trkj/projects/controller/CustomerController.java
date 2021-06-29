package com.trkj.projects.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.Customer;
import com.trkj.projects.mybatis.entity.Supplier;
import com.trkj.projects.mybatis.entity.Suppliertype;
import com.trkj.projects.service.CustomerService;
import com.trkj.projects.service.impl.CustomerServiceImpl;
import com.trkj.projects.vo.AjaxResponse;
import com.trkj.projects.vo.CustomerVo;
import com.trkj.projects.vo.SupplierVo;
import netscape.javascript.JSObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
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
    /*
    *客户类型
     */
/**
 * 新增
 */
    @PostMapping("addcustomer")
    public Integer addcustomer(@RequestBody String customer){
        JSONObject jsObject = JSON.parseObject(customer);
        System.out.println("ssss:"+jsObject);
        String ttt = jsObject.getString("list");
        System.out.println("tttt:"+ttt);
       // Customer www = jsObject.getObject(ttt,Customer.class);
        Customer xxx = JSON.parseObject(ttt,Customer.class);
        System.out.println("wwww:"+xxx);
        xxx.setCTime(new Date());
        return customerService.addcustomer(xxx);
}
/*
*查询
 */
    @GetMapping("khcx")
    public AjaxResponse findbyname(Integer branchid, String cContacts, Integer currentPage, Integer pageSize){
        System.out.println("------------------"+branchid+"       "+cContacts);
        PageInfo<CustomerVo> info = customerService.khcx(branchid,cContacts,currentPage,pageSize);
        return AjaxResponse.success(info);
    }


    /**
     * 批量删除
     * @param supplierid
     * @return
     */
    @GetMapping("delsupplier")
    public Integer delsupplier(@RequestParam(value = "supplierid")Integer[] supplierid){
        return customerService.deletepl(supplierid);

    }
    /**
     * 修改
     */
    @PostMapping("upsupplier")
    public Boolean upsupplier(@RequestBody Customer customer){
        System.out.println(customer.toString());
        return customerService.upsupplier(customer);
    }
}
