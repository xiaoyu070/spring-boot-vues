package com.trkj.projects.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.Expenseincome;
import com.trkj.projects.service.ExpenseincomeService;
import com.trkj.projects.vo.AjaxResponse;
import com.trkj.projects.vo.ExpenEntryVo;
import com.trkj.projects.vo.ExpenseincomeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@Slf4j
@RestController
@RequestMapping("expenseincome")
public class ExpenseincomeController {
    @Resource
    private ExpenseincomeService service;

    @GetMapping("/selectexpen")
    public AjaxResponse selectExpen(@RequestParam("pageSize")int pageSize,@RequestParam("size")int size){
        PageInfo<ExpenEntryVo> info = service.selectExpen(pageSize,size);
        log.debug("1111111111111111"+info.toString());
        return AjaxResponse.success(info);
    }
    @PostMapping("/selectentry")
    public AjaxResponse selectEntry(@RequestBody String a){
            //@RequestParam("pageSize2")int pageSize,@RequestParam("size2")int size,@RequestParam("typeName")String typeName
            JSONObject jsonObject=JSONObject.parseObject(a);
            JSONObject jsonObject2=jsonObject.getJSONObject("params");
            System.out.println(jsonObject2);
            System.out.println(jsonObject);
            String typeName = jsonObject2.getString("typeName");
            System.out.println("type:"+typeName);
            int pageSize = jsonObject2.getInteger("pageSize");
            int size = jsonObject2.getInteger("size");
            PageInfo<ExpenseincomeVo> info = service.selectEntry(pageSize,size,typeName);
            log.debug("1111111111111111"+info.toString());
            return AjaxResponse.success(info);
    }
}
