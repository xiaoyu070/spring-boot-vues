package com.trkj.projects.controller;

import com.trkj.projects.mybatis.entity.BsByType;
import com.trkj.projects.service.BsByTypeService;
import com.trkj.projects.vo.AjaxResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsByType)表控制层
 *
 * @author makejava
 * @since 2021-06-10 14:54:38
 */
@RestController
@RequestMapping("bsByType")
public class BsByTypeController {
    /**
     * 服务对象
     */
    @Resource
    private BsByTypeService bsByTypeService;


    @GetMapping("/selectbsby")
    public AjaxResponse selectbsby(){
        AjaxResponse ajaxResponse =null;
        List<BsByType> list =this.bsByTypeService.queryById();
        System.out.println("报损报溢"+list);
        return ajaxResponse.success(list);
    }


}
