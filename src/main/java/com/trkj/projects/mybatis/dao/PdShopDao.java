package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.PdShop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PdShop)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-17 19:07:02
 */
@Mapper
public interface PdShopDao {

    /**
     * 通过ID查询单条数据
     *
     * @param 主键
     * @return 实例对象
     */
//    PdShop queryById();

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PdShop> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param pdShop 实例对象
     * @return 对象列表
     */
    List<PdShop> queryAll(PdShop pdShop);

    /**
     * 新增数据
     *
     * @param pdShop 实例对象
     * @return 影响行数
     */
    int insert(PdShop pdShop);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PdShop> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PdShop> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PdShop> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<PdShop> entities);

    /**
     * 修改数据
     *
     * @param pdShop 实例对象
     * @return 影响行数
     */
//    int update(PdShop pdShop);

    /**
     * 通过主键删除数据
     *
     * @param 主键
     * @return 影响行数
     */
//    int deleteById();

    int updatepdnumber(@Param("pdNumber") Integer pdNumber,@Param("pdId")String pdId);

    int delectshop(int id);

}

