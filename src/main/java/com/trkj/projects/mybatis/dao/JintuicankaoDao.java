package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.Jintuicankao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Jintuicankao)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-22 19:55:43
 */
@Mapper
public interface JintuicankaoDao {

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */


    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Jintuicankao> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param jintuicankao 实例对象
     * @return 对象列表
     */
    List<Jintuicankao> queryAll(Jintuicankao jintuicankao);

    /**
     * 新增数据
     *
     * @param jintuicankao 实例对象
     * @return 影响行数
     */
    int insert(Jintuicankao jintuicankao);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Jintuicankao> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Jintuicankao> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Jintuicankao> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Jintuicankao> entities);

    List<Jintuicankao> selectjinhuocangkao();

    /**
     * 根据商品编号修改进价参考数量
     * @param ckTuihuonumber
     * @param spShopid
     * @return
     */
    int updatecangkao (@Param("ckTuihuonumber")Integer ckTuihuonumber ,@Param("spShopid") String spShopid);

    /**
     * 根据商品编号删除进价参考
     * @param
     * @return
     */
    int deletecangkao(String spShopid);

}

