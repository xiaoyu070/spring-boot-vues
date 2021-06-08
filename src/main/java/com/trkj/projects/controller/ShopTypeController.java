package com.trkj.projects.controller;

import com.trkj.projects.mybatis.entity.ShopType;
import com.trkj.projects.service.ShopTypeService;
import com.trkj.projects.vo.AjaxResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ShopType)表控制层
 *
 * @author makejava
 * @since 2021-06-01 09:52:44
 */
@RestController
@RequestMapping("shopType")
public class ShopTypeController {
    /**
     * 服务对象
     */
    @Resource
    private ShopTypeService shopTypeService;

    /**
     * 查询商品类型表中的所有类型
     */
    @GetMapping("selectshoptypeall")
    public AjaxResponse selectshoptypeall(){
        AjaxResponse ajaxResponse=null;
        List<ShopType> list=this.shopTypeService.queryall();
        return ajaxResponse.success(list);
    }

    //------------------------------------

    @GetMapping("selecttypeall")
    public List<ShopType> selecttypeall(){
        return this.shopTypeService.queryTypeAll();
    }

    @PostMapping("addtype")
    public Integer addtype(@RequestBody ShopType shopType){
        return this.shopTypeService.insert(shopType);
    }
    @PostMapping("settype")
    public Integer settype(@RequestBody ShopType shopType){
        return this.shopTypeService.update(shopType);
    }
    @GetMapping("deltype")
    public Boolean deltype(Integer spTypeId){
        Boolean a=this.shopTypeService.deleteById(spTypeId);
        System.out.println("aaa:"+a);
        return a;
    }

}
