package com.trkj.projects.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.Jintuicankao;
import com.trkj.projects.mybatis.entity.Stock;
import com.trkj.projects.mybatis.entity.Supplier;
import com.trkj.projects.service.JintuicankaoService;
import com.trkj.projects.vo.AjaxResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Jintuicankao)表控制层
 *
 * @author makejava
 * @since 2021-06-22 19:56:04
 */
@RestController
@RequestMapping("jintuicankao")
public class JintuicankaoController {
    /**
     * 服务对象
     */
    @Resource
    private JintuicankaoService jintuicankaoService;

    @PostMapping("addjintuo")
    public AjaxResponse addjintuo(@RequestBody String jintuicankao){

        JSONObject jsonObject =JSONObject.parseObject(jintuicankao);
        String aaa =jsonObject.getString("aaa");
        Jintuicankao list = JSON.parseObject(aaa,Jintuicankao.class);
        System.out.println("参考信息"+jsonObject);
        this.jintuicankaoService.insert(list);
        return AjaxResponse.success("新增审核单成功！");
    }

    @GetMapping("selectjinhuocangkao")
    public AjaxResponse selectjinhuocangkao(int currentPage, int pageSize){
        PageInfo<Jintuicankao>info =jintuicankaoService.selectjinhuocangkao(currentPage,pageSize);
        return  AjaxResponse.success(info);
    }

    /**
     * 修改进货参考数量
     * @param tuihuo
     * @param sid
     * @return
     */
    @GetMapping("updatecankao")
    public int updatecankao(Integer tuihuo,String sid){
        Jintuicankao jintuicankao =new Jintuicankao();
        System.out.println("参考"+tuihuo+"商品编号"+sid);
        return  this.jintuicankaoService.updatecangkao(tuihuo,sid);
    }
    @GetMapping("delete")
    public void deletecangkao(@RequestParam ("spShopid") String q){
        System.out.println("删除成功"+q);
        jintuicankaoService.deletecangkao(q);
    }

}
