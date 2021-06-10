package com.trkj.projects.controller;

import com.trkj.projects.mybatis.entity.XsdocumentListType;
import com.trkj.projects.service.XsdocumentListTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (XsdocumentListType)表控制层
 *
 * @author makejava
 * @since 2021-06-10 16:23:20
 */
@RestController
@RequestMapping("xsdocumentListType")
public class XsdocumentListTypeController {
    /**
     * 服务对象
     */
    @Resource
    private XsdocumentListTypeService xsdocumentListTypeService;



}
