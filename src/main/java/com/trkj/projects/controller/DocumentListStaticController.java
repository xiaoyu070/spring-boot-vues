package com.trkj.projects.controller;

import com.trkj.projects.service.DocumentListStaticService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DocumentListStatic)表控制层
 *
 * @author makejava
 * @since 2021-06-03 22:08:28
 */
@RestController
@RequestMapping("documentListStatic")
public class DocumentListStaticController {
    /**
     * 服务对象
     */
    @Resource
    private DocumentListStaticService documentListStaticService;


}
