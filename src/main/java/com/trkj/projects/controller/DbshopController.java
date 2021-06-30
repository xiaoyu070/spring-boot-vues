package com.trkj.projects.controller;

import com.trkj.projects.mybatis.entity.Dbshop;
import com.trkj.projects.service.DbshopService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Dbshop)表控制层
 *
 * @author makejava
 * @since 2021-06-28 11:39:35
 */
@RestController
@RequestMapping("dbshop")
public class DbshopController {
    /**
     * 服务对象
     */
    @Resource
    private DbshopService dbshopService;

    /**
     * 通过主键查询单条数据
     *
//     * @param id 主键
//     * @return 单条数据
//     */
//    @GetMapping("selectOne")
//    public Dbshop selectOne(id) {
//        return this.dbshopService.queryById(id);
//    }

}
