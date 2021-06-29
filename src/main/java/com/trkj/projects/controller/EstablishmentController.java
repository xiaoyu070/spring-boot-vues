package com.trkj.projects.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.projects.anntation.Log;
import com.trkj.projects.mybatis.entity.Establishment;
import com.trkj.projects.service.EstablishmentService;
import com.trkj.projects.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Establishment)表控制层
 *
 * @author makejava
 * @since 2021-06-06 21:45:48
 */
@Slf4j
@RestController
@RequestMapping("establishment")
public class EstablishmentController {
    /**
     * 服务对象
     */
    @Resource
    private EstablishmentService establishmentService;


    /**
     * 通过店面外键查询银行
     */
    @Log("通过店面id查询该店面下的所有商品")
    @GetMapping("selectestab")
    public AjaxResponse selectestab(int id){
        System.out.println("id:"+id);
        List<Establishment> list= this.establishmentService.selectestab(id);
        return AjaxResponse.success(list);
    }


    //------------------------------------------------

    /**
     * 根据分店查询所有的银行账户
     */
    @Log("根据店面查询该店面的所有账户")
    @GetMapping("selectbyid")
    public AjaxResponse selectbyid(Integer id){
        List<Establishment> list = establishmentService.selectbybranchid(id);
        return AjaxResponse.success(list);
    }


    //---------------------老弟的
    @GetMapping("/findAll")
    public AjaxResponse findAll(int pageSize, int size){
        PageInfo<Establishment> info = establishmentService.findAll(pageSize,size);
        log.debug(info.toString());
        return AjaxResponse.success(info);
    }
    @GetMapping("/findbranchid")
    public AjaxResponse findBranchid(@RequestParam("pageSize")int pageSize,@RequestParam("size")int size,@RequestParam("branchid") Integer branchid){
        PageInfo<Establishment> info = establishmentService.findbranchid(pageSize,size,branchid);
        log.debug(info.toString());
        return AjaxResponse.success(info);
    }
    @PostMapping("/addEstab")
    public Establishment addEstab(@RequestBody Establishment establishment){
        Establishment establishments = establishmentService.addEstab(establishment);
        return establishments;
    }
    @PutMapping("/updataEstab")
    public Establishment updata(@RequestBody Establishment establishment){
        Establishment establishments = establishmentService.updataEstab(establishment);
        return  establishments;
    }
    @GetMapping("/delect")
    public Integer delect(@RequestParam("xid") Integer[] xid){
        log.debug("11111111111111"+"xid");
        return establishmentService.delect(xid);
    }
    @GetMapping("/findesall")
    public List<Establishment> findAll(){
        return establishmentService.finAll();
    }
}
