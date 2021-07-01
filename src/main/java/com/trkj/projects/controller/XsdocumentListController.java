package com.trkj.projects.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    //销售退货
    @Resource
    private XtdocumentShopService xtdocumentShopService;
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
        System.out.println("商品："+list2.toString());
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
        int xid = jsonObject.getInteger("xid");
        XsdocumentList xsdocumentList = JSON.parseObject(ss,XsdocumentList.class);
        System.out.println("退货信息："+xsdocumentList);

        this.xsdocumentListService.insert(xsdocumentList);

        List<XtdocumentShop> list = JSON.parseArray(bb,XtdocumentShop.class);
        System.out.println("商品信息："+list.toString());
//        this.xtdocumentShopService.plinsert(list);
        //循环获取销售商品id去修改状态
        for(int a=0;a<list.size();a++){
            this.xsdocumentShopService.uptshopstate(list.get(a).getId(),list.get(a).getDlNumber(),list.get(a).getYsDlNumber());
        }
        //如果退货状态为2（已审核）就直接改变库存数量
        if(xsdocumentList.getDlStatieId()==2){
            Stock stock = new Stock();
            for(int i=0;i<list.size();i++){
                stock.setSkShopid(list.get(i).getSpShopid());
                stock.setSkNumber(list.get(i).getNumber());
                stock.setSkLossnumber(list.get(i).getLossNumber());
                this.stockService.xsupdate2(stock);
            }
            //退货增加银行账户的余额
            Establishment establishment = new Establishment();
            establishment.setXid(xid);
            establishment.setOpening(xsdocumentList.getDlSsje());
            //银行余额减少实付金额
            this.establishmentService.updateestab(establishment);
            //退货减少客户的我方应收金额
            this.customerService.updatemoney2(xsdocumentList.getDlzonje(),xsdocumentList.getCustomerid());

        }
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
        XsdocumentList documentlistVo = JSONObject.parseObject(one, XsdocumentList.class);
        System.out.println(documentlistVo.getDlYsje()+",,,"+documentlistVo.getDlSsje());
        System.out.println(documentlistVo);
        System.out.println(xid);
        List<XsdocumentShop> listshop = JSONArray.parseArray(two, XsdocumentShop.class);
        if(documentlistVo.getDlTypeId()==1){
            this.xsdocumentListService.updatestaticzore(documentlistVo);
            Establishment establishment = new Establishment();
            establishment.setXid(xid);
            establishment.setOpening(documentlistVo.getDlSsje());
            //银行余额加入实付金额
            this.establishmentService.updateestabjia(establishment);
            //审核通过后将该单据中包含的商品从库存减库存量
            Stock stock=new Stock();
            for(int b=0;b<listshop.size();b++){
                stock.setSkShopid(listshop.get(b).getSpShopid());
                stock.setSkNumber(listshop.get(b).getNumber());
                stock.setSkLossnumber(listshop.get(b).getLossNumber());
                this.stockService.xsupdate(stock);
            }
            //获取销售商品里的客户和单价加到客户的我方应收里
            this.customerService.updatemoney2(documentlistVo.getDlzonje(),documentlistVo.getCustomerid());
            return AjaxResponse.success("销售审核通过！");
        }
        //退货审核操作
        if(documentlistVo.getDlTypeId()==2){
            this.xsdocumentListService.updatestaticzoret(documentlistVo);
            Establishment establishment = new Establishment();
            establishment.setXid(xid);
            establishment.setOpening(documentlistVo.getDlSsje());
            //银行余额减实付金额
            this.establishmentService.updateestab(establishment);
            //审核通过后将该单据中包含的商品从库存加库存量
            Stock stock=new Stock();
            for(int b=0;b<listshop.size();b++){
                stock.setSkShopid(listshop.get(b).getSpShopid());
                stock.setSkNumber(listshop.get(b).getNumber());
                stock.setSkLossnumber(listshop.get(b).getLossNumber());
                this.stockService.xsupdate2(stock);
            }
            //获取销售商品里的客户和单价减到客户的我方应收里
            this.customerService.updatemoney2(documentlistVo.getDlzonje(),documentlistVo.getCustomerid());
            return AjaxResponse.success("退货审核通过！");

        }
        return AjaxResponse.success("审核未通过！");
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
        System.out.println("应收："+documentlistVo.getDlYsje()+",,,实收："+documentlistVo.getDlSsje()+"...欠款："+documentlistVo.getDlQkje());
        System.out.println("单据信息："+documentlistVo);
        this.xsdocumentListService.insert(documentlistVo);
        //获取银行id去减银行账户余额
        System.out.println("银行id："+xid);
        Establishment establishment = new Establishment();
        establishment.setXid(xid);
        establishment.setOpening(documentlistVo.getDlSsje());
        //银行余额加去实付金额
        this.establishmentService.updateestabjia(establishment);
        //单据下的所有商品进行循环添加
        List<XsdocumentShop> listshop = JSONArray.parseArray(two, XsdocumentShop.class);
        System.out.println(listshop);
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

    /**
     * 往来账务查询单据已审核的销售单据
     * @param dlNumber
     * @param cid
     * @param wid
     * @param agentid
     * @param userid
     * @param branchid
     * @param date1
     * @param date2
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("findwlzw")
    public AjaxResponse findwlzw(Integer cid, Integer wid, Integer agentid, Integer userid, Integer branchid,Integer currentPage, Integer pageSize,String dlNumber, String date1, String date2){
        System.out.println("Integer"+ cid+"Integer"+ wid+"Integer" + agentid+"Integer"+ userid+ "Integer"+ branchid+"Integer"+ currentPage+" currentPage"+ pageSize+"String"+ dlNumber+ "String"+ date1+"String"+ date2);
        System.out.println("cid"+cid+"dlNumber："+dlNumber+date1);
        PageInfo<XsDocumentlistVo> info = xsdocumentListService.finxsdwlzw(dlNumber,cid,wid,agentid,userid,branchid,date1,date2,currentPage,pageSize);
        return AjaxResponse.success(info);
    }

    /**
     * 往来账务二次付款
     * @param two
     * @return
     */
    @PostMapping("updatetwolist")
    public AjaxResponse updatetwolist(@RequestBody String two){
        JSONObject jsonObject=JSONObject.parseObject(two);
        String aa = jsonObject.getString("two");
        Integer xid = jsonObject.getInteger("xid");
        XsdocumentList documentlistVo = JSONObject.parseObject(aa, XsdocumentList.class);
        System.out.println("二次提交单据："+documentlistVo);
        //计算实付金额将欠款金额归0
        XsdocumentList xsdocumentList = new XsdocumentList();
        xsdocumentList.setDlNumber(documentlistVo.getDlNumber());
        xsdocumentList.setDlSsje(documentlistVo.getDlSsje() + documentlistVo.getDlQkje());
        xsdocumentList.setDlQkje(0.0);
        this.xsdocumentListService.update(xsdocumentList);
        //二次付款成功后加入选择的银行账户中的余额
        Establishment establishment=new Establishment();
        establishment.setXid(xid);
        establishment.setOpening(documentlistVo.getDlQkje());
        this.establishmentService.update(establishment);
        //计算客户的我方应收金额
        this.customerService.updatemoney(documentlistVo.getDlQkje(),documentlistVo.getCustomerid());

        return AjaxResponse.success("二次付款成功");
    }


}
