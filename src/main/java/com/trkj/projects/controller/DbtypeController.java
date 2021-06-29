package com.trkj.projects.controller;

import com.trkj.projects.mybatis.entity.BsByType;
import com.trkj.projects.mybatis.entity.Dbtype;
import com.trkj.projects.service.DbtypeService;
import com.trkj.projects.vo.AjaxResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Dbtype)表控制层
 *
 * @author makejava
 * @since 2021-06-28 09:04:48
 */
@RestController
@RequestMapping("dbtype")
public class DbtypeController {
    /**
     * 服务对象
     */
    @Resource
    private DbtypeService dbtypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */

    @GetMapping("selectdbtype")
    public AjaxResponse selectdbtype(){
        AjaxResponse ajaxResponse =null;
        List<Dbtype> list =this.dbtypeService.selectdbtype();
        System.out.println("调拨"+list);
        return ajaxResponse.success(list);
    }


}
