package com.trkj.projects.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.anntation.Log;
import com.trkj.projects.mybatis.entity.*;
import com.trkj.projects.service.DocumentListService;
import com.trkj.projects.service.DocumentShopService;
import com.trkj.projects.service.EstablishmentService;
import com.trkj.projects.service.StockService;
import com.trkj.projects.vo.*;
import com.trkj.projects.service.*;
import com.trkj.projects.vo.AjaxResponse;
import com.trkj.projects.vo.CgdjVo;
import com.trkj.projects.vo.DocumentlistVo;
import com.trkj.projects.vo.SpcgmxVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (DocumentList)表控制层
 *
 * @author makejava
 * @since 2021-06-03 22:08:18
 */
@RestController
@RequestMapping("documentList")
public class DocumentListController {
    /**
     * 服务对象
     */
    //单据表
    @Resource
    private DocumentListService documentListService;
    //单据商品
    @Resource
    private DocumentShopService documentShopService;
    //库存
    @Resource
    private StockService stockService;
    //银行
    @Resource
    private EstablishmentService establishmentService;
    //新增单据、入库修改
    //供货商
    @Resource
    private SupplierService supplierService;

    //新增单据、入库修改
    @PostMapping("addDocumentList")
    public AjaxResponse addDocumentList(@RequestBody String www){
        JSONObject jsonObject=JSONObject.parseObject(www);
        String one = jsonObject.getString("sss");
        //json转实体类对象
        DocumentList list = JSON.parseObject(one, DocumentList.class);
        list.setDlDate(new Date());
        //添加到订单中
        this.documentListService.insert(list);
        String two = jsonObject.getString("list");
        //json转list集合对象
        List<DocumentShop> listshop = JSONArray.parseArray(two, DocumentShop.class);
        this.documentShopService.insertBatch(listshop);
        return AjaxResponse.success("新增审核单成功！");
    }
    /**
     * 查询vo
     * @param DocumentlistVo
     * @return
     */
    @Log("查询单据vo")
    @PostMapping("selectvo")
    public AjaxResponse selectvo(@RequestBody String DocumentlistVo){
        JSONObject jsonObject=JSONObject.parseObject(DocumentlistVo);
        String vo=jsonObject.getString("DocumentlistVo");
        String ttt = jsonObject.getString("text");
        //json转实体类对象
        DocumentlistVo documentlistVo=JSON.parseObject(vo,DocumentlistVo.class);
        int currenPage = jsonObject.getInteger("currenPage");
        int pageSize = jsonObject.getInteger("pageSize");
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<DocumentlistVo> list = this.documentListService.selectvo(documentlistVo);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
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
        com.trkj.projects.vo.DocumentlistVo documentlistVo=JSON.parseObject(vo, com.trkj.projects.vo.DocumentlistVo.class);
        int currenPage = jsonObject.getInteger("currenPage");
        int pageSize = jsonObject.getInteger("pageSize");
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<com.trkj.projects.vo.DocumentlistVo> list = this.documentListService.selectxsvo(documentlistVo);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }

