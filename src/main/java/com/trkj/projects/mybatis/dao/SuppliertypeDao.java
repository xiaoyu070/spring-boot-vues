package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.Suppliertype;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Suppliertype)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-01 16:26:32
 */
@Mapper
public interface SuppliertypeDao {

    List<Suppliertype> findAll();
    /**
     * 通过ID查询单条数据
     *
     * @param suptypeid 主键
     * @return 实例对象
     */
    Suppliertype queryById(Integer suptypeid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Suppliertype> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param suppliertype 实例对象
     * @return 对象列表
     */
    List<Suppliertype> queryAll(Suppliertype suppliertype);

    /**
     * 新增数据
     *
     * @param suppliertype 实例对象
     * @return 影响行数
     */
    int insert(Suppliertype suppliertype);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Suppliertype> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Suppliertype> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Suppliertype> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Suppliertype> entities);

    /**
     * 修改数据
     *
     * @param suppliertype 实例对象
     * @return 影响行数
     */
    int update(Suppliertype suppliertype);

    /**
     * 通过主键删除数据
     *
     * @param suptypeid 主键
     * @return 影响行数
     */
    int deleteById(Integer suptypeid);

}

