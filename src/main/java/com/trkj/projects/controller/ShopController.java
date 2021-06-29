package com.trkj.projects.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.Shop;
import com.trkj.projects.mybatis.entity.Shops;
import com.trkj.projects.service.ShopService;
import com.trkj.projects.vo.AjaxResponse;
import com.trkj.projects.vo.ShopVo;
import com.trkj.projects.vo.Shopandstock;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Shop)表控制层
 *
 * @author makejava
 * @since 2021-05-31 19:30:36
 */
@RestController
@RequestMapping("shop")
public class ShopController {
    /**
     * 服务对象
     */
    @Resource
    private ShopService shopService;


//    @PostMapping("addshop")
//    public AjaxResponse addshop(@RequestBody Shop shop){
//        AjaxResponse ajaxResponse=null;
//        if(this.shopService.queryByName(shop.getSpName()).size()>0){
//            //return
//        }
//        this.shopService.insert(shop);
//        return ajaxResponse;
//    }
    //老商品添加中的商品信息查询
    @GetMapping("shopandstockvo")
    public AjaxResponse shopandstockvo(Integer currenPage,Integer pageSize,int value){
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<Shopandstock> list=this.shopService.queryshopanstock(value);
        System.out.println(list);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }

    //退货中老商品添加中的商品信息查询
    @GetMapping("shopandstockvotuihuo")
    public AjaxResponse shopandstockvotuihuo(Integer currenPage,Integer pageSize,int value){
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<Shopandstock> list=this.shopService.queryshopanstocktuihuo(value);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }

    @GetMapping("likeselect")
    public AjaxResponse likeselect(Integer currenPage,Integer pageSize,String test){
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<Shopandstock> list=this.shopService.likeselect(test);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }

    @GetMapping("showsupplier")
    public AjaxResponse showsupplier(Integer currenPage,Integer pageSize,Integer supplierid){
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<Shopandstock> list=this.shopService.showsupplier(supplierid);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }

    //------------------------------------------------

    /**
     * 查询所有加分页
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("page")
    public AjaxResponse pageshop(int currentPage, int pageSize){
        System.out.println(currentPage+"------------");
        PageInfo<ShopVo> page = this.shopService.queryAllByPage(currentPage,pageSize);
        return AjaxResponse.success(page);

    }
    @GetMapping("count")
    public Integer count(){
        return this.shopService.queryCount();
    }

    /**
     * 关键字模糊查询加分页
     * @param currentPage
     * @param pageSize
     * @param shopname
     * @return
     */
    @GetMapping("like")
    public AjaxResponse shoplike(Integer currentPage,Integer pageSize,@Param("shopname") String shopname,String shoptypename,Integer shopstatic){
        System.out.println(shopname+"--------shopname------");
        PageInfo<ShopVo> shop1= this.shopService.queryBytypeLike(shopname,shoptypename,shopstatic,currentPage,pageSize);
        return AjaxResponse.success(shop1);
    }

    /**
     * 根据商品类型查询加分页
     * @param currentPage
     * @param pageSize
     * @param shoptypename
     * @return
     */
    @GetMapping("type")
    public AjaxResponse findtype(Integer currentPage,Integer pageSize,@Param("shoptypename") String shoptypename,@Param("shopname") String shopname,Integer shopstatic){
        PageInfo<ShopVo> shop = this.shopService.queryAllByType(shopstatic,shopname,shoptypename,currentPage,pageSize);
        return AjaxResponse.success(shop);
    }

    /**
     * 根据商品状态查询加分页
     * @param currentPage
     * @param pageSize
     * @param shopstatic
     * @return
     */
    @GetMapping("static")
    public AjaxResponse findstatic(Integer currentPage, Integer pageSize, @Param("shopstatic") Integer shopstatic, String shoptypename, @Param("shopname")String shopname){
        PageInfo<ShopVo> shop = this.shopService.queryAllBySatic(shopstatic,shoptypename,shopname,currentPage,pageSize);
        return AjaxResponse.success(shop);
    }

    @GetMapping("jinyons")
    public Integer updateshopstatic(@RequestParam(value = "shopids")Integer[] shopid){
        return this.shopService.updatePil(shopid);
    }

    @GetMapping("jinyon")
    public Integer updatestatic(Integer shopid){
        return this.shopService.updateStatic(shopid);
    }
    @GetMapping("jinyon2")
    public Integer updatestatic2(Integer shopid){
        return this.shopService.updateStatic2(shopid);
    }

    /**
     * 批量删除
     * @param shopid
     * @return
     */
    @GetMapping("delshop")
    public Integer delshop(@RequestParam(value = "shopid") Integer[] shopid){
        return this.shopService.delShop(shopid);
    }

    @PostMapping("addshop")
    public Boolean addshop(@RequestBody Shops shop){
        return this.shopService.insertShop(shop);
    }
    @PostMapping("setshop")
    public Integer setshop(@RequestBody Shops shop){
        return this.shopService.updateshop(shop);
    }


    //---------------------------------一哥的
    @GetMapping("updatePrice")
    public int updatePrice(String spid,double jpe ){
//        shop=shopService.updatePrice(shop);
        Shop shop =new Shop();
        System.out.println("bianhao"+spid+jpe);
        return this.shopService.updatePrice(spid ,jpe);

    }

}