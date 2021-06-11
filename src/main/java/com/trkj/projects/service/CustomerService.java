package com.trkj.projects.service;


import com.trkj.projects.mybatis.entity.Customer;

import java.util.List;

/**
 * (Customer)表服务接口
 *
 * @author makejava
 * @since 2021-06-05 21:45:34
 */
public interface CustomerService {
    List<Customer> findall();
    List<Customer> queryByBranchId(Integer branchid);
    /**
     * 通过ID查询单条数据
     *
     * @param cId 主键
     * @return 实例对象
     */
    Customer queryById(Integer cId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Customer> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param customer 实例对象
     * @return 实例对象
     */
    Customer insert(Customer customer);

    /**
     * 修改数据
     *
     * @param customer 实例对象
     * @return 实例对象
     */
    Customer update(Customer customer);
    //修改客户我方收款金额
    void updatemoney(double money,int customerid);

    /**
     * 通过主键删除数据
     *
     * @param cId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer cId);

}
