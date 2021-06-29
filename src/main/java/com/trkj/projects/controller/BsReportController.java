package com.trkj.projects.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.BsReport;
import com.trkj.projects.service.BsReportService;
import com.trkj.projects.vo.AjaxResponse;
import com.trkj.projects.vo.BsReportVo;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (BsReport)表控制层
 *
 * @author makejava
 * @since 2021-06-15 20:26:51
 */
@RestController
@RequestMapping("bsReport")

public class BsReportController {
    /**
     * 服务对象
     */
    @Resource
    private BsReportService bsReportService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BsReport selectOne(Integer id) {
        return this.bsReportService.queryById(id);
    }

    /**
     * 查询所有报损报溢订单
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("selectdjh")
    public AjaxResponse selectdjh(int currentPage, int pageSize){
        PageInfo<BsReportVo> info =bsReportService.selectdj(currentPage,pageSize);
        System.out.println("kkkkk"+info);
        return  AjaxResponse.success(info);
    }



    @GetMapping("selectbsLossReport")
    public  AjaxResponse selectbsLossReport(Integer currentPage, Integer pageSize,String dh){
       System.out.println(currentPage+",21232323   "+pageSize+"   234567  "+dh);
        PageInfo<BsReportVo> info =bsReportService.selectbsLossreport(currentPage,pageSize,dh);
        System.out.println("sss"+dh);
        System.out.println(info);
        return AjaxResponse.success(info);
    }

    /**
     * 根据报损报溢类型查询所有单据信息
     * @param currentPage
     * @param pageSize
     * @param documentsTypeId
     * @return
     */
    @GetMapping("selectbsbytype")
    public  AjaxResponse selectbsbytype(Integer currentPage, Integer pageSize, Integer documentsTypeId){
        System.out.println(currentPage+",,,"+pageSize+",,,,"+documentsTypeId);
        PageInfo<BsReportVo> info =bsReportService.selectbsbytype(currentPage,pageSize,documentsTypeId);
        return AjaxResponse.success(info);
    }
    @PostMapping("selectdate")
    public  AjaxResponse selectdate(@RequestBody String a){
        JSONObject jsonObject=JSONObject.parseObject(a);
        int currenPage = jsonObject.getInteger("currenPage");
        int pageSize = jsonObject.getInteger("pageSize");
        String data1 = jsonObject.getString("data1");
        String data2 = jsonObject.getString("data2");
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<BsReportVo> list=this.bsReportService.selectdate(data1,data2);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }

}
