package com.trkj.projects.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.trkj.projects.mybatis.entity.Journal;
import com.trkj.projects.service.JournalService;
import com.trkj.projects.vo.AjaxResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Journal)表控制层
 *
 * @author makejava
 * @since 2021-06-16 23:33:28
 */
@RestController
@RequestMapping("journal")
public class JournalController {
    /**
     * 服务对象
     */
    @Resource
    private JournalService journalService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Journal selectOne(Integer id) {
        return this.journalService.queryById(id);
    }

    @PostMapping("findAll")
    public AjaxResponse findAll(@RequestBody String a){
        JSONObject jsonObject = JSON.parseObject(a);
        Integer currenPage = jsonObject.getInteger("currenPage");
        Integer pageSize = jsonObject.getInteger("pageSize");
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<Journal> list = this.journalService.findAll();
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
}
