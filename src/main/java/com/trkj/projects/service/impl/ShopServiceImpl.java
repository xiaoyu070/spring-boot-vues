package com.trkj.projects.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.dao.ShopDao;
import com.trkj.projects.mybatis.entity.Shop;
import com.trkj.projects.mybatis.entity.Shops;
import com.trkj.projects.service.ShopService;
import com.trkj.projects.util.BeanTools;
import com.trkj.projects.vo.ShopVo;
import com.trkj.projects.vo.Shopandstock;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Shop)表服务实现类
 *
 * @author makejava
 * @since 2021-05-31 19:30:36
 */
@Service("shopService")
public class ShopServiceImpl implements ShopService {
    @Resource
    private ShopDao shopDao;

    /**
     * 通过ID查询单条数据
     *
     * @param spId 主键
     * @return 实例对象
     */
    @Override
    public Shops queryById(Integer spId) {
        return this.shopDao.queryById(spId);
    }

    /**
     * 通过商品名称查询单条数据
     *
     * @param name 商品名称
     * @return 实例对象
     */
    @Override
    public List<Shops> queryByName(String name) {
        return this.shopDao.queryByName(name);
    }

    @Override
    public Shop insert(Shop shop) {
        return null;
    }

    @Override
    public void update(Shop shop) {
        this.shopDao.update(shop);
    }




    /**
     * 通过主键删除数据
     *
     * @param spId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer spId) {
        return this.shopDao.deleteById(spId) > 0;
    }

    /**
     * 查询vo
     * @return
     */
    @Override
    public List<Shopandstock> queryshopanstock(int value) {
        return this.shopDao.queryshopanstock(value);
    }

    @Override
    public List<Shopandstock> queryshopanstocktuihuo(int value) {
        return this.shopDao.queryshopanstocktuihuo(value);
    }


    /**
     * 模糊查询
     * @param test
     * @return
     */
    @Override
    public List<Shopandstock> likeselect(String test) {
        return this.shopDao.likeselect(test);
    }

    @Override
    public List<Shopandstock> likeselecttuihuo(String test) {
        return this.shopDao.likeselecttuihuo(test);
    }

    @Override
    public List<Shopandstock> showsupplier(Integer test) {
        return this.shopDao.showsupplier(test);
    }

    @Override
    public List<Shopandstock> chcsselect(int wid) {
        return this.shopDao.chcsselect(wid);
    }


/**
 * --------------------------------------------------------
 */

    /**
     * 分页查询所有商品
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<ShopVo> queryAllByPage(int currentPage, int pageSize) {
        System.out.println(currentPage);
        Page<Shops> page= PageHelper.startPage(currentPage,pageSize,true);
        List<Shops> list=shopDao.queryAllByPage();
        List<ShopVo> vos=new ArrayList<>();
        BeanTools.copyList(list,vos, ShopVo.class);
        PageInfo<ShopVo> info=new PageInfo<>(vos);
        info.setTotal((long)this.shopDao.queryCount());
        return info;
    }

    @Override
    public Integer queryCount() {
        int count = this.shopDao.queryCount();
        System.out.println("8888888888888888888888    :"+count);
        return count;
    }
    /**
     * 关键字查询
     * @param shopname
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<ShopVo> queryBytypeLike (String shopname,String shoptypename,Integer shopstatic,Integer currentPage, Integer pageSize) {
        List<Shops> list1=this.shopDao.queryBytypelike(shopname,shoptypename,shopstatic);
        System.out.println(list1.size()+"---------------");
        Page<Shops> page= PageHelper.startPage(currentPage,pageSize,true);
        List<Shops> list=this.shopDao.queryBytypelike(shopname,shoptypename,shopstatic);
        List<ShopVo> vos = new ArrayList<>();
        BeanTools.copyList(list,vos,ShopVo.class);
        PageInfo<ShopVo> info = new PageInfo<>(vos);
        info.setTotal((long)list1.size());
        for(Shops shop1:list1) {
            System.out.println(shop1);
        }
        System.out.println("88888888888888888888888888888888888888     :"+this.shopDao.selectCount(shopname));

        return info;
    }

    @Override
    public Integer selectCount(String shopname) {
        int count = this.shopDao.selectCount(shopname);
        System.out.println("8888888888888888888888    :"+count);
        return count;
    }



    @Override
    public PageInfo<ShopVo> queryAllByType(Integer shopstatic,String shopname,String shoptypename,Integer currentPage, Integer pageSize) {
        List<Shops> list1=this.shopDao.queryAllByType(shoptypename,shopname,shopstatic);
        System.out.println(list1.size()+"---------------");
        Page<Shops> page= PageHelper.startPage(currentPage,pageSize,true);
        List<Shops> list=this.shopDao.queryAllByType(shoptypename,shopname,shopstatic);
        return getShopVoPageInfo(list1, list);
    }

    /**
     * 根据商品id批量禁用商品
     * @param list
     * @return
     */
    @Override
    public Integer updatePil(Integer[] list) {
        System.out.println(list.toString());
        return this.shopDao.updatePil(list);
    }

    /**
     * 根据商品id单个禁用商品
     * @param shopid
     * @return
     */
    @Override
    public Integer updateStatic(Integer shopid) {
        System.out.println(shopid);

        return this.shopDao.updateStatic(shopid);
    }
    /**
     * 根据商品id单个启用商品
     * @param shopid
     * @return
     */
    @Override
    public Integer updateStatic2(Integer shopid) {
        return this.shopDao.updateStatic2(shopid);
    }

    /**
     * 批量删除
     * @param shopid
     * @return
     */
    @Override
    public Integer delShop(Integer[] shopid) {
        return shopDao.delShop(shopid);
    }

    @Override
    public List<Shops> findshopname(String shopname) {
        return this.shopDao.findAllByShopName(shopname);
    }

    /**
     * 新增商品
     * @param shop
     * @return
     */
    @Override
    public Boolean insertShop(Shops shop) {
        List<Shops> shopname = findshopname(shop.getSpName());
        if(shopname.size()>0){
            return false;
        }
        this.shopDao.insertShop(shop);
        return true;
    }

    /**
     * 修改商品
     * @param shop
     * @return
     */
    @Override
    public Integer updateshop(Shops shop) {

        return this.shopDao.updateshop(shop);
    }

    @Override
    public PageInfo<ShopVo> queryAllBySatic(Integer shopstatic, String shopname, String shoptypename, Integer currentPage, Integer pageSize) {
        List<Shops> list1=this.shopDao.queryAllByStatic(shopstatic,shopname,shoptypename);
        System.out.println(list1.size()+"---------------");
        Page<Shop> page= PageHelper.startPage(currentPage,pageSize,true);
        List<Shops> list=this.shopDao.queryAllByStatic(shopstatic,shopname,shoptypename);
        return getShopVoPageInfo(list1, list);
    }

    private PageInfo<ShopVo> getShopVoPageInfo(List<Shops> list1, List<Shops> list) {
        List<ShopVo> vos = new ArrayList<>();
        BeanTools.copyList(list,vos,ShopVo.class);
        PageInfo<ShopVo> info = new PageInfo<>(vos);
        info.setTotal((long)list1.size());
        return info;
    }


    //-----------------------------一哥的
    @Override
    public int updatePrice(String spid,double jpe) {

        return this.shopDao.updatePrice(spid,jpe);
    }

}
