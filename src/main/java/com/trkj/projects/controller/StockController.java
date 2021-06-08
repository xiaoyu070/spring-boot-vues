package com.trkj.projects.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.projects.service.StockService;
import com.trkj.projects.vo.AjaxResponse;
import com.trkj.projects.vo.StockVo;
import com.trkj.projects.vo.StockVov;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * (Stock)表控制层
 *
 * @author makejava
 * @since 2021-06-04 14:19:35
 */
@RestController
@RequestMapping("stock")
public class StockController {
    /**
     * 服务对象
     */
    @Resource
    private StockService stockService;


    /**
     * 根据分店id查询库存商品加分页
     * @param value
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("findallbybranchid")
    public AjaxResponse findall(Integer value, int currentPage, int pageSize ){
        PageInfo<StockVov> info = stockService.selectbybranchid(value,currentPage,pageSize);
        return AjaxResponse.success(info);
    }
    /**
     * 根据商品类型以及关键字查询库存商品加分页
     * @return
     */
    @GetMapping("findallbylike")
    public AjaxResponse findall2(String stockade,int currentPage, int pageSize ){
        System.out.println("    "+stockade);
        PageInfo<StockVov> info = stockService.findallbytypeandlike(stockade,currentPage,pageSize);
        return AjaxResponse.success(info);
    }



    //---------------------------一哥的
    /**
     * 分页查询所有的商品信息
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/pageall")
    public AjaxResponse finall(Integer currentPage,Integer pageSize){
        System.out.println(currentPage+"aaaa"+pageSize);
        PageInfo<StockVo> info = stockService.findAll(currentPage,pageSize);
        return AjaxResponse.success(info);
    }

    /**
     * 查询库存为0 和所有库存
     * @param currentPage
     * @param pageSize
     * @param test22
     * @return
     */
    @GetMapping("selectkucun")
    public AjaxResponse selectkucun(Integer currentPage,Integer pageSize,int test22){
        System.out.println("test;:"+test22);
        PageInfo<StockVo> info = stockService.selectkucun(currentPage,pageSize,test22);
        System.out.println("selectkucun:::::::"+info+",,,"+"test:"+test22);
        return AjaxResponse.success(info);
    }

    /**
     * 模糊查询
     * @param currentPage
     * @param pageSize
     * @param testlike
     * @return
     */
    @GetMapping("selectlike")
    public  AjaxResponse selectlike(Integer currentPage,Integer pageSize,String testlike){
        PageInfo<StockVo> info=stockService.selectlike(currentPage,pageSize,testlike);
        return  AjaxResponse.success(info);
    }

    /**
     * 查询显示禁用商品
     * @param currentPage
     * @param pageSize
     * @param did
     * @return
     */
    @GetMapping("selectDisable")
    public  AjaxResponse selectDisable(Integer currentPage,Integer pageSize,boolean did){
        System.out.println("did:"+did);
        PageInfo<StockVo> info=stockService.selectDisable(currentPage,pageSize,did);
        return  AjaxResponse.success(info);
    }

    /**
     * 分页查询所有库存报警商品
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("KuCunBaoJin")
    public  AjaxResponse KuCunBaoJin(Integer currentPage,Integer pageSize){
        PageInfo<StockVo> info=stockService.KucunBaoJin(currentPage,pageSize);
        System.out.println(info);
        return  AjaxResponse.success(info);
    }

    /**
     * 模糊查询
     * @param currentPage
     * @param pageSize
     * @param KCmohu
     * @return
     */
    @GetMapping("KcMoHuSelect")
    public AjaxResponse KcMoHuSelec(Integer currentPage,Integer pageSize,String KCmohu ){
        PageInfo<StockVo> info =stockService.KcMoHuSelect(currentPage,pageSize,KCmohu);
        return AjaxResponse.success(info);
    }


}
