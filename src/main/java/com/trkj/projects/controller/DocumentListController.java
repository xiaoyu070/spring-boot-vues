package com.trkj.projects.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.DocumentList;
import com.trkj.projects.mybatis.entity.DocumentShop;
import com.trkj.projects.mybatis.entity.Establishment;
import com.trkj.projects.mybatis.entity.Stock;
import com.trkj.projects.service.DocumentListService;
import com.trkj.projects.service.DocumentShopService;
import com.trkj.projects.service.EstablishmentService;
import com.trkj.projects.service.StockService;
import com.trkj.projects.vo.AjaxResponse;
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
    @PostMapping("selectvo")
    public AjaxResponse selectvo(@RequestBody String DocumentlistVo){
        JSONObject jsonObject=JSONObject.parseObject(DocumentlistVo);
        String vo=jsonObject.getString("DocumentlistVo");
        String ttt = jsonObject.getString("text");
        //json转实体类对象
        com.trkj.projects.vo.DocumentlistVo documentlistVo=JSON.parseObject(vo, com.trkj.projects.vo.DocumentlistVo.class);
        int currenPage = jsonObject.getInteger("currenPage");
        int pageSize = jsonObject.getInteger("pageSize");
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<com.trkj.projects.vo.DocumentlistVo> list = this.documentListService.selectvo(documentlistVo);
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
        //根据时间查询采购审核单中状态为待审核的单据
        @PostMapping("shenhedates")
        public AjaxResponse shenhedates(@RequestBody String b){
            JSONObject jsonObject=JSONObject.parseObject(b);
            System.out.println("jsonObject"+jsonObject);
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
        //审核确认
        @PostMapping("shenheqr")
        public AjaxResponse shenheqr(@RequestBody String a){
            JSONObject jsonObject=JSONObject.parseObject(a);
            String one = jsonObject.getString("ttt");
            int xid = jsonObject.getInteger("xid");
            String two = jsonObject.getString("list");
            DocumentlistVo documentlistVo = JSONObject.parseObject(one, DocumentlistVo.class);
            System.out.println(documentlistVo);
            System.out.println(xid);
            Establishment establishment = new Establishment();
            establishment.setXid(xid);
            establishment.setOpening(documentlistVo.getDlsfje());
            List<DocumentShop> listshop = JSONArray.parseArray(two, DocumentShop.class);
            //审核通过后将该单据中包含的商品添加到库存中
            Stock stock=new Stock();
            for(int b=0;b<listshop.size();b++){
                stock.setSkShopid(listshop.get(b).getSpShopid());
                stock.setSkNumber(listshop.get(b).getNumber());
                stock.setSkLossnumber(listshop.get(b).getLossNumber());
                this.stockService.update(stock);
            }
            //银行余额减去实付金额
            this.establishmentService.updateestab(establishment);
            //应付金额减去实付金额得到欠款金额
            double x = documentlistVo.getDlyfje() - documentlistVo.getDlsfje();
            DocumentList documentList = new DocumentList();
            documentList.setDlNumber(documentlistVo.getDlNumber());
            documentList.setDlQkje(x);
            documentList.setDlYfje(documentlistVo.getDlyfje());
            documentList.setDlSfje(documentlistVo.getDlsfje());
            this.documentListService.updatestaticzore(documentList);
            return AjaxResponse.success("审核通过！");
        }
        //新增已审核单据
        @PostMapping("insertshenhedj")
        public AjaxResponse insertshenhedj(@RequestBody String a){
            //得到json对象
            JSONObject jsonObject=JSONObject.parseObject(a);
            System.out.println("json::"+jsonObject);
            //根据json中的key拿到ttt对象
            String one = jsonObject.getString("ttt");
            //根据json中的key拿到xid对象
            int xid = jsonObject.getInteger("xid");
            //根据json中的key拿到list对象
            String two = jsonObject.getString("list");
            //将json对象one转换成实体类
            DocumentList documentlist = JSONObject.parseObject(one, DocumentList.class);
            System.out.println("documentlist::"+documentlist.getDlNumber());
            System.out.println(xid);
            //new出银行
            Establishment establishment = new Establishment();
            //将银行id传入
            establishment.setXid(xid);
            //将实付金额传入
            establishment.setOpening(documentlist.getDlSfje());
            System.out.println("establishment:"+establishment.getOpening()+"xid:"+establishment.getXid());
            //银行余额减去实付金额
            this.establishmentService.updateestab(establishment);
            //将json对象two转换成list集合
            List<DocumentShop> listshop = JSONArray.parseArray(two, DocumentShop.class);
            for(int xx=0;xx<listshop.size();xx++){
                System.out.println("listshop:"+listshop.get(xx).getDlNumber());
            }
            //将库存new出来根据商品id增加商品库存
                Stock stock=new Stock();
                for(int b=0;b<listshop.size();b++){
                    stock.setSkShopid(listshop.get(b).getSpShopid());
                    stock.setSkNumber(listshop.get(b).getNumber());
                    stock.setSkLossnumber(listshop.get(b).getLossNumber());
                    this.stockService.update(stock);
                }
            //将list集合中的商品添加到单据商品表中
            this.documentShopService.insertBatch(listshop);

            //应付金额减去实付金额得到欠款金额
            double x = documentlist.getDlYfje() - documentlist.getDlSfje();
            documentlist.setDlDate(new Date());
            documentlist.setDlQkje(x);
            //新增一个已审核状态的单据
            this.documentListService.insert(documentlist);
            return AjaxResponse.success("新增已审核单成功！");
        }
        @PostMapping("selectwlzw")
        public AjaxResponse selectwlzw(@RequestBody String a){
            JSONObject jsonObject=JSONObject.parseObject(a);
            int currenPage = jsonObject.getInteger("currenPage");
            int pageSize = jsonObject.getInteger("pageSize");
            Map<String,Object> map=new HashMap<>();
            Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
            List<DocumentlistVo> list = this.documentListService.selectwlzw();
            map.put("total",pg.getTotal());
            map.put("rows",list);
            return AjaxResponse.success(map);
        }

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


    @GetMapping("cgdj")
    public AjaxResponse selectcx(int currentPage, int pageSize){
        AjaxResponse ajaxResponse =null;
        PageInfo<SpcgmxVo> list= this.documentListService.cgdj(currentPage,pageSize);
        return ajaxResponse.success(list);
    }

}