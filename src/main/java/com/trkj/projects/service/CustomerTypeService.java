package com.trkj.projects.service;

import com.trkj.projects.mybatis.entity.CustomerType;
import com.trkj.projects.mybatis.entity.Suppliertype;

import java.util.List;

/**
 * (CustomerType)表服务接口
 *
 * @author makejava
 * @since 2021-06-16 19:35:21
 */
public interface CustomerTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param typeid 主键
     * @return 实例对象
     */
    CustomerType queryById(Integer typeid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CustomerType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param customerType 实例对象
     * @return 实例对象
     */
    CustomerType insert(CustomerType customerType);

    /**
     * 修改数据
     *
     * @param customerType 实例对象
     * @return 实例对象
     */
    CustomerType update(CustomerType customerType);

    /**
     * 通过主键删除数据
     *
     * @param typeid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer typeid);
    List<CustomerType> findall();
}
