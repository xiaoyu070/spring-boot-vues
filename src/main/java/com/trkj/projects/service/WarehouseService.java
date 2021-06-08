package com.trkj.projects.service;

import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.Warehouse;

import java.util.List;

/**
 * (Warehouse)表服务接口
 *
 * @author makejava
 * @since 2021-05-31 20:00:17
 */
public interface WarehouseService {

    /**
     * 通过ID查询单条数据
     *
     * @param wid 主键
     * @return 实例对象
     */
    Warehouse queryById(Integer wid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Warehouse> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param warehouse 实例对象
     * @return 实例对象
     */
    Warehouse insert(Warehouse warehouse);

    /**
     * 修改数据
     *
     * @param warehouse 实例对象
     * @return 实例对象
     */
    Warehouse update(Warehouse warehouse);

    /**
     * 通过主键删除数据
     *
     * @param wid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer wid);

    /**
     * 查询仓库表中的所有数据
     */
    List<Warehouse> selectall();

    /**
     * 根据branchid查询店面
     */
    List<Warehouse> selectbranchid(int id);

    List<Warehouse> queryBybranId(Integer branchid);

    //----------------------------------老弟的
    Warehouse addWarehouse(Warehouse warehouse);
    public Integer deleteWarehouse(Integer[] wid);
    Warehouse updateWarehouse(Warehouse warehouse);
    PageInfo<Warehouse> findbranchid(int pageSize, int size, Integer branchid);
    PageInfo<Warehouse> findMohu(int pageSize, int size, String wname);

    //----------------------------------一哥的
    List<Warehouse> queryWarehouse(int id);
    List<Warehouse> findAll();

}
