package com.trkj.projects.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.dao.StockDao;
import com.trkj.projects.mybatis.entity.Stock;
import com.trkj.projects.service.StockService;
import com.trkj.projects.vo.StockVo;
import com.trkj.projects.vo.StockVov;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Stock)表服务实现类
 *
 * @author makejava
 * @since 2021-06-04 14:19:35
 */
@Service("stockService")
public class StockServiceImpl implements StockService {
    @Resource
    private StockDao stockDao;

    /**
     * 新增数据
     *
     * @param stock 实例对象
     * @return 实例对象
     */
    @Override
    public Stock insert(Stock stock) {
        this.stockDao.insert(stock);
        return stock;
    }

    @Override
    public List<Stock> findbybranchidandshopidandwid(Stock stock) {
        return this.stockDao.findbybranchidandshopidandwid(stock);
    }

    /**
     * 修改数据
     *
     * @param stock 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Stock stock) {
        return this.stockDao.updateadd(stock);
    }

    @Override
    public int updatedelete(Stock stock) {
        return this.stockDao.updatedelete(stock);
    }

    /**
     * 减库存数量
     * @param stock
     * @return
     */
    @Override
    public int xsupdate(Stock stock) {
        return this.stockDao.xsupdateadd(stock);
    }

    /**
     * 根据商品类型以及关键字查询
     */
    @Override
    public PageInfo<StockVov> findallbytypeandlike(String nameandid, int currentPage, int pageSize) {
        List<StockVov> list = stockDao.findallbytypeandlike(nameandid);
        Page<StockVov> page = PageHelper.startPage(currentPage,pageSize,true);
        List<StockVov> list2 = stockDao.findallbytypeandlike(nameandid);
        PageInfo<StockVov> info = new PageInfo<>(list2);
        info.setTotal(list.size());
        return info;
    }

    /**
     * 根据商品类型查询分页
     * @param
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<StockVov> selectbybranchid(Integer value, int currentPage, int pageSize) {
        List<StockVov> list = stockDao.queryshopanstock(value);
        Page<StockVov> page = PageHelper.startPage(currentPage,pageSize,true);
        List<StockVov> list2 = stockDao.queryshopanstock(value);
        PageInfo<StockVov> info = new PageInfo<>(list2);
        info.setTotal(list.size());
        return info;
    }

    //---------------------------------一哥的

    /**
     * 分页查询所有的库存商品
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<StockVo> findAll(int currentPage, int pageSize) {
        List<StockVo> list=this.stockDao.queryall();
        //封装分页插件
        PageHelper.startPage(currentPage,pageSize);
        //再查所有最终传过去的数据
        List<StockVo> list2 = this.stockDao.queryall();
        //封装到pageinfo再设置总条数获取第一个list的大小size()方法
        PageInfo<StockVo> info = new PageInfo<>(list2);
        info.setTotal(list.size());
        System.out.println(list);
        return info;
    }

    /**
     * 库存插叙0库存所有库存
     * @param currentPage
     * @param pageSize
     * @param test22
     * @return
     */
    @Override
    public PageInfo<StockVo> selectkucun(int currentPage, int pageSize,int test22) {
        List<StockVo> list =this.stockDao.querykucun(test22);
        //封装分页插件
        PageHelper.startPage(currentPage,pageSize);
        //再查所有最终传过去的数据

        //封装到pageinfo再设置总条数获取第一个list的大小size()方法
        PageInfo<StockVo> info = new PageInfo<>(list);
        info.setTotal(list.size());
        System.out.println(info);
        return info;
    }


    /**
     * 模糊查询
     * @param currentPage
     * @param pageSize
     * @param testlike
     * @return
     */
    @Override
    public PageInfo<StockVo> selectlike(int currentPage, int pageSize, String testlike) {
        List<StockVo> list =this.stockDao.selectlike(testlike);
        PageHelper.startPage(currentPage,pageSize);
        PageInfo<StockVo>info=new PageInfo<>(list);
        info.setTotal(list.size());
        System.out.println(info);
        return  info;
    }

    /**
     * 库存报警中的模糊查询
     * @param currentPage
     * @param pageSize
     * @param testlike2
     * @return
     */
    @Override
    public PageInfo<StockVo> kucunbaojinlike(int currentPage, int pageSize, String testlike2) {
        List<StockVo> list =this.stockDao.kucunbaojinlike(testlike2);
        PageHelper.startPage(currentPage,pageSize);
        PageInfo<StockVo>info=new PageInfo<>(list);
        info.setTotal(list.size());
        System.out.println(info);
        return  info;
    }

