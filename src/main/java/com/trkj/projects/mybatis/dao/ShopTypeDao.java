package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.ShopType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (ShopType)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-01 09:52:36
 */
@Mapper
public interface ShopTypeDao {

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ShopType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param shopType 实例对象
     * @return 对象列表
     */
    List<ShopType> queryAll(ShopType shopType);

    /**
     * 新增数据
     *
     * @param shopType 实例对象
     * @return 影响行数
     */
    int insert(ShopType shopType);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShopType> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ShopType> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShopType> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<ShopType> entities);


    List<ShopType> queryall();

    /**
     * 修改数据
     *
     * @param shoptype 实例对象
     * @return 影响行数
     */
    int update(ShopType shoptype);

    /**
     * 通过主键删除数据
     *
     * @param shoptypeid 主键
     * @return 影响行数
     */
    int deleteById(Integer shoptypeid);

}

