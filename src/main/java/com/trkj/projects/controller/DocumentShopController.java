package com.trkj.projects.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.DocumentList;
import com.trkj.projects.mybatis.entity.DocumentShop;
import com.trkj.projects.mybatis.entity.XsdocumentList;
import com.trkj.projects.service.DocumentListService;
import com.trkj.projects.service.DocumentShopService;
import com.trkj.projects.service.XsdocumentListService;
import com.trkj.projects.vo.*;
import org.springframework.web.bind.annotation.*;
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
     * @param currenPage
     * @param pageSize
     * @param number
     * @param wid
     * @param branchid
     * @return
     */
    @GetMapping("selectnumber")
    public AjaxResponse selectnumber(Integer currenPage,Integer pageSize,String number,int wid,int branchid){
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<DocumentShopVo> list= this.documentShopService.selectnumber(number,wid,branchid);
        System.out.println("selectnumber:list:"+list);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }

    @GetMapping("selectstatezreonumber")
    public AjaxResponse selectstatezreonumber(Integer currenPage,Integer pageSize,String number,int wid){
        System.out.println("审核查询！！！");
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<DocumentShopVo> list= this.documentShopService.selectstatezreonumber(number,wid);
        System.out.println("selectnumber:list:"+list);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    @PostMapping("deleteshopall")
    public AjaxResponse deleteshopall(@RequestBody String a){
        JSONObject jsonObject=JSONObject.parseObject(a);
        String shops = jsonObject.getString("tabshop");
        List<DocumentShopVo> list=JSONObject.parseArray(shops,DocumentShopVo.class);
        System.out.println("deleteshopalllist:"+list);
        boolean tt = true;
        //循环删除选中的单据商品
        for (int i=0;i<list.size();i++){
            tt = this.documentShopService.deleteById(list.get(i).getId());
        }
        double zzz=0;
        //循环获取修改后的总金额
        List<DocumentShopVo> listshop =this.documentShopService.selectnumber(list.get(0).getDlNumber(),list.get(0).getWid(),list.get(0).getBranchid());
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
    @PostMapping("updateshop")
    public AjaxResponse updateshop(@RequestBody String a){
        JSONObject jsonObject = JSONObject.parseObject(a);
        String one = jsonObject.getString("tabshop");
        DocumentShop documentShop = JSONObject.parseObject(one,DocumentShop.class);
        //修改商品的商品数量
        this.documentShopService.update(documentShop);
        double zzz = 0;
        //循环获取修改后的总金额
        List<DocumentShopVo> listshop = this.documentShopService.selectnumber(documentShop.getDlNumber(),documentShop.getWid(),documentShop.getBranchid());
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
        System.out.println("商品信息："+documentShop);
        this.documentShopService.update(documentShop);
        double zzz = 0;
        List<DocumentShopVo> listshop= this.documentShopService.selectnumber(documentShop.getDlNumber(),documentShop.getWid(),documentShop.getBranchid());
        System.out.println("listshop:"+listshop);
        for(int i = 0;i<listshop.size();i++){
            zzz += listshop.get(i).getZje();
        }
        System.out.println("zzz:"+zzz);
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
        System.out.println("documentShop"+documentShop.getDlNumber());
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
            List<DocumentShopVo> listshop= this.documentShopService.selectnumber(list.get(0).getDlNumber(),list.get(0).getWid(),list.get(0).getBranchid());
            System.out.println("删掉商品后:"+listshop);
            for(int i = 0;i<listshop.size();i++){
                zzz += listshop.get(i).getZje();
            }
            System.out.println("总金额:"+zzz+"   单据号："+list.get(0).getDlNumber());
            XsDocumentlistVo xsvo = xsdocumentListService.queryBydlnumber(list.get(0).getDlNumber());
            System.out.println(list.get(0).getDlNumber()+" : "+xsvo.getDlNumber()+"      单据信息："+xsvo.toString());
            XsdocumentList xsdocumentList = new XsdocumentList();
            xsdocumentList.setDlNumber(xsvo.getDlNumber());
            xsdocumentList.setDlzonje(zzz);
            double aa = xsvo.getV_type_ck() * zzz;
            xsdocumentList.setDlYsje(aa);
            xsdocumentList.setDlSsje(aa);
            double yh = zzz-aa;
            xsdocumentList.setDlYhje(yh);
            System.out.println("修改后的单据金额信息："+xsdocumentList.toString());
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