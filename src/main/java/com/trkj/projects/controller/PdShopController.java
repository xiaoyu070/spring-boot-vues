package com.trkj.projects.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.trkj.projects.mybatis.entity.Jintuicankao;
import com.trkj.projects.mybatis.entity.PdReport;
import com.trkj.projects.mybatis.entity.PdShop;
import com.trkj.projects.service.PdReportService;
import com.trkj.projects.service.PdShopService;
import com.trkj.projects.vo.AjaxResponse;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Result;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (PdShop)表控制层
 *
 * @author makejava
 * @since 2021-06-17 19:07:35
 */
@RestController
@RequestMapping("pdShop")
@Log4j2
public class PdShopController {
    /**
     * 服务对象
     */
    @Resource
    private PdShopService pdShopService;
    @Resource
    private PdReportService pdReportService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
//    @GetMapping("selectOne")
//    public PdShop selectOne(id) {
//        return this.pdShopService.queryById(id);
//    }

    /**
     * 新增盘点单号
     * @param PanDian
     * @return
     */
    @PostMapping("insertpd")
    public AjaxResponse insertpd(@RequestBody String PanDian){
        JSONObject jsonObject =JSONObject.parseObject(PanDian);
        String aaa =jsonObject.getString("aaa");
        PdReport list = JSON.parseObject(aaa,PdReport.class);
        list.setPdDate(new Date());
        System.out.println("盘点订单信息："+ aaa);




        String bbb=jsonObject.getString("bbb");
        System.out.println("商品："+bbb);
        List<PdShop> listshop =JSONArray.parseArray(bbb,PdShop.class);
//        list.getPdNumber(listshop)
//
        list.setPdNumber(listshop.get(0).getPdNumber());
        for(int i=0;i<listshop.size();i++){
            listshop.get(i).setPdId(list.getPdId());
            listshop.get(i).setWid(list.getWid());
        }
        System.out.println("sss"+listshop.toString());
        System.out.println("aaa"+list.toString());



        this.pdReportService.insert(list);
        this.pdShopService.insertBatch(listshop);
        System.out.println("商品信息："+listshop);
        return AjaxResponse.success("新增审核单成功！");
    }

    @GetMapping("updatepdnum")
    public int updatepdnum(Integer pdnum,String pddh){
        System.out.println("盘点数量"+pdnum+"商品编号"+pddh);
        return  this.pdShopService.updatepdnumber(pdnum,pddh);
    }

    @GetMapping("deletesp")
    public void deleteshop(@RequestParam ("id") int delect){
        System.out.println("删除成功"+delect);
        pdShopService.deleteshop(delect);
    }

}
