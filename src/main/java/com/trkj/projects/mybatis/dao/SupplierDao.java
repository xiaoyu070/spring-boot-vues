package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.Supplier;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Supplier)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-01 11:04:19
 */
@Mapper
public interface SupplierDao {

    /**
     * 通过ID查询单条数据
     *
     * @param sId 主键
     * @return 实例对象
     */
    Supplier queryById(Integer sId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Supplier> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param supplier 实例对象
     * @return 对象列表
     */
    List<Supplier> queryAll(Supplier supplier);

    /**
     * 新增数据
     *
     * @param supplier 实例对象
     * @return 影响行数
     */
    int insert(Supplier supplier);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Supplier> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Supplier> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Supplier> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Supplier> entities);

    /**
     * 修改数据
     *
     * @param supplier 实例对象
     * @return 影响行数
     */
    Boolean update(Supplier supplier);

    /**
     * 通过主键删除数据
     *
     * @param sId 主键
     * @return 影响行数
     */
    int deleteById(Integer sId);

    /**
     * 单据号审核通过后，该单据中包含的商品根据供应商将采购付款一一对应加入到供货商的初期余额中
     */
    void numbersmoney(double money,int supplierid);


    /**
     * 查询供货商表中所有的供货商
     */
    List<Supplier> queryall();

    /**
     * 根据分店类型以及关键字查询
     * @param branchid
     * @param suppliername
     * @return
     */
    List<Supplier> findAllByName(@Param("branchnames") String branchnames,@Param("suppliername") String suppliername);

    List<Supplier> findAll();

    /**
     * 批量删除
     * @param supplierid
     * @return
     */
    Integer pildelsup(@Param("sid")Integer[] supplierid);
}

