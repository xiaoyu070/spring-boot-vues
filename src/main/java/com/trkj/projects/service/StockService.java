package com.trkj.projects.service;

import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.Stock;
import com.trkj.projects.vo.StockVo;
import com.trkj.projects.vo.StockVov;

import java.util.List;

/**
 * (Stock)表服务接口
 *
 * @author makejava
 * @since 2021-06-04 14:19:35
 */
public interface StockService {


    /**
     * 新增数据
     *
     * @param stock 实例对象
     * @return 实例对象
     */
    Stock insert(Stock stock);

    /**
     * 单据通过审核后商品入库之前先查询库存中该店面该仓库是否存在该商品
     * @param stock
     * @return
     */
    List<Stock> findbybranchidandshopidandwid(Stock stock);

    /**
     * 修改数据（已用）
     * 采购已审核的商品单据中的商品添加到库存
     * @param stock 实例对象
     * @return 实例对象
     */
    int update(Stock stock);

    /**
     * 修改数据（已用）
     *退货已审核的商品单据中的商品减少库存
     * @param stock 实例对象
     * @return 影响行数
     */
    int updatedelete(Stock stock);
    /**
     * 修改库存数量
     * @param stock
     * @return
     */
    int xsupdate(Stock stock);
    int xsupdate2(Stock stock);

    PageInfo<StockVov> findallbytypeandlike(String nameandid, int currentPage, int pageSize);
    /**
     * 根据分店i的外键查询所有
     * @param value
     * @return
     */
    PageInfo<StockVov> selectbybranchid(Integer value, int currentPage, int pageSize );

    //---------------------一哥的

    /**
     * 分页查询所有库存商品
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<StockVo> findAll(int currentPage, int pageSize);

    /**
     * 分页查询所有的 0库存 和所有库存
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<StockVo> selectkucun(int currentPage,int pageSize,int test22);

    /**
     * 模糊查询
     * @param currentPage
     * @param pageSize
     * @param testlike
     * @return
     */
    PageInfo<StockVo>selectlike(int currentPage,int pageSize, String testlike);

    /**
     * 库存报警模糊查询所有商品
     * @param currentPage
     * @param pageSize
     * @param testlike2
     * @return
     */
    PageInfo<StockVo>kucunbaojinlike(int currentPage,int pageSize, String testlike2);

    /**
     * 查询显示禁用商品
     * @param currentPage
     * @param pageSize
     * @param did
     * @return
     */
    PageInfo<StockVo>selectDisable(int currentPage,int pageSize, boolean did);

    /**
     * 库存查询所有报警商品
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<StockVo> KucunBaoJin(int currentPage, int pageSize);

    /**
     * 模糊查询
     * @param currentPage
     * @param pageSize
     * @param KCmohu
     * @return
     */
    PageInfo<StockVo> KcMoHuSelect(int currentPage, int pageSize, String KCmohu);

    /**
     * 库存报警修改最低库存数量
     * @param skid
     * @param kcbj
     * @return
     */
    int Kcbjupdate (int skid,int kcbj);


    /**
     * 根据店面和仓库查询商品和库存
     * @return
     */
    PageInfo<StockVo>baosunbaoyiselect(int currentPage, int pageSize,int param1, int param2);


}
