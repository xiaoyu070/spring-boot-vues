package com.trkj.projects.controller;

import com.trkj.projects.mybatis.entity.XsdocumentListStatic;
import com.trkj.projects.service.XsdocumentListStaticService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (XsdocumentListStatic)表控制层
 *
 * @author makejava
 * @since 2021-06-10 16:22:30
 */
@RestController
@RequestMapping("xsdocumentListStatic")
public class XsdocumentListStaticController {
    /**
     * 服务对象
     */
    @Resource
    private XsdocumentListStaticService xsdocumentListStaticService;



}
