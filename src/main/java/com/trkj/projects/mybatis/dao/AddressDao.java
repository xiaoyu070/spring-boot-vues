package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Address)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-01 16:23:51
 */
@Mapper
public interface AddressDao {

    List<Address> findAll();
    /**
     * 通过ID查询单条数据
     *
     * @param addressid 主键
     * @return 实例对象
     */
    Address queryById(Integer addressid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Address> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param address 实例对象
     * @return 对象列表
     */
    List<Address> queryAll(Address address);

    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 影响行数
     */
    int insert(Address address);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Address> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Address> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Address> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Address> entities);

    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 影响行数
     */
    int update(Address address);

    /**
     * 通过主键删除数据
     *
     * @param addressid 主键
     * @return 影响行数
     */
    int deleteById(Integer addressid);

}

