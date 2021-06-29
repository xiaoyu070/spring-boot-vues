package com.trkj.projects.controller;

import com.trkj.projects.anntation.Log;
import com.trkj.projects.jpa.entity.BranchEntity;
import com.trkj.projects.mybatis.entity.Branch;
import com.trkj.projects.service.BranchService;
import com.trkj.projects.vo.AjaxResponse;
import com.trkj.projects.vo.BranchVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * (Branch)表控制层
 *
 * @author makejava
 * @since 2021-05-31 21:13:34
 */
@RestController
@Slf4j
@RequestMapping("branch")
public class BranchController {
    /**
     * 服务对象
     */
    @Resource
    private BranchService branchService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Branch selectOne(Integer id) {
        return this.branchService.queryById(id);
    }

    /**
     * 查询所有分店
     */
    @Log("查询所有店面")
    @GetMapping("selectall")
    public AjaxResponse selectall(){
        AjaxResponse ajaxResponse=null;
        List<Branch> list=this.branchService.selctall();
        System.out.println(list.toString());
        return ajaxResponse.success(list);
    }

    /**
     * 查询总店
     * 用于采购进货（只能对总店进行采购）
     * @return
     */
    @Log("查询总店")
    @GetMapping("selectbranchand1")
    public AjaxResponse selectbranchand1(){
        List<BranchVo> list=this.branchService.selecttypeidand1();
        return AjaxResponse.success(list);
    }

//---------------------------------------------楷楷的
    @GetMapping("findbranch")
    public List<Branch> findall(){
        return branchService.findall();
    }


//--------------------------------------------老弟的

    @GetMapping("/branch1")
    public Page<BranchEntity> findBranchEntitiesBy(@RequestParam("branchPage")int page, @RequestParam("branchsize")int size){
        Pageable pageable = PageRequest.of(page-1,size);
        log.debug(pageable.getClass().getName());
        Page<BranchEntity> branchEntityPage = (Page<BranchEntity>) this.branchService.findAll(pageable);
        log.debug("---------------------------------"+branchEntityPage.toString());
        return branchEntityPage;
    }
    @PostMapping("/branch2")
    public Branch addBranch(@RequestBody Branch branch){
        System.out.println("braosjodo:+++++"+branch);
        branch = this.branchService.addBranch(branch);
        return branch;
    }
    @DeleteMapping("/branch3/{branchid}")
    public String deleteBranch(@PathVariable("branchid") int branchid){
        this.branchService.deleteWarehouse(branchid);
        this.branchService.deleteBranch(branchid);
        return "branchOk";
    }
    @PutMapping("/branch4")
    public Branch updateBranch(@RequestBody Branch branch){
        log.debug("开始修改");
        log.debug(branch.toString());
        branch = this.branchService.updateBranch(branch);
        return branch;
    }
    @GetMapping("/branch5")
    public Integer[] deleteByBranch(@RequestParam("branchid")Integer[] branchid){
        log.debug(branchid.toString());
        this.branchService.deleteByWarehouse(branchid);
        this.branchService.deleteByBranch(branchid);
        return branchid;
    }
    @GetMapping("/findall")
    public List<BranchEntity> list(){
        return this.branchService.findalls();
    }



    //---------------------------一哥的
    /**
     * 查询出所有店面
     * @return
     */
    @GetMapping("selectBranch")
    public AjaxResponse selectBranch(){
        AjaxResponse ajaxResponse =null;
        List<Branch> list =this.branchService.queryBranchAll();
        return ajaxResponse.success(list);
    }

}