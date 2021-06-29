package com.trkj.projects.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.dao.CustomerDao;
import com.trkj.projects.mybatis.entity.Customer;
import com.trkj.projects.mybatis.entity.Supplier;
import com.trkj.projects.service.CustomerService;
import com.trkj.projects.util.BeanTools;
import com.trkj.projects.vo.CghzVo;
import com.trkj.projects.vo.CustomerVo;
import com.trkj.projects.vo.SpcgmxVo;
import com.trkj.projects.vo.SupplierVo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Customer)表服务实现类
 *
 * @author makejava
 * @since 2021-06-05 21:45:34
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerDao customerDao;

    @Override
    public List<Customer> findall() {
        return customerDao.findall();
    }

    @Override
    public List<Customer> queryByBranchId(Integer branchid) {
        return customerDao.selectBybranchid(branchid);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param cId 主键
     * @return 实例对象
     */
    @Override
    public Customer queryById(Integer cId) {
        return this.customerDao.queryById(cId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Customer> queryAllByLimit(int offset, int limit) {
        return this.customerDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param customer 实例对象
     * @return 实例对象
     */
    @Override
    public Customer insert(Customer customer) {
        this.customerDao.insert(customer);
        return customer;
    }

    /**
     * 修改数据
     *
     * @param customer 实例对象
     * @return 实例对象
     */
    @Override
    public Customer update(Customer customer) {
        this.customerDao.update(customer);
        return this.queryById(customer.getCId());
    }
    //修改客户我方应收金额
    @Override
    public void updatemoney(double money, int customerid) {
        this.customerDao.updatemoney(money,customerid);
    }

    @Override
    public void updatemoney2(Double dlzonje, Integer customerid) {
        this.customerDao.updatemoney2(dlzonje,customerid);
    }

    /**
     * 通过主键删除数据
     *
     * @param cId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer cId) {
        return this.customerDao.deleteById(cId) > 0;
    }
    @Override
    public Integer deletepl(Integer[] supplierid) {

        return customerDao.pildelsup(supplierid);
    }

    @Override
    public Integer addcustomer(Customer customer) {
        return this.customerDao.insert(customer);
    }

    @Override
    public PageInfo<CustomerVo> khcx(Integer branchid, String cContacts, Integer currentPage, Integer pageSize) {
        List<Customer> list = customerDao.khcx(branchid,cContacts);
        PageHelper.startPage(currentPage,pageSize);
        List<Customer> list2 = customerDao.khcx(branchid,cContacts);
        List<CustomerVo> vos = new ArrayList<>();
        BeanTools.copyList(list2,vos,CustomerVo.class);
        PageInfo<CustomerVo> page = new PageInfo<>(vos);
        page.setTotal((long)list.size());
        System.out.println("分页："+page);
        return page;
    }

    @Override
    public Boolean upsupplier(Customer customer) {
        return customerDao.update(customer);
    }

    /**
     * 新增客户
     */

    /**
     * 楷楷的
     */

}
