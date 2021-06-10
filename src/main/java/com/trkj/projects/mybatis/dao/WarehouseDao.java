package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.Warehouse;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Warehouse)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-31 20:00:07
 */
@Mapper
public interface WarehouseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param wid 主键
     * @return 实例对象
     */
    Warehouse queryById(Integer wid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Warehouse> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param warehouse 实例对象
     * @return 对象列表
     */
    List<Warehouse> queryAll(Warehouse warehouse);

    /**
     * 新增数据
     *
     * @param warehouse 实例对象
     * @return 影响行数
     */
    int insert(Warehouse warehouse);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Warehouse> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Warehouse> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Warehouse> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Warehouse> entities);

    /**
     * 修改数据
     *
     * @param warehouse 实例对象
     * @return 影响行数
     */
    int update(Warehouse warehouse);

    /**
     * 通过主键删除数据
     *
     * @param wid 主键
     * @return 影响行数
     */
    int deleteById(Integer wid);

    List<Warehouse> selectall();

    List<Warehouse> selectbranchid(int id);

    List<Warehouse> queryBybranchid(Integer branchid);

    //------------------------老弟的
    //根据分店id查询
    List<Warehouse> selectByBrachid(Integer branchid);

    //模糊查询
    List<Warehouse> selectMohu(String wname);

    int deleteByPrimaryKey(Integer wid);

    int deleteWarehouse(Integer branchid);
    //根据分店编号批量删除
    Integer deleteByWarehouse(@Param("branchid")Integer[] branchid);
    //根据wid批量删除仓库
    Integer deleteWarehouseId(@Param("wid")Integer[] wid);

    int insertSelective(Warehouse record);

    Warehouse selectByPrimaryKey(Integer wid);

    int updateByPrimaryKeySelective(Warehouse record);

    int updateByPrimaryKey(Warehouse record);

    //--------------------------一哥的
    /**
     * 查询仓库名称
     * @param id
     * @return
     */
    List<Warehouse> queryWarehouse(int id);

    List<Warehouse> findAll();

}