    /**
     * 模糊查询单据
     * @param a
     * @return
     */
        @PostMapping("likevo")
        public AjaxResponse likevo(@RequestBody String a){
            JSONObject jsonObject=JSONObject.parseObject(a);
            int currenPage = jsonObject.getInteger("currenPage");
            int pageSize = jsonObject.getInteger("pageSize");
            String texts = jsonObject.getString("text");
            Map<String,Object> map=new HashMap<>();
            Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
            List<DocumentlistVo> list = this.documentListService.likevo(texts);
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
        List<DocumentlistVo> list = this.documentListService.xslikevo(texts);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
        //根据时间查询采购审核单中状态为待审核的单据
        @PostMapping("shenhedates")
        public AjaxResponse shenhedates(@RequestBody String b){
            JSONObject jsonObject=JSONObject.parseObject(b);
            int currenPage = jsonObject.getInteger("currenPage");
            int pageSize = jsonObject.getInteger("pageSize");
            String data1 = jsonObject.getString("data1");
            String data2 = jsonObject.getString("data2");
            Map<String,Object> map=new HashMap<>();
            Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
            List<DocumentlistVo> list = this.documentListService.selectdatesdanju(data1,data2);
            map.put("total",pg.getTotal());
            map.put("rows",list);
            return AjaxResponse.success(map);
        }
    //根据时间查询销售审核单中状态为待审核的单据
    @PostMapping("xsshenhedates")
    public AjaxResponse xsshenhedates(@RequestBody String b){
        JSONObject jsonObject=JSONObject.parseObject(b);
        int currenPage = jsonObject.getInteger("currenPage");
        int pageSize = jsonObject.getInteger("pageSize");
        String data1 = jsonObject.getString("data1");
        String data2 = jsonObject.getString("data2");
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<DocumentlistVo> list = this.documentListService.xsselectdatesdanju(data1,data2);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
        //审核确认
        @PostMapping("shenheqr")
        public AjaxResponse shenheqr(@RequestBody String a){
            JSONObject jsonObject=JSONObject.parseObject(a);
            String one = jsonObject.getString("ttt");
            //银行id
            int xid = jsonObject.getInteger("xid");
            String two = jsonObject.getString("list");
            DocumentlistVo documentlistVo = JSONObject.parseObject(one, DocumentlistVo.class);
            List<DocumentShop> listshop = JSONArray.parseArray(two, DocumentShop.class);
            //将库存new出来根据商品id增加商品库存
            Establishment establishment = new Establishment();
            establishment.setXid(xid);
            establishment.setOpening(documentlistVo.getDlsfje());

            DocumentList documentList = new DocumentList();

            //审核通过后将该单据中包含的商品添加到库存中
            Stock stock=new Stock();
            String mess = "";
            if(documentlistVo.getDltypeid() == 0){
                //银行余额减去实付金额
                this.establishmentService.updateestab(establishment);
                //将采购审核通过的商品的价格和对应的供应商一一拿出来，增加供货商的初期余额
                for(int x=0;x<listshop.size();x++){
                    this.supplierService.numbersmoney(listshop.get(x).getZje(), listshop.get(x).getSupperlierid());
                }
                //审核通过后将该单据中包含的商品添加到库存中
                for(int b=0;b<listshop.size();b++){
                    //单据通过审核后商品入库之前先查询该店面该仓库是否存在该商品
                    Stock selectstock=new Stock();
                    selectstock.setSpWarehouseId(listshop.get(b).getWid());
                    selectstock.setSpStorefrontId(listshop.get(b).getBranchid());
                    selectstock.setSkShopid(listshop.get(b).getSpShopid());
                    List<Stock> stockList = this.stockService.findbybranchidandshopidandwid(selectstock);
                    //如果该仓库查到有商品则库存数量增加，如果该仓库没有商品则新增该商品
                    if(stockList.size()>0){
                        stock.setSkShopid(listshop.get(b).getSpShopid());
                        stock.setSkNumber(listshop.get(b).getNumber());
                        stock.setSkLossnumber(listshop.get(b).getLossNumber());
                        stock.setSpWarehouseId(listshop.get(b).getWid());
                        this.stockService.update(stock);
                    }else{
                        Stock stocks=new Stock();
                        stocks.setSkShopid(listshop.get(b).getSpShopid());
                        stocks.setSpStorefrontId(listshop.get(b).getBranchid());
                        stocks.setSpWarehouseId(listshop.get(b).getWid());
                        stocks.setSkLossnumber(listshop.get(b).getLossNumber());
                        stocks.setSkNumber(listshop.get(b).getNumber());
                        stocks.setSpNumber(0);
                        this.stockService.insert(stocks);
                    }
                }
                //应付金额减去实付金额得到欠款金额
                double x = documentlistVo.getDlyfje() - documentlistVo.getDlsfje();
                documentList.setDlNumber(documentlistVo.getDlNumber());
                documentList.setDlQkje(x);
                documentList.setDlYfje(documentlistVo.getDlyfje());
                documentList.setDlSfje(documentlistVo.getDlsfje());
                this.documentListService.updatestaticzore(documentList);
                mess = "采购审核通过！";
            }else{
                //将采购审核通过的商品的价格和对应的供应商一一拿出来，增加供货商的初期余额
                for(int x=0;x<listshop.size();x++){
                    this.supplierService.numbersmoneyjian(listshop.get(x).getZje(), listshop.get(x).getSupperlierid());
                }
                //根据退货的商品减少相应商品的库存量
                for(int b=0;b<listshop.size();b++){
                    stock.setSkShopid(listshop.get(b).getSpShopid());
                    stock.setSkNumber(listshop.get(b).getNumber());
                    stock.setSkLossnumber(listshop.get(b).getLossNumber());
                    stock.setSpWarehouseId(listshop.get(b).getWid());
                    this.stockService.updatedelete(stock);
                }
                //银行余额加上供货商的实付金额（退货）
                this.establishmentService.updateestabjia(establishment);

                documentList.setDlQkje(0.0);
                documentList.setDlNumber(documentlistVo.getDlNumber());
                documentList.setDlYfje(documentlistVo.getDlyfje());
                documentList.setDlSfje(documentlistVo.getDlsfje());
                this.documentListService.updatestatictwo(documentList);
                mess = "退货审核通过！";
            }
            return AjaxResponse.success(mess);
        }
        @PostMapping("wlzwecfkqr")
        public AjaxResponse wlzwecfkqr(@RequestBody String a){
            JSONObject jsonObject=JSONObject.parseObject(a);
            int xid = jsonObject.getInteger("xid");
            String one = jsonObject.getString("dx");
            DocumentlistVo documentlistVo = JSONObject.parseObject(one, DocumentlistVo.class);
            //new出单据实体类，根据单据号修改实付金额，清空欠款金额。
            DocumentList updateecfk=new DocumentList();
            updateecfk.setDlQkje(0.0);
            updateecfk.setDlSfje(documentlistVo.getDlsfje()+documentlistVo.getDlqkje());
            updateecfk.setDlNumber(documentlistVo.getDlNumber());
            this.documentListService.update(updateecfk);
            //二次付款成功后扣除选择的银行账户中的余额
            Establishment establishment=new Establishment();
            establishment.setXid(xid);
            establishment.setOpening(documentlistVo.getDlqkje());
            this.establishmentService.updateestab(establishment);
            //对应供货商的初期余额增加
            this.supplierService.numbersmoney(documentlistVo.getDlqkje(),documentlistVo.getSupplierid());
            return AjaxResponse.success("二次付款成功！");
        }
        //新增已审核单据
        @PostMapping("insertshenhedj")
        public AjaxResponse insertshenhedj(@RequestBody String a){
            //得到json对象
            JSONObject jsonObject=JSONObject.parseObject(a);
            //根据json中的key拿到ttt对象
            String one = jsonObject.getString("ttt");
            //根据json中的key拿到xid对象
            int xid = jsonObject.getInteger("xid");
            //根据json中的key拿到list对象
            String two = jsonObject.getString("list");
            //将json对象one转换成实体类
            DocumentList documentlist = JSONObject.parseObject(one, DocumentList.class);

            //new出银行
            Establishment establishment = new Establishment();
            //将银行id传入
            establishment.setXid(xid);
            //将实付金额传入
            establishment.setOpening(documentlist.getDlSfje());
            //将json对象two转换成list集合
            List<DocumentShop> listshop = JSONArray.parseArray(two, DocumentShop.class);
            //return的消息
            String messus = "";
            if(documentlist.getDlTypeId() == 0){
                //银行余额减去实付金额
                this.establishmentService.updateestab(establishment);
                //将库存new出来根据商品id和仓库增加商品库存
                Stock stock=new Stock();
                //审核通过后将该单据中包含的商品添加到库存中
                for(int b=0;b<listshop.size();b++){
                    //单据通过审核后商品入库之前先查询该店面该仓库是否存在该商品
                    Stock selectstock=new Stock();
                    selectstock.setSpWarehouseId(listshop.get(b).getWid());
                    selectstock.setSpStorefrontId(listshop.get(b).getBranchid());
                    selectstock.setSkShopid(listshop.get(b).getSpShopid());
                    List<Stock> stockList = this.stockService.findbybranchidandshopidandwid(selectstock);
                    //如果该仓库查到有商品则库存数量增加，如果该仓库没有商品则新增该商品
                    if(stockList.size()>0){
                        stock.setSkShopid(listshop.get(b).getSpShopid());
                        stock.setSkNumber(listshop.get(b).getNumber());
                        stock.setSkLossnumber(listshop.get(b).getLossNumber());
                        stock.setSpWarehouseId(listshop.get(b).getWid());
                        this.stockService.update(stock);
                    }else{
                        Stock stocks=new Stock();
                        stocks.setSkShopid(listshop.get(b).getSpShopid());
                        stocks.setSpStorefrontId(listshop.get(b).getBranchid());
                        stocks.setSpWarehouseId(listshop.get(b).getWid());
                        stocks.setSkLossnumber(listshop.get(b).getLossNumber());
                        stocks.setSkNumber(listshop.get(b).getNumber());
                        stocks.setSpNumber(0);
                        this.stockService.insert(stocks);
                    }
                }
                //应付金额减去实付金额得到欠款金额
                double x = documentlist.getDlYfje() - documentlist.getDlSfje();
                documentlist.setDlDate(new Date());
                documentlist.setDlQkje(x);
                for(int z=0;z<listshop.size();z++){
                    this.supplierService.numbersmoney(listshop.get(z).getZje(), listshop.get(z).getSupperlierid());
                }
                messus = "新增采购已审核单成功！";
            }else{
                //银行余额加上供货商的实付金额（退货）
                this.establishmentService.updateestabjia(establishment);
                //将库存new出来根据商品id和仓库减少商品库存
                Stock stock=new Stock();
                for(int b=0;b<listshop.size();b++){
                    stock.setSkShopid(listshop.get(b).getSpShopid());
                    stock.setSkNumber(listshop.get(b).getNumber());
                    stock.setSkLossnumber(listshop.get(b).getLossNumber());
                    stock.setSpWarehouseId(listshop.get(b).getWid());
                    this.stockService.updatedelete(stock);
                }
                documentlist.setDlDate(new Date());
                documentlist.setDlQkje(0.0);
                for(int z=0;z<listshop.size();z++){
                    this.supplierService.numbersmoneyjian(listshop.get(z).getZje(), listshop.get(z).getSupperlierid());
                }
                messus = "新增退货已审核单成功！";
            }
            //新增一个已审核状态的单据
            this.documentListService.insert(documentlist);
            //将list集合中的商品添加到单据商品表中
            this.documentShopService.insertBatch(listshop);
            return AjaxResponse.success(messus);
        }
        //查询往来账务（采购已审核和退货已审核）
        @PostMapping("selectwlzw")
        public AjaxResponse selectwlzw(@RequestBody String a){
            JSONObject jsonObject=JSONObject.parseObject(a);
            int currenPage = jsonObject.getInteger("currenPage");
            int pageSize = jsonObject.getInteger("pageSize");
            String vo=jsonObject.getString("DocumentlistVo");
            DocumentlistVo documentlistVo=JSON.parseObject(vo,DocumentlistVo.class);
            Map<String,Object> map=new HashMap<>();
            Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
            List<DocumentlistVo> list = this.documentListService.selectwlzw(documentlistVo);
            map.put("total",pg.getTotal());
            map.put("rows",list);
            return AjaxResponse.success(map);
        }
        //查询往来账务（采购已审核和退货已审核）
        @PostMapping("selectwlzwlike")
        public AjaxResponse selectwlzwlike(@RequestBody String txt){
            JSONObject jsonObject=JSONObject.parseObject(txt);
            int currenPage = jsonObject.getInteger("currenPage");
            int pageSize = jsonObject.getInteger("pageSize");
            String vo=jsonObject.getString("txt");
            Map<String,Object> map=new HashMap<>();
            Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
            List<DocumentlistVo> list = this.documentListService.selectwlzwlike(vo);
            map.put("total",pg.getTotal());
            map.put("rows",list);
            return AjaxResponse.success(map);
        }
        //查询所选的俩个时间之内的数据
        @PostMapping("selectdates")
        public AjaxResponse selectdates(@RequestBody String a){
            JSONObject jsonObject=JSONObject.parseObject(a);
            int currenPage = jsonObject.getInteger("currenPage");
            int pageSize = jsonObject.getInteger("pageSize");
            String data1 = jsonObject.getString("data1");
            String data2 = jsonObject.getString("data2");
            Map<String,Object> map=new HashMap<>();
            Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
            List<DocumentlistVo> list = this.documentListService.selectdate(data1,data2);
            map.put("total",pg.getTotal());
            map.put("rows",list);
            return AjaxResponse.success(map);
        }
        //根据单据号删除单据和商品
        @GetMapping("deletelistandshop")
        public AjaxResponse deletelistandshop(String number){
            this.documentListService.deleteById(number);
            this.documentShopService.deleteshoplist(number);
            return AjaxResponse.success("删除成功！");
        }

    //小宇子的
    @GetMapping("cgdj")
    public AjaxResponse selectcx(int currentPage, int pageSize){
        AjaxResponse ajaxResponse =null;
        PageInfo<SpcgmxVo> list= this.documentListService.cgdj(currentPage,pageSize);
        return ajaxResponse.success(list);
    }
    @GetMapping("cghz")
    public AjaxResponse selectcx2(int currentPage, int pageSize){
        AjaxResponse ajaxResponse =null;
        PageInfo<CghzVo> list= this.documentListService.cghz(currentPage,pageSize);
        return ajaxResponse.success(list);
    }
    @GetMapping("fltj")
    public AjaxResponse selectcx23(int currentPage, int pageSize){
        AjaxResponse ajaxResponse =null;
        PageInfo<CghzVo> list= this.documentListService.fltj(currentPage,pageSize);
        return ajaxResponse.success(list);
    }
    @GetMapping("djxq")
    public AjaxResponse selectc1(int currentPage, int pageSize){
        AjaxResponse ajaxResponse =null;
        PageInfo<SpcgmxVo> list= this.documentListService.djxq(currentPage,pageSize);
        return ajaxResponse.success(list);
    }
    @GetMapping("spmx")
    public AjaxResponse selectc2(int currentPage, int pageSize){
        AjaxResponse ajaxResponse =null;
        PageInfo<SpcgmxVo> list= this.documentListService.spmx(currentPage,pageSize);
        return ajaxResponse.success(list);
    }
    @GetMapping("ssdj")
    public AjaxResponse selectc3(int currentPage, int pageSize){
        AjaxResponse ajaxResponse =null;
        PageInfo<SpxsmxVo> list= this.documentListService.ssdj(currentPage,pageSize);
        return ajaxResponse.success(list);
    }
    @GetMapping("ywymc")
    public AjaxResponse selectcx1(){
        List<SpcgmxVo> list =this.documentListService.ywymc();
        return AjaxResponse.success(list);
    }
    @GetMapping("ywymc1")
    public AjaxResponse selectcx4(){
        List<SpxsmxVo> list =this.documentListService.ywymc1();
        return AjaxResponse.success(list);
    }
    @GetMapping("ywycx")
    public AjaxResponse selectcx2(String agentName1, int currentPage, int pageSize) {
        SpcgmxVo spcgmxVo=new SpcgmxVo();
        spcgmxVo.setAgentName(agentName1);
        PageInfo<SpcgmxVo> list= this.documentListService.ywycx(spcgmxVo,currentPage,pageSize);
        return AjaxResponse.success(list);
    }
    @GetMapping("ssdjcx")
    public AjaxResponse selectcx3(String agent,String WName1, String dlType, int currentPage, int pageSize) {
        SpxsmxVo spxsmxVo=new SpxsmxVo();
        if(agent!=""){
            spxsmxVo.setAgentName(agent);
        };
        if(WName1!=""){
            spxsmxVo.setWName(WName1);
        }
        if(dlType!=""){
            spxsmxVo.setDlTypeName(dlType);
        }
        PageInfo<SpxsmxVo> list= this.documentListService.ssdjcx(spxsmxVo,currentPage,pageSize);
        return AjaxResponse.success(list);
    }
    @GetMapping("fdcx")
    public AjaxResponse selectcx2(){
        List<SpxsmxVo> list =this.documentListService.fdcx();
        return AjaxResponse.success(list);
    }
    @GetMapping("djlx")
    public AjaxResponse selectcx3(){
        List<SpxsmxVo> list =this.documentListService.djlx();
        return AjaxResponse.success(list);
    }
    //根据时间查询采购审核单中状态为待审核的单据
    @PostMapping("sjcx")
    public AjaxResponse sjcx(@RequestBody String b){
        JSONObject jsonObject=JSONObject.parseObject(b);
        int currenPage = jsonObject.getInteger("currentPage");
        int pageSize = jsonObject.getInteger("pageSize");
        String data1 = jsonObject.getString("data1");
        String data2 = jsonObject.getString("data2");
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<SpcgmxVo> list = this.documentListService.sjcx(data1,data2);
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
        DocumentList list = JSON.parseObject(ww,DocumentList.class);

        this.documentListService.insert(list);
        String ss = jsonObject.getString("list");
        List<DocumentShop> list2 = JSON.parseArray(ss,DocumentShop.class);
        if(i == 2){
            Stock stock = new Stock();
            for (int a=0;a<list2.size();a++){
                stock.setSkShopid(list2.get(a).getSpShopid());
                stock.setSkNumber(list2.get(a).getNumber());
                stock.setSkLossnumber(list2.get(a).getLossNumber());
                this.stockService.update(stock);
            }
        }
        this.documentShopService.insertBatch(list2);

        return AjaxResponse.success("销售成功");
    }

    /**
     * kk:多条件查询销售审核单
     * @param branchid
     * @param customerid
     * @param userid
     * @param gjz
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("findallbytj")
    public AjaxResponse findalltj(String qq,String zh,int branchid, int customerid, int userid, String gjz, int currentPage, int pageSize){
        PageInfo<DocumentlistVo> info = documentListService.findallbyfdandkhanduserandgjz(qq,zh,branchid,customerid,userid,gjz,currentPage,pageSize);
        return AjaxResponse.success(info);
    }

}