package com.trkj.projects.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.Supplier;
import com.trkj.projects.service.SupplierService;
import com.trkj.projects.vo.AjaxResponse;
import com.trkj.projects.vo.SupplierVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Supplier)表控制层
 *
 * @author makejava
 * @since 2021-06-01 11:05:42
 */
@RestController
@RequestMapping("supplier")
public class SupplierController {
    /**
     * 服务对象
     */
    @Resource
    private SupplierService supplierService;

    /**
     * 查询供货商表中所有的商品
     */
    @GetMapping("selectsupplierall")
    public AjaxResponse selectsupplierall(){
        AjaxResponse ajaxResponse=null;
        List<Supplier> list=this.supplierService.queryall();
        return ajaxResponse.success(list);
    }

    //--------------------------------------------------

    @GetMapping("findall")
    public AjaxResponse findall(Integer currentPage,Integer pageSize){
        PageInfo<SupplierVo> info = supplierService.findAllPage(currentPage,pageSize);
        return AjaxResponse.success(info);
    }

    /**
     * 根据门店类型以及关键字查询的分页
     * @param branchnames
     * @param suppliername
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("findguanjz")
    public AjaxResponse findbyname(String branchnames,String suppliername,Integer currentPage,Integer pageSize){
        System.out.println("------------------"+branchnames);
        PageInfo<SupplierVo> info = supplierService.findAllByName(branchnames,suppliername,currentPage,pageSize);
        return AjaxResponse.success(info);
    }

    @PostMapping("addsupplier")
    public Integer addsupplier(@RequestBody Supplier supplier){
        System.out.println(supplier.toString());
        return supplierService.addsupplier(supplier);
    }
    @PostMapping("upsupplier")
    public Boolean upsupplier(@RequestBody Supplier supplier){
        System.out.println(supplier.toString());
        return supplierService.upsupplier(supplier);
    }
    @GetMapping("delsupplier")
    public Integer delsupplier(@RequestParam(value = "supplierid")Integer[] supplierid){
        return supplierService.deletepl(supplierid);
    }

}
