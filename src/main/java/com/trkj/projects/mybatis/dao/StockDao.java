package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.Stock;
import com.trkj.projects.vo.StockVo;
import com.trkj.projects.vo.StockVov;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Stock)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-04 14:19:26
 */
@Mapper
public interface StockDao {

    /**
     * 新增数据
     *
     * @param stock 实例对象
     * @return 影响行数
     */
    int insert(Stock stock);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Stock> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Stock> entities);


    /**
     * 修改数据
     *
     * @param stock 实例对象
     * @return 影响行数
     */
    int updateadd(Stock stock);
    /**
     * 修改数据
     *
     * @param stock 实例对象
     * @return 影响行数xs
     */
    int xsupdateadd(Stock stock);


    List<StockVov> findallbytypeandlike(@Param("nameandid") String nameandid);
    List<StockVov> queryshopanstock(Integer value);


    //----------------------------------------------一哥的
    /**
     * 库存模糊查询
     * @param KCmohu
     * @return
     */
    List<StockVo> KcMoHuSelect(String KCmohu);

    /**
     * 查询所有禁用商品
     * @return
     */
    List<StockVo>selectKuCunBaoJin();

    /**
     * 显示禁用商品
     * @param did
     * @return
     */
    List<StockVo>selectDisable(boolean did);

    /**
     * 模糊查询所有
     * @param testlike
     * @return
     */
    List<StockVo>selectlike(String testlike);

    /**
     * 库存报警中的模糊查询
     * @param testlike2
     * @return
     */
    List<StockVo>kucunbaojinlike(String testlike2);


    /**
     * 查询所有库存数量  显示为0 不显示为0 所有库存
     * @return
     */
    List<StockVo>querykucun(int test22);


    /**
     * 查询所有商品
     * @return
     */
    List<StockVo> queryall();

    /**
     * 修改库存报警中的最低库存
     * @param skid
     * @param kcbj
     * @return
     */
    int Kcbjupdate(@Param("skid") int skid,@Param("kcbj") int kcbj);

    /**
     * 根据店面和仓库查询库存和商品
     * @return
     */
    List<StockVo>baosunbaoyiselect(int param1, int param2);


}

