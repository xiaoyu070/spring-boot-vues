package com.trkj.projects.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.trkj.projects.mybatis.entity.*;
import com.trkj.projects.service.*;
import com.trkj.projects.vo.AjaxResponse;
import com.trkj.projects.vo.DocumentlistVo;
import com.trkj.projects.vo.XsDocumentlistVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (XsdocumentList)表控制层
 *
 * @author makejava
 * @since 2021-06-10 16:21:32
 */
@RestController
@RequestMapping("xsdocumentList")
public class XsdocumentListController {
    /**
     * 服务对象
     */
    @Resource
    private XsdocumentListService xsdocumentListService;
    //库存
    @Resource
    private StockService stockService;
    //单据商品
    @Resource
    private XsdocumentShopService xsdocumentShopService;
    //银行
    @Resource
    private EstablishmentService establishmentService;
    @Resource
    private CustomerService customerService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public XsdocumentList selectOne(Integer id) {
        return this.xsdocumentListService.queryById(id);
    }
    //根据单据号删除商品
    @GetMapping("deletelistandshop")
    public AjaxResponse deletelistandshop(String number){
        System.out.println("number:"+number);
        this.xsdocumentListService.deleteById(number);
        this.xsdocumentShopService.deleteshoplist(number);
        return AjaxResponse.success("删除成功");
    }
    /**
     * 查询销售单据vo
     * @param DocumentlistVo
     * @return
     */
    @PostMapping("selectxsvo")
    public AjaxResponse selectxsvo(@RequestBody String DocumentlistVo){
        JSONObject jsonObject=JSONObject.parseObject(DocumentlistVo);
        String vo=jsonObject.getString("DocumentlistVo");
        String ttt = jsonObject.getString("text");
        //json转实体类对象
        XsDocumentlistVo documentlistVo= JSON.parseObject(vo, XsDocumentlistVo.class);
        int currenPage = jsonObject.getInteger("currenPage");
        int pageSize = jsonObject.getInteger("pageSize");
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<XsDocumentlistVo> list = this.xsdocumentListService.selectxsvo(documentlistVo);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    /**
     * 模糊销售查询单据
     * @param a
     * @return
     */
    @PostMapping("xslikevo")
    public AjaxResponse xslikevo(@RequestBody String a){
        JSONObject jsonObject=JSONObject.parseObject(a);
        int currenPage = jsonObject.getInteger("currenPage");
        int pageSize = jsonObject.getInteger("pageSize");
        String texts = jsonObject.getString("text");
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<XsDocumentlistVo> list = this.xsdocumentListService.xslikevo(texts);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    /**
     * 根据时间段查询销售单据
     * @param a
     * @return
     */
    @PostMapping("xsselectdates")
    public AjaxResponse xsselectdates(@RequestBody String a){
        JSONObject jsonObject=JSONObject.parseObject(a);
        int currenPage = jsonObject.getInteger("currenPage");
        int pageSize = jsonObject.getInteger("pageSize");
        String data1 = jsonObject.getString("data1");
        String data2 = jsonObject.getString("data2");
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<XsDocumentlistVo> list = this.xsdocumentListService.xsselectdate(data1,data2);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    /**
     * KK:添加到单据表和单据详情表
     * @param www
     * @param i
     * @return
     */
    @PostMapping("adddocument/{i}")
    public AjaxResponse adddocument(@RequestBody String www,@PathVariable("i") int i){
        JSONObject jsonObject = JSONObject.parseObject(www);
        String ww = jsonObject.getString("sss");
        XsdocumentList list = JSON.parseObject(ww,XsdocumentList.class);

        System.out.println(list);
        this.xsdocumentListService.insert(list);
        String ss = jsonObject.getString("list");
        List<XsdocumentShop> list2 = JSON.parseArray(ss,XsdocumentShop.class);
        System.out.println(list2.toString());
        if(i == 1){
            Stock stock = new Stock();
            for (int a=0;a<list2.size();a++){
                stock.setSkShopid(list2.get(a).getSpShopid());
                stock.setSkNumber(list2.get(a).getNumber());
                stock.setSkLossnumber(list2.get(a).getLossNumber());
                this.stockService.xsupdate(stock);
            }
        }
        this.xsdocumentShopService.insertBatch(list2);

        return AjaxResponse.success("销售成功");
    }

    /**
     * 添加退货销售单据和商品
     * @param
     * @return
     */
    @PostMapping("addxtdocument")
    public AjaxResponse addxtdocument(@RequestBody String aa){
        JSONObject jsonObject = JSONObject.parseObject(aa);
        String ss = jsonObject.getString("aa");
        String bb = jsonObject.getString("list");
        XsdocumentList xsdocumentList = JSON.parseObject(ss,XsdocumentList.class);
        System.out.println("退货信息："+xsdocumentList);
        //this.xsdocumentListService.insert(xsdocumentList);

        List<XtdocumentShop> list = JSON.parseArray(bb,XtdocumentShop.class);
        System.out.println("商品信息："+list.toString());
        //this.xtdocumentShopService.plinsert(list);
        //循环获取销售商品id去修改状态
//        for(int a=0;a<list.size();a++){
//            this.documentShopService.uptshopstate(list.get(a).getId());
//        }

        return AjaxResponse.success("退货成功");

    }

    //审核确认
    @PostMapping("shenheqr")
    public AjaxResponse shenheqr(@RequestBody String a){
        JSONObject jsonObject=JSONObject.parseObject(a);
        System.out.println("aaaaa:"+jsonObject);
        String one = jsonObject.getString("ttt");
        int xid = jsonObject.getInteger("xid");
        String two = jsonObject.getString("list");
        XsDocumentlistVo documentlistVo = JSONObject.parseObject(one, XsDocumentlistVo.class);
        System.out.println(documentlistVo.getDlysje()+",,,"+documentlistVo.getDlssje());
        System.out.println(documentlistVo);
        System.out.println(xid);
        Establishment establishment = new Establishment();
        establishment.setXid(xid);
        establishment.setOpening(documentlistVo.getDlssje());
        //银行余额减去实付金额
        this.establishmentService.updateestab(establishment);
        List<DocumentShop> listshop = JSONArray.parseArray(two, DocumentShop.class);

        //审核通过后将该单据中包含的商品从库存减库存量
        Stock stock=new Stock();
        for(int b=0;b<listshop.size();b++){
            stock.setSkShopid(listshop.get(b).getSpShopid());
            stock.setSkNumber(listshop.get(b).getNumber());
            stock.setSkLossnumber(listshop.get(b).getLossNumber());
            this.stockService.xsupdate(stock);
        }
        double x = documentlistVo.getDlysje() - documentlistVo.getDlssje();

        //获取销售商品里的客户和单价加到客户的我方应收里
        for (int i =0;i<listshop.size();i++){
            this.customerService.updatemoney(listshop.get(i).getSpJprice(),listshop.get(i).getCustomerid());
        }
        XsdocumentList documentList = new XsdocumentList();
        documentList.setDlNumber(documentlistVo.getDlNumber());
        documentList.setDlQkje(x);
        documentList.setDlzonje(documentlistVo.getDlzonje());
        documentList.setDlYhje(documentlistVo.getDlyhje());
        documentList.setDlYsje(documentlistVo.getDlysje());
        documentList.setDlSsje(documentlistVo.getDlssje());
        System.out.println("单据信息："+documentList.toString());
        this.xsdocumentListService.updatestaticzore(documentList);
        return AjaxResponse.success("审核通过！");
    }
    //销售审核确认
    @PostMapping("xsshenheqr")
    public AjaxResponse xsshenheqr(@RequestBody String a){
        JSONObject jsonObject=JSONObject.parseObject(a);
        System.out.println("aaaaa:"+jsonObject);
        String one = jsonObject.getString("ttt");
        int xid = jsonObject.getInteger("xid");
        String two = jsonObject.getString("list");
        XsdocumentList documentlistVo = JSONObject.parseObject(one, XsdocumentList.class);
        System.out.println("应收："+documentlistVo.getDlYsje()+",,,实收："+documentlistVo.getDlSsje());
        System.out.println("单据信息："+documentlistVo);
        this.xsdocumentListService.insert(documentlistVo);
        //获取银行id去减银行账户余额
        System.out.println("银行id："+xid);
        Establishment establishment = new Establishment();
        establishment.setXid(xid);
        establishment.setOpening(documentlistVo.getDlSsje());
        //银行余额减去实付金额
        this.establishmentService.updateestab(establishment);
        //单据下的所有商品进行循环添加
        List<XsdocumentShop> listshop = JSONArray.parseArray(two, XsdocumentShop.class);
        this.xsdocumentShopService.insertBatch(listshop);
        //审核通过后将该单据中包含的商品从库存减库存量
        Stock stock=new Stock();
        for(int b=0;b<listshop.size();b++){
            stock.setSkShopid(listshop.get(b).getSpShopid());
            stock.setSkNumber(listshop.get(b).getNumber());
            stock.setSkLossnumber(listshop.get(b).getLossNumber());
            this.stockService.xsupdate(stock);
        }
        //获取销售商品里的客户和单价加到客户的我方应收里
        this.customerService.updatemoney(documentlistVo.getDlzonje(),documentlistVo.getCustomerid());
        return AjaxResponse.success("审核通过！");
    }


}
