package com.trkj.projects.controller;

import com.trkj.projects.service.DocumentListTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DocumentListType)表控制层
 *
 * @author makejava
 * @since 2021-06-03 22:08:41
 */
@RestController
@RequestMapping("documentListType")
public class DocumentListTypeController {
    /**
     * 服务对象
     */
    @Resource
    private DocumentListTypeService documentListTypeService;

}
