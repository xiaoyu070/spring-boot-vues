package com.trkj.projects.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.trkj.projects.mybatis.entity.BsByShop;
import com.trkj.projects.mybatis.entity.BsReport;
import com.trkj.projects.mybatis.entity.Stock;
import com.trkj.projects.service.BsByShopService;
import com.trkj.projects.service.BsReportService;
import com.trkj.projects.service.StockService;
import com.trkj.projects.vo.AjaxResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.PrivateKey;
import java.util.Date;
import java.util.List;

/**
 * (BsByShop)表控制层
 *
 * @author makejava
 * @since 2021-06-15 20:22:37
 */
@RestController
@RequestMapping("bsByShop")
public class BsByShopController {
    /**
     * 服务对象
     */
    @Resource
    private BsByShopService bsByShopService;
    @Resource
    private BsReportService bsReportService;
    @Resource
    private StockService stockService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BsByShop selectOne(Integer id) {
        return this.bsByShopService.queryById(id);
    }
    @PostMapping("insertAddbsby")
    public AjaxResponse insertAddbsby(@RequestBody String bsbyshop){
        JSONObject jsonObject =JSONObject.parseObject(bsbyshop);
        System.out.println("12345"+jsonObject);
        String aaa = jsonObject.getString("aaa") ;
        BsReport list = JSON.parseObject(aaa, BsReport.class);
        list.setBsDate(new Date());
        this.bsReportService.insert(list);
        String bbb = jsonObject.getString("bbb");
//        System.out.println("商品："+bbb);
        List<BsByShop> listshop = JSONArray.parseArray(bbb, BsByShop.class);
//        System.out.println("listshop::"+listshop);
        Stock ck =new Stock();
        for(int i=0;i<listshop.size();i++){
            ck.setSkShopid(listshop.get(i).getSpShopid());
            ck.setSpWarehouseId(list.getWid());
            ck.setSpStorefrontId(list.getBranchid());
            ck.setSkNumber(listshop.get(i).getBsBaosunhou());
            listshop.get(i).setbsLossReport(list.getBsLossReport());
            this.stockService.updatestocknumber(ck);
        }
        System.out.println("库存信息："+ck.toString());

        System.out.println("商品信息："+listshop);
        this.bsByShopService.insertBatch(listshop);
        return AjaxResponse.success("新增审核单成功！");
    }

}
