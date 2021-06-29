package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.Shop;
import com.trkj.projects.mybatis.entity.Shops;
import com.trkj.projects.vo.Shopandstock;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * (Shop)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-31 19:30:27
 */
 @Mapper
public interface ShopDao {


    List<Shops> queryByName(String name);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Shops> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param shop 实例对象
     * @return 对象列表
     */
    List<Shops> queryAll(Shops shop);

    /**
     * 新增数据
     *
     * @param shop 实例对象
     * @return 影响行数
     */
    int insert(Shops shop);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Shop> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Shops> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Shop> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Shops> entities);

    /**
     * 修改数据
     *
     * @param shop 实例对象
     * @return 影响行数
     */
    int update(Shop shop);

    /**
     * 通过主键删除数据
     *
     * @param spId 主键
     * @return 影响行数
     */
    int deleteById(Integer spId);

    /**
     * 查询老商品添加中的所有商品信息
     */
    List<Shopandstock> queryshopanstock(int value);

    /**
     * 查询库存中剩余数量不为0的商品（退货）
     */
    List<Shopandstock> queryshopanstocktuihuo(int value);



    /**
     * 根据选择的出货仓库查询他对应的商品库存（退货）
     */
    List<Shopandstock> chcsselect(int wid);

    /**
     * 模糊查询
     */
    List<Shopandstock> likeselect(String test);
    /**
     * 模糊查询退货(库存大于0时才可以退货)
     */
    List<Shopandstock> likeselecttuihuo(String test);

    /**
     * 只显示当前供货商提供的商品
     */
    List<Shopandstock> showsupplier(int test);




    /**
     * 通过ID查询单条数据
     *
     * @param spid 主键
     * @return 实例对象
     */
    Shops queryById(Integer spid);

    /**
     * 可通过分页插件查询信息
     * @return
     */
    List<Shops> queryAllByPage();

    Integer queryCount();

    /**
     * 关键字查询
     * @param shopname
     * @return
     */
    List<Shops> queryBytypelike(@Param("shopname") String shopname,@Param("shoptypename")String shoptypename,@Param("shopstatic") int shopstatic);

    Integer selectCount(@Param("shopname") String shopname);

    List<Shops> queryAllByType(@Param("shoptypename") String shoptypename,@Param("shopname") String shopname,@Param("shopstatic") int shopstatic);
    //禁用
    Integer updateStatic(@Param("shopid") Integer shopid);

    Integer updatePil(@Param("listid")Integer[] listid);
    //启用
    Integer updateStatic2(@Param("shopid")Integer shopid);
    /**
     * 根据商品状态查询
     * @param shopstatic
     * @return
     */
    List<Shops> queryAllByStatic(@Param("shopstatic") int shopstatic,@Param("shoptypename")String shoptypename,@Param("shopname")String shopname);

    /**
     * 批量删除
     * @param shopid
     * @return
     */
    Integer delShop(@Param("shopid") Integer[] shopid);

    List<Shops> findAllByShopName(@Param("shopname") String shopname);

    /**
     * 新增商品
     * @param shop
     * @return
     */
    Integer insertShop(Shops shop);

    Integer updateshop(Shops shop);


    //----------------------------------一哥的
    int updatePrice(@Param("spid") String spid,@Param("jpe") double jpe);


}

