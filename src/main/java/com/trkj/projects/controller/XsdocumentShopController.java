package com.trkj.projects.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.XsdocumentList;
import com.trkj.projects.mybatis.entity.XsdocumentShop;
import com.trkj.projects.service.XsdocumentListService;
import com.trkj.projects.service.XsdocumentShopService;
import com.trkj.projects.vo.AjaxResponse;
import com.trkj.projects.vo.DocumentShopVo;
import com.trkj.projects.vo.XsDocumentlistVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (XsdocumentShop)表控制层
 *
 * @author makejava
 * @since 2021-06-18 15:47:03
 */
@RestController
@RequestMapping("xsdocumentShop")
public class XsdocumentShopController {
    /**
     * 服务对象
     */
    @Resource
    private XsdocumentShopService xsdocumentShopService;

    @Resource
    private XsdocumentListService xsdocumentListService;

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
     * 根据分店id查询销售商品
     * @return
     */
    @GetMapping("selectBycid")
    public AjaxResponse selectBycid(Integer cid,String data1,String data2,Integer currentPage, Integer pageSize,String name){
        PageInfo<DocumentShopVo> page = xsdocumentShopService.selectbycid(cid,data1,data2,currentPage,pageSize,name);
        System.out.println("商品信息："+page);
        return AjaxResponse.success(page);
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
    public AjaxResponse selectnumber(Integer currenPage, Integer pageSize, String number, int wid, int branchid){
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<DocumentShopVo> list= this.xsdocumentShopService.selectnumber(number,wid,branchid);
        System.out.println("selectnumber:list:"+list);
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
        XsdocumentShop documentShop = JSONObject.parseObject(one,XsdocumentShop.class);
        System.out.println("商品信息："+documentShop);
        this.xsdocumentShopService.update(documentShop);
        double zzz = 0;
        List<DocumentShopVo> listshop= this.xsdocumentShopService.selectnumber(documentShop.getDlNumber(),documentShop.getWid(),documentShop.getBranchid());
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
            tt = this.xsdocumentShopService.deleteById(list.get(i).getId());
        }
        if(tt == true){
            double zzz = 0;
            List<DocumentShopVo> listshop= this.xsdocumentShopService.selectnumber(list.get(0).getDlNumber(),list.get(0).getWid(),list.get(0).getBranchid());
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

}
