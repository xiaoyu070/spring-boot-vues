package com.trkj.projects.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.Jintuicankao;
import com.trkj.projects.mybatis.entity.Jintuicankaoa;
import com.trkj.projects.service.JintuicankaoaService;
import com.trkj.projects.vo.AjaxResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Jintuicankaoa)表控制层
 *
 * @author makejava
 * @since 2021-06-28 18:41:39
 */
@RestController
@RequestMapping("jintuicankaoa")
public class JintuicankaoaController {
    /**
     * 服务对象
     */
    @Resource
    private JintuicankaoaService jintuicankaoaService;

    @PostMapping("addjintuo1")
    public AjaxResponse addjintuo(@RequestBody String jintuicankao){

        JSONObject jsonObject =JSONObject.parseObject(jintuicankao);
        String aaa =jsonObject.getString("aaa");
        Jintuicankaoa list = JSON.parseObject(aaa,Jintuicankaoa.class);
        System.out.println("参考信息"+jsonObject);
        this.jintuicankaoaService.insert(list);
        return AjaxResponse.success("新增审核单成功！");
    }
    @GetMapping("selectjinhuocangkao1")
    public AjaxResponse selectjinhuocangkao(int currentPage, int pageSize){
        PageInfo<Jintuicankaoa> info =jintuicankaoaService.selectjinhuocangkao1(currentPage,pageSize);
        return  AjaxResponse.success(info);
    }
    @GetMapping("updatecankao1")
    public int updatecankao1(Integer tuihuo,String sid){
        Jintuicankaoa jintuicankaoa =new Jintuicankaoa();
        System.out.println("参考"+tuihuo+"商品编号"+sid);
        return  this.jintuicankaoaService.updatecangkao1(tuihuo,sid);
    }
    @GetMapping("delete1")
    public void deletecangkao1(@RequestParam ("spShopid") String q){
        System.out.println("删除成功"+q);
        jintuicankaoaService.deletecangkao1(q);
    }

}