    /**
     * 显示禁用商品
     * @param currentPage
     * @param pageSize
     * @param did
     * @return
     */
    @Override
    public PageInfo<StockVo> selectDisable(int currentPage, int pageSize, boolean did) {
        List<StockVo> list =this.stockDao.selectDisable(did);
        PageHelper.startPage(currentPage,pageSize);
        PageInfo<StockVo>info=new PageInfo<>(list);
        info.setTotal(list.size());
        System.out.println(info);
        return info;
    }

    /**
     * 查询库存报警所有报警商品
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<StockVo> KucunBaoJin(int currentPage, int pageSize) {
        List<StockVo>list=this.stockDao.selectKuCunBaoJin();
        PageHelper.startPage(currentPage,pageSize);
        PageInfo<StockVo>info=new PageInfo<>(list);
        info.setTotal(list.size());
        System.out.println(info);
        return info;
    }

    /**
     * 模糊查询库存商品信息
     * @param currentPage
     * @param pageSize
     * @param KCmohu
     * @return
     */
    @Override
    public PageInfo<StockVo> KcMoHuSelect(int currentPage, int pageSize, String KCmohu) {
        List<StockVo> list =this.stockDao.KcMoHuSelect(KCmohu);
        PageHelper.startPage(currentPage,pageSize);
        PageInfo<StockVo>info =new PageInfo<>(list);
        info.setTotal(list.size());
        return info;
    }

    /**
     * 库存报警修改最低库存数量
     * @param skid
     * @param kcbj
     * @return
     */
    @Override
    public int Kcbjupdate(int skid, int kcbj) {
        return this.stockDao.Kcbjupdate(skid,kcbj);
    }

    /**
     * 根据店面和仓库查询库存和商品
       * @return
     */
    @Override
    public PageInfo<StockVo> baosunbaoyiselect(int currentPage, int pageSize,int param1, int param2) {
       List<StockVo> list=this.stockDao.baosunbaoyiselect(param1,param2);
       PageInfo<StockVo> info =new PageInfo<>(list);
       info.setTotal(list.size());
        return info;
    }

    /**
     * 根据您店面和仓库查询所有库存商品
     * @param currentPage
     * @param pageSize
     * @param param1
     * @param param2
     * @param param3
     * @return
     */
    @Override
    public PageInfo<StockVo> selectdiancnag(int currentPage, int pageSize, int param1, int param2,int param3) {
        List<StockVo> list=this.stockDao.selectdiancnag(param1,param2,param3);
        PageInfo<StockVo> info=new PageInfo<>(list);
        info.setTotal(list.size());
        return info;
    }

    /**
     * 根据仓库店面查询所有库存报警商品
     * @param currentPage
     * @param pageSize
     * @param param1
     * @param param2
     * @param param3
     * @return
     */
    @Override
    public PageInfo<StockVo> kucunbaojin(int currentPage, int pageSize, int param1, int param2, int param3) {
        List<StockVo> list=this.stockDao.kucunbaojin(param1,param2,param3);
        PageInfo<StockVo> info =new PageInfo<>(list);
        info.setTotal(list.size());
        return info;
    }

    @Override
    public PageInfo<StockVo> typeselect(int currentPage, int pageSize, int param1) {
        List<StockVo> list=this.stockDao.typeselect(param1);
        PageInfo<StockVo> info =new PageInfo<>(list);
        info.setTotal(list.size());
        return  info;
    }

    /**
     * 根据店面仓库 商品编号修改库存数量

     * @return
     */
    @Override
    public int updatestocknumber(Stock stock) {

        return this.stockDao.updatestocknumber(stock);
    }

    @Override
    public PageInfo<StockVo> selectjhck(int currentPage, int pageSize) {
        List<StockVo> list =this.stockDao.selectjhck();
        PageInfo<StockVo> info=new PageInfo<>(list);
        info.setTotal(list.size());
        return  info;
    }

    /**
     * 查询进货参考
     * @param currentPage
     * @param pageSize
     * @param typeid
     * @return
     */
    @Override
    public PageInfo<StockVo> selecttypejhck(int currentPage, int pageSize, int typeid) {
        List<StockVo> list =this.stockDao.selecttypejhck(typeid);
        PageInfo<StockVo> info=new PageInfo<>(list);
        info.setTotal(list.size());
        return  info;
    }

    @Override
    public Integer updatepilian(Integer stocks,Integer shopid) {
        return this.stockDao.updatepilian(stocks,shopid);
    }


}
