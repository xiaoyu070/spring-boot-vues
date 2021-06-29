package com.trkj.projects.service.impl;

import com.trkj.projects.mybatis.entity.CustomerType;
import com.trkj.projects.mybatis.dao.CustomerTypeDao;
import com.trkj.projects.mybatis.entity.Suppliertype;
import com.trkj.projects.service.CustomerTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CustomerType)表服务实现类
 *
 * @author makejava
 * @since 2021-06-16 19:35:22
 */
@Service("customerTypeService")
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Resource
    private CustomerTypeDao customerTypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param typeid 主键
     * @return 实例对象
     */
    @Override
    public CustomerType queryById(Integer typeid) {
        return this.customerTypeDao.queryById(typeid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CustomerType> queryAllByLimit(int offset, int limit) {
        return this.customerTypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param customerType 实例对象
     * @return 实例对象
     */
    @Override
    public CustomerType insert(CustomerType customerType) {
        this.customerTypeDao.insert(customerType);
        return customerType;
    }

    /**
     * 修改数据
     *
     * @param customerType 实例对象
     * @return 实例对象
     */
    @Override
    public CustomerType update(CustomerType customerType) {
        this.customerTypeDao.update(customerType);
        return this.queryById(customerType.getTypeid());
    }

    /**
     * 通过主键删除数据
     *
     * @param typeid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer typeid) {
        return this.customerTypeDao.deleteById(typeid) > 0;
    }

    public List<CustomerType> findall() {
        return customerTypeDao.findAll();
    }
}
