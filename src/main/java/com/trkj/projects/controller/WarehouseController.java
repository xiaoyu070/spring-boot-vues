package com.trkj.projects.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.Warehouse;
import com.trkj.projects.service.WarehouseService;
import com.trkj.projects.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Warehouse)表控制层
 *
 * @author makejava
 * @since 2021-05-31 20:00:17
 */
@Slf4j
@RestController
@RequestMapping("warehouse")
public class WarehouseController {
    /**
     * 服务对象
     */
    @Resource
    private WarehouseService warehouseService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Warehouse selectOne(Integer id) {
        return this.warehouseService.queryById(id);
    }

    @GetMapping("selectall")
    public AjaxResponse selectall(){
        List<Warehouse> list=this.warehouseService.selectall();
        AjaxResponse ajaxResponse=null;
        return ajaxResponse.success(list);
    }

    @GetMapping("selectbranchid")
    public AjaxResponse selectbranchid(int id){
        List<Warehouse> list=this.warehouseService.selectbranchid(id);
        AjaxResponse ajaxResponse=null;
        return ajaxResponse.success(list);
    }

    @GetMapping("selectone")
    public AjaxResponse selectones(Integer id){
        List<Warehouse> wa = this.warehouseService.queryBybranId(id);
        return AjaxResponse.success(wa);
    }

    //--------------------------------老弟的
    @PostMapping("/addWarehouse")
    public Warehouse addWarehouse(@RequestBody Warehouse warehouse){
        warehouse = this.warehouseService.addWarehouse(warehouse);
        return warehouse;
    }
    @GetMapping("/delete")
    public Integer deleteWarehouse(@RequestParam("wid") Integer[] wid){
        log.debug(wid.toString());
        return this.warehouseService.deleteWarehouse(wid);
    }
    @PutMapping("/update")
    public Warehouse updateWarehouse(@RequestBody Warehouse warehouse){
        Warehouse warehouses = this.warehouseService.updateWarehouse(warehouse);
        return warehouses;
    }
    @GetMapping("/findbranchid")
    public AjaxResponse findBranchid(@RequestParam("pageSize")int pageSize, @RequestParam("size")int size, @RequestParam("branchid") Integer branchid){
        PageInfo<Warehouse> info = this.warehouseService.findbranchid(pageSize,size,branchid);
        log.debug(info.toString());
        return AjaxResponse.success(info);
    }
    @GetMapping("/findmohu")
    public AjaxResponse findMohu(@RequestParam("pageSize")int pageSize, @RequestParam("size")int size, @RequestParam("wname") String wname){
        PageInfo<Warehouse> info = this.warehouseService.findMohu(pageSize,size,wname);
        log.debug(info.toString());
        return AjaxResponse.success(info);
    }

    //-----------------------一哥的

    /**
     * 查询仓库下的店面
     */
    @GetMapping("selectWarehouse")
    public AjaxResponse  selectWarehouse(){
        AjaxResponse ajaxResponse=null;
        List<Warehouse> list=this.warehouseService.findAll();

        return ajaxResponse.success(list);
    }

}
