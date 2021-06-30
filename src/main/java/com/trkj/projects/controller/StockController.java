package com.trkj.projects.controller;

import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.Shop;
import com.trkj.projects.mybatis.entity.Stock;
import com.trkj.projects.service.StockService;
import com.trkj.projects.vo.AjaxResponse;
import com.trkj.projects.vo.PdResponseVo;
import com.trkj.projects.vo.StockVo;
import com.trkj.projects.vo.StockVov;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

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
     * 库存报警中的模糊查询
     * @param currentPage
     * @param pageSize
     * @param testlike2
     * @return
     */
    @GetMapping("KuCuntestLike")
    public  AjaxResponse KuCuntestLike(Integer currentPage,Integer pageSize,String testlike2){
        PageInfo<StockVo> info=stockService.kucunbaojinlike(currentPage,pageSize,testlike2);
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

    /**
     * 库存报警修改最低库存数量
     * @param
     * @param kcbj
     * @return
     */
    @GetMapping("Kcbjupdate")
    public int Kcbjupdate(String branchname,Integer kcbj ){
        System.out.println("bianhao"+branchname+kcbj);
        return  this.stockService.Kcbjupdate(branchname,kcbj);
    }



    /**
     * 根据店面和仓库查询报损报溢商品
     * @param currentPage
     * @param pageSize
     * @param param1
     * @param param2
     * @return
     */
    @GetMapping("selectbaosunbaoyi")
    public AjaxResponse selectbaosunbaoyi(int currentPage, int pageSize, int param1, int param2){
        PageInfo<StockVo> info =stockService.baosunbaoyiselect(currentPage,pageSize,param1,param2);
        System.out.println("商品信息"+info);
        return AjaxResponse.success(info);
    }

    /**
     * 根据店面和仓库,类别，查询所有库存商品
     * @param currentPage
     * @param pageSize

     * @return
     */
    @GetMapping("selectcangdian")
    public AjaxResponse selectcangdian(int currentPage, int pageSize, Integer dm, Integer ck,Integer lb){
        PageInfo<StockVo> info=stockService.selectdiancnag(currentPage,pageSize,dm,ck,lb);
        System.out.println("dm:"+dm+",,"+"ck:"+ck+",,"+"lb"+lb);
        System.out.println("selectcangdian:"+info);
        return AjaxResponse.success(info);
    }

    @GetMapping("baoojindmck")
    public AjaxResponse baoojindmck(int currentPage, int pageSize, Integer dm, Integer ck,Integer lb){
        PageInfo<StockVo>info =stockService.kucunbaojin(currentPage,pageSize,dm,ck,lb);
        System.out.println("dm:"+dm+",,"+"ck:"+ck+",,"+"lb"+lb);
        System.out.println("selectcangdian:"+info);
        return AjaxResponse.success(info);
    }

    /**
     * 根据商品类型查询
     * @param currentPage
     * @param pageSize
     * @param lb
     * @return
     */
    @GetMapping("typeselect")
    public  AjaxResponse typeselect(int currentPage, int pageSize, Integer lb){
        PageInfo<StockVo> info =stockService.typeselect(currentPage,pageSize,lb);
        System.out.println("lb"+lb);
        return  AjaxResponse.success(info);
    }

    /**
     * 查询所有进或参考
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("selectjhck")
    public  AjaxResponse selectjhck(int currentPage, int pageSize){
        PageInfo<StockVo> info =stockService.selectjhck(currentPage,pageSize);
        System.out.println(info);
        return  AjaxResponse.success(info);
    }

    @GetMapping("selecttypejhck")
    public  AjaxResponse selecttypejhck(int currentPage, int pageSize,int typeid){
        System.out.println(currentPage+",,,");
        System.out.println(pageSize+"....");
        System.out.println(typeid);
        PageInfo<StockVo> info =stockService.selecttypejhck(currentPage,pageSize,typeid);
        System.out.println(info);
        return  AjaxResponse.success(info);
    }

    @PostMapping("updatepilian")
    public Integer updatepilian(@RequestBody List<PdResponseVo> stocks){
        System.out.println("盘点："+stocks);
        if(stocks != null) {
            for (int i = 0; i < stocks.size(); i++) {
                this.stockService.updatepilian(stocks.get(i).getPdNumber(), stocks.get(i).getSpShopid());
                return 1;
            }
        }
        return 0;
    }


}
