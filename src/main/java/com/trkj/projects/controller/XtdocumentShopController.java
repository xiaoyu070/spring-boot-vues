package com.trkj.projects.controller;

import com.trkj.projects.mybatis.entity.XtdocumentShop;
import com.trkj.projects.service.XtdocumentShopService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (XtdocumentShop)表控制层
 *
 * @author makejava
 * @since 2021-06-18 10:42:28
 */
@RestController
@RequestMapping("xtdocumentShop")
public class XtdocumentShopController {
    /**
     * 服务对象
     */
    @Resource
    private XtdocumentShopService xtdocumentShopService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public XtdocumentShop selectOne(Integer id) {
        return this.xtdocumentShopService.queryById(id);
    }

}
