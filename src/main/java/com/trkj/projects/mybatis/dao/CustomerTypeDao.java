package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.Customer;
import com.trkj.projects.mybatis.entity.CustomerType;
import com.trkj.projects.mybatis.entity.Supplier;
import com.trkj.projects.mybatis.entity.Suppliertype;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (CustomerType)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-15 21:12:14
 */
@Mapper
public interface CustomerTypeDao {
    List<CustomerType> findAll();
    /**
     * 通过ID查询单条数据
     *
     * @param typeid 主键
     * @return 实例对象
     */
    CustomerType queryById(Integer typeid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CustomerType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param customerType 实例对象
     * @return 对象列表
     */
    List<CustomerType> queryAll(CustomerType customerType);

    /**
     * 新增数据
     *
     * @param customerType 实例对象
     * @return 影响行数
     */
    int insert(CustomerType customerType);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CustomerType> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CustomerType> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CustomerType> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<CustomerType> entities);

    /**
     * 修改数据
     *
     * @param customerType 实例对象
     * @return 影响行数
     */
    int update(CustomerType customerType);

    /**
     * 通过主键删除数据
     *
     * @param typeid 主键
     * @return 影响行数
     */
    int deleteById(Integer typeid);

}

