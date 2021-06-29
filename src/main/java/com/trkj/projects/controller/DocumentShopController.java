package com.trkj.projects.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.anntation.Log;
import com.trkj.projects.mybatis.entity.DocumentList;
import com.trkj.projects.mybatis.entity.DocumentShop;
import com.trkj.projects.mybatis.entity.XsdocumentList;
import com.trkj.projects.service.DocumentListService;
import com.trkj.projects.service.DocumentShopService;
import com.trkj.projects.service.XsdocumentListService;
import com.trkj.projects.vo.*;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (DocumentShop)表控制层
 *
 * @author makejava
 * @since 2021-06-04 10:36:33
 */
@RestController
@RequestMapping("documentShop")
public class DocumentShopController {
    /**
     * 服务对象
     */
    @Resource
    private DocumentShopService documentShopService;

    @Resource
    private DocumentListService documentListService;

    @Resource
    private XsdocumentListService xsdocumentListService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DocumentShop selectOne(Integer id) {
        return this.documentShopService.queryById(id);
    }
    /**
     * 根据单价号查询商品
     */
    @Log("通过单据号查询了某个单据中包含的商品")
    @PostMapping("selectnumbers")
    public AjaxResponse selectnumbers(@RequestBody String a){
        JSONObject jsonObject = JSON.parseObject(a);
        System.out.println("sssss:"+jsonObject);
        Integer currenPage = jsonObject.getInteger("currenPage");
        Integer pageSize = jsonObject.getInteger("pageSize");
        String number = jsonObject.getString("number");
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<DocumentShopVo> list= this.documentShopService.selectnumbers(number);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    @Log("通过单据号查询了状态为已审核的单据")
    @PostMapping("selectstatezreonumber")
    public AjaxResponse selectstatezreonumber(@RequestBody String a){
        JSONObject jsonObject = JSON.parseObject(a);
        Integer currenPage = jsonObject.getInteger("currenPage");
        Integer pageSize = jsonObject.getInteger("pageSize");
        String numbers = jsonObject.getString("number");
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<DocumentShopVo> list= this.documentShopService.selectstatezreoNumbers(numbers);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    @Log("删除了待审核单据中的某个商品")
    @PostMapping("deleteshopall")
    public AjaxResponse deleteshopall(@RequestBody String a){
        JSONObject jsonObject=JSONObject.parseObject(a);
        String shops = jsonObject.getString("tabshop");
        List<DocumentShopVo> list=JSONObject.parseArray(shops,DocumentShopVo.class);
        boolean tt = true;
        //循环删除选中的单据商品
        for (int i=0;i<list.size();i++){
            tt = this.documentShopService.deleteById(list.get(i).getId());
        }
        double zzz=0;
        String number = list.get(0).getDlNumber();
        //循环获取修改后的总金额
        List<DocumentShopVo> listshop =this.documentShopService.selectnumbers(number);
        for(int i = 0;i<listshop.size();i++){
            zzz += listshop.get(i).getZje();
        }
        //根据传入的单据号修改应付实付金额
        DocumentList listsss = new DocumentList();
        listsss.setDlNumber(list.get(0).getDlNumber());
        listsss.setDlYfje(zzz);
        listsss.setDlSfje(zzz);
        this.documentListService.update(listsss);
        if(tt == true){
            return AjaxResponse.success("删除成功！");
        }else{
            return AjaxResponse.success("删除失败！");
        }
    }
    @Log("修改了待审核单据中的某个商品")
    @PostMapping("/updateshop")
    public AjaxResponse updateshop(@RequestBody String a){
        JSONObject jsonObject = JSONObject.parseObject(a);
        String one = jsonObject.getString("tabshop");
        DocumentShop documentShop = JSONObject.parseObject(one,DocumentShop.class);
        //修改商品的商品数量
        this.documentShopService.update(documentShop);
        double zzz = 0;
        String number = documentShop.getDlNumber();
        //循环获取修改后的总金额
        List<DocumentShop> listshop = this.documentShopService.selectdocumentlistshop(number);
        for(int i = 0;i<listshop.size();i++){
            zzz += listshop.get(i).getZje();
        }
        //根据传入的单据号修改应付实付金额
        DocumentList list = new DocumentList();
        list.setDlNumber(documentShop.getDlNumber());
        list.setDlYfje(zzz);
        list.setDlSfje(zzz);
        this.documentListService.update(list);
        return AjaxResponse.success("修改成功！");
    }
    //查询商品汇总
    @Log("查询商品汇总")
    @GetMapping("selecthuizoshop")
    public AjaxResponse selecthuizoshop(Integer currenPage,Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<Documentlistshopstatiezreovo> list= this.documentShopService.huizoshop();
        System.out.println("list:"+list.toString());
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    //模糊查询商品汇总
    @Log("模糊查询审核单据中的汇总表")
    @GetMapping("selecthuizoshoplike")
    public AjaxResponse selecthuizoshoplike(Integer currenPage,Integer pageSize,String ttt){
        System.out.println("currenPage"+currenPage+"pageSize"+pageSize+"ttt"+ttt);
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<Documentlistshopstatiezreovo> list= this.documentShopService.huizoshoplike(ttt);
        System.out.println("list:"+list.toString());
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    //根据商品名称查询单据明细
    @Log("根据商品名称查询某个商品下包含的单据明细")
    @GetMapping("selectshopnamehuizovo")
    public AjaxResponse selectshopnamehuizovo(Integer currenPage,Integer pageSize,String txxt){
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg = PageHelper.startPage(currenPage,pageSize);
        List<Documentlistshopstatiezreojinhuomingxivo> list= this.documentShopService.selectshopnamehuizovo(txxt);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }


    /**
     *
     * 修改商品更新该单据的金额
     * @param a
     * @return
     */

    @PostMapping("xsupdateshop")
    public AjaxResponse xsupdateshop(@RequestBody String a){
        JSONObject jsonObject = JSONObject.parseObject(a);
        String one = jsonObject.getString("tabshop");
        DocumentShop documentShop = JSONObject.parseObject(one,DocumentShop.class);
        this.documentShopService.update(documentShop);
        double zzz = 0;
        List<DocumentShopVo> listshop= this.documentShopService.selectnumbers(documentShop.getDlNumber());
        for(int i = 0;i<listshop.size();i++){
            zzz += listshop.get(i).getZje();
        }
        //根据修改的商品的单据号查询该单据信息
        XsDocumentlistVo xsvo = xsdocumentListService.queryBydlnumber(documentShop.getDlNumber());
        System.out.println(documentShop.getDlNumber()+" : "+xsvo.toString());
        XsdocumentList list = new XsdocumentList();
        list.setDlNumber(documentShop.getDlNumber());
        list.setDlzonje(zzz);//总金额
        //应收金额=总金额*折扣率
        double aa = xsvo.getV_type_ck() * zzz;
        list.setDlYsje(aa);//应收
        list.setDlSsje(aa);//实收
        //优惠=总金额-应收
        double yh = zzz-aa;
        list.setDlYhje(yh);
        this.xsdocumentListService.update(list);
        return AjaxResponse.success("修改成功！");
    }

    /**
     * 根据单据号删除商品更新该单据的金额
     * @param a
     * @return
     */
    @PostMapping("xsdeleteshopall")
    public AjaxResponse xsdeleteshopall(@RequestBody String a){
        JSONObject jsonObject=JSONObject.parseObject(a);
        String shops = jsonObject.getString("tabshop");
        List<DocumentShopVo> list=JSONObject.parseArray(shops,DocumentShopVo.class);
        System.out.println("删掉商品前："+list.toString());
        boolean tt = true;
        for (int i=0;i<list.size();i++){
            tt = this.documentShopService.deleteById(list.get(i).getId());
        }
        if(tt == true){
            double zzz = 0;
            List<DocumentShopVo> listshop= this.documentShopService.selectnumbers(list.get(0).getDlNumber());
            for(int i = 0;i<listshop.size();i++){
                zzz += listshop.get(i).getZje();
            }
            XsDocumentlistVo xsvo = xsdocumentListService.queryBydlnumber(list.get(0).getDlNumber());
            XsdocumentList xsdocumentList = new XsdocumentList();
            xsdocumentList.setDlNumber(xsvo.getDlNumber());
            xsdocumentList.setDlzonje(zzz);
            double aa = xsvo.getV_type_ck() * zzz;
            xsdocumentList.setDlYsje(aa);
            xsdocumentList.setDlSsje(aa);
            double yh = zzz-aa;
            xsdocumentList.setDlYhje(yh);
            this.xsdocumentListService.update(xsdocumentList);
            return AjaxResponse.success("删除成功！");
        }else{
            return AjaxResponse.success("删除失败！");
        }
    }

    /**
     * 根据分店id查询销售商品
     * @return
     */
    @GetMapping("selectBycid")
    public AjaxResponse selectBycid(Integer cid,String data1,String data2,Integer currentPage, Integer pageSize,String name){
        PageInfo<DocumentShopVo> page = documentShopService.selectbycid(cid,data1,data2,currentPage,pageSize,name);
        System.out.println("商品信息："+page);
        return AjaxResponse.success(page);
    }

    @GetMapping("selectByname")
    public AjaxResponse selectmh(String input, String selType, int currentPage, int pageSize) {
        System.out.println(input+"mmm"+selType);
        SpcgmxVo spcgmxVo=new SpcgmxVo();
        if(input!=null){
            spcgmxVo.setSpName(input);
        };
        if(selType!=""){
            spcgmxVo.setSpTypeName(selType);
        }
        AjaxResponse ajaxResponse =null;
        PageInfo<SpcgmxVo> list= this.documentShopService.flcx(spcgmxVo,currentPage,pageSize);
        return ajaxResponse.success(list);
    }
    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("selectPurch")
    public AjaxResponse selectcx(int currentPage, int pageSize){
        AjaxResponse ajaxResponse =null;
        PageInfo<SpcgmxVo> list= this.documentShopService.selectPurch(currentPage,pageSize);
        return ajaxResponse.success(list);
    }
   /* @GetMapping("selcetcghz")
    public AjaxResponse selectcx1(int currentPage, int pageSize){
        AjaxResponse ajaxResponse =null;
        PageInfo<CghzVo> list= this.purchaseGoodsService.selcetcghz(currentPage,pageSize);
        return ajaxResponse.success(list);
    }*/
    /**
     * 查询
     * @return
     */
    @GetMapping("selectfltj")
    public AjaxResponse selectcx2(){
        List<CgdjVo> list =this.documentShopService.selectfltj();
        System.out.println(list);
        return AjaxResponse.success(list);
    }


}