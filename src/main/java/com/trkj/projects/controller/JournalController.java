package com.trkj.projects.controller;

import com.trkj.projects.mybatis.entity.Journal;
import com.trkj.projects.service.JournalService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

}
