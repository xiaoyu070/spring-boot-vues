package com.trkj.projects.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.trkj.projects.mybatis.entity.Dbdanju;
import com.trkj.projects.mybatis.entity.Dbshop;
import com.trkj.projects.service.DbdanjuService;
import com.trkj.projects.service.DbshopService;
import com.trkj.projects.vo.AjaxResponse;
import com.trkj.projects.vo.DbdanjuVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Dbdanju)表控制层
 *
 * @author makejava
 * @since 2021-06-28 11:31:41
 */
@RestController
@RequestMapping("dbdanju")
public class DbdanjuController {
    /**
     * 服务对象
     */
    @Resource
    private DbdanjuService dbdanjuService;
    @Resource
    private DbshopService dbshopService;

    @PostMapping("insertdb")
    public AjaxResponse insertdb(@RequestBody String dbshop){
        JSONObject jsonObject =JSONObject.parseObject(dbshop);
        String aaa =jsonObject.getString("aaa") ;
        Dbdanju list = JSON.parseObject(aaa,Dbdanju.class);
        list.setDbdate(new Date());
        this.dbdanjuService.insert(list);
        String bbb=jsonObject.getString("bbb");
        List<Dbshop> listshop = JSONArray.parseArray(bbb,Dbshop.class);
        this.dbshopService.insertBatch(listshop);
        return AjaxResponse.success("新增审核单成功！");
    }
    @GetMapping("selectdbcx")
    public AjaxResponse  selectdbcx(){
           List<DbdanjuVo> list =this.dbdanjuService.selectdbcx();
           System.out.println(list);
            return AjaxResponse.success(list);
    }
}
