package com.trkj.projects.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.XsdocumentShop;
import com.trkj.projects.service.XsdocumentShopService;
import com.trkj.projects.vo.AjaxResponse;
import com.trkj.projects.vo.SpcgmxVo;
import com.trkj.projects.vo.SpxstjVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (XsdocumentShop)表控制层
 *
 * @author makejava
 * @since 2021-06-18 17:07:15
 */
@RestController
@RequestMapping("xsdocumentShop")
public class XsdocumentShopController {
    /**
     * 服务对象
     */
    @Resource
    private XsdocumentShopService xsdocumentShopService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public XsdocumentShop selectOne(Integer id) {
        return this.xsdocumentShopService.queryById(id);
    }

    /**
     * 商品销售明细表查询
     */
    @GetMapping("xsspmx")
    public AjaxResponse selectcx(int currentPage, int pageSize) {
        AjaxResponse ajaxResponse = null;
        PageInfo<SpxstjVo> list = this.xsdocumentShopService.xsspmx(currentPage, pageSize);
        return ajaxResponse.success(list);
    }

    @GetMapping("xssphz")
    public AjaxResponse selectcx1() {
        AjaxResponse ajaxResponse = null;
        List<SpxstjVo> list = this.xsdocumentShopService.xssphz();
        return ajaxResponse.success(list);
    }

    @GetMapping("xsspfltj")
    public AjaxResponse selectcx2() {
        AjaxResponse ajaxResponse = null;
        List<SpxstjVo> list = this.xsdocumentShopService.xsspfltj();
        return ajaxResponse.success(list);
    }

    @GetMapping("ckcx")
    public AjaxResponse selectcx3() {
        AjaxResponse ajaxResponse = null;
        List<SpxstjVo> list = this.xsdocumentShopService.ckcx();
        return ajaxResponse.success(list);

    }
}
