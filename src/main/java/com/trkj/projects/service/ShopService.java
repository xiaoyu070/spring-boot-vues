package com.trkj.projects.service;

import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.Shop;
import com.trkj.projects.mybatis.entity.Shops;
import com.trkj.projects.vo.ShopVo;
import com.trkj.projects.vo.Shopandstock;

import java.util.List;

/**
 * (Shop)表服务接口
 *
 * @author makejava
 * @since 2021-05-31 19:30:36
 */
public interface ShopService {

    /**
     * 通过ID查询单条数据
     *
     * @param spId 主键
     * @return 实例对象
     */
    Shops queryById(Integer spId);

    /**
     * 通过商品名称查询单条数据
     *
     * @param name 商品名称
     * @return 实例对象
     */
    List<Shops> queryByName(String name);

    /**
     * 新增数据
     *
     * @param shop 实例对象
     * @return 实例对象
     */
    Shop insert(Shop shop);

    /**
     * 修改数据
     *
     * @param shop 实例对象
     * @return 实例对象
     */
    void update(Shop shop);

    /**
     * 通过主键删除数据
     *
     * @param spId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer spId);

    /**
     * 查询老商品添加中的所有商品信息
     */
    List<Shopandstock> queryshopanstock(int value);

    /**
     * 模糊查询
     */
    List<Shopandstock> likeselect(String test);

    /**
     * 只显示当前供货商提供的商品
     */
    List<Shopandstock> showsupplier(Integer test);


/**
 * -------------------------------------------------------------------------
 */

    /**
     * 可通过分页插件查询信息
     * @return
     */
    public PageInfo<ShopVo> queryAllByPage(int currentPage, int pageSize) ;

    public Integer queryCount();

    /**
     * 关键字查询
     * @param shopname
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageInfo<ShopVo> queryBytypeLike(String shopname, String shoptypename, Integer shopstatic, Integer currentPage, Integer pageSize);
    public Integer selectCount(String shopname);
    public PageInfo<ShopVo> queryAllBySatic(Integer shopstatic,String shopname,String shoptypename,Integer currentPage, Integer pageSize);
    public PageInfo<ShopVo> queryAllByType(Integer shopstatic,String shopname,String shoptypename,Integer currentPage, Integer pageSize);

    /**
     * 批量禁用商品状态
     * @param list
     * @return
     */
    public Integer updatePil(Integer[] list);
    public Integer updateStatic(Integer shopid);
    public Integer updateStatic2(Integer shopid);

    /**
     * 批量删除
     * @param shopid
     * @return
     */
    public Integer delShop(Integer[] shopid);

    public List<Shops> findshopname(String shopname);

    /**
     * 新增商品
     * @param shop
     * @return
     */
    public Boolean insertShop(Shops shop);

    /**
     * 修改商品
     * @param shop
     * @return
     */
    public Integer updateshop(Shops shop);

    //----------------------------------一哥的
    int updatePrice (String spid,double jpe);

}
