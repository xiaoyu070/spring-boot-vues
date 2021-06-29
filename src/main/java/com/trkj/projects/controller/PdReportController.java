package com.trkj.projects.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.PdReport;
import com.trkj.projects.service.PdReportService;
import com.trkj.projects.vo.AjaxResponse;
import com.trkj.projects.vo.BsReportVo;
import com.trkj.projects.vo.PdResponseVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (PdReport)表控制层
 *
 * @author makejava
 * @since 2021-06-17 19:02:08
 */
@RestController
@RequestMapping("pdReport")
public class PdReportController {
    /**
     * 服务对象
     */
    @Resource
    private PdReportService pdReportService;

//    /**
//     * 通过主键查询单条数据
//     *
//     * @param id 主键
//     * @return 单条数据
//     */
//    @GetMapping("selectOne")
//    public PdReport selectOne(id) {
//        return this.pdReportService.queryById(id);
//    }

    @GetMapping("selectPDD")
    public AjaxResponse selectPDD(int currentPage, int pageSize){
        PageInfo<PdResponseVo> info =pdReportService.selectddh(currentPage,pageSize);
        System.out.println("kkkkk"+info);
        return  AjaxResponse.success(info);
    }
    @GetMapping("selectpdid")
    public AjaxResponse selectpdid(Integer currentPage, Integer pageSize,String dh){
        PageInfo<PdResponseVo> info =pdReportService.selectpdid(currentPage,pageSize,dh);
        System.out.println("sss"+dh);
        System.out.println(info);
        return AjaxResponse.success(info);
    }

    @GetMapping("deletepddss")
    public void deletepddss(@RequestParam ("pdId") String pdid){
        System.out.println("删除成功"+pdid);
        pdReportService.delectpdd(pdid);
    }

    @GetMapping("selectone")
    public AjaxResponse selectone(int currentPage, int pageSize){
        PageInfo<PdResponseVo> info =pdReportService.selectpddone(currentPage,pageSize);
        System.out.println("kkkkk"+info);
        return  AjaxResponse.success(info);
    }


    @GetMapping("selectwherewid")
    public AjaxResponse selectwherewid(Integer currentPage, Integer pageSize,Integer w){
        PageInfo<PdResponseVo> info =pdReportService.selectwherewid(currentPage,pageSize,w);
        System.out.println("sss"+w);
        System.out.println(info);
        return AjaxResponse.success(info);
    }
    @GetMapping("selectwherepdid")
    public AjaxResponse selectwherepdid(Integer currentPage, Integer pageSize,String pd){
      PageInfo<PdResponseVo> info =pdReportService.selectwherepdid(currentPage,pageSize,pd);
        System.out.println("currentPage"+currentPage);
        System.out.println("pageSize"+pageSize);
        System.out.println("sss"+pd);
        System.out.println(info);
       return AjaxResponse.success(info);

    }

    @GetMapping("selectpddh")
    public AjaxResponse selectpddh(int currentPage, int pageSize){
        PageInfo<PdResponseVo> info =pdReportService.selectpddh(currentPage,pageSize);
        System.out.println("kkkkk"+info);
        return  AjaxResponse.success(info);
    }

    @PostMapping("selectpddh")
    public  AjaxResponse selectdate(@RequestBody String a){
        JSONObject jsonObject=JSONObject.parseObject(a);
        int currenPage = jsonObject.getInteger("currenPage");
        int pageSize = jsonObject.getInteger("pageSize");
        String data1 = jsonObject.getString("data1");
        String data2 = jsonObject.getString("data2");
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<PdResponseVo> list=this.pdReportService.selectpadate(data1,data2);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }



}
