package com.trkj.projects.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.dao.SupplierDao;
import com.trkj.projects.mybatis.entity.Supplier;
import com.trkj.projects.service.SupplierService;
import com.trkj.projects.util.BeanTools;
import com.trkj.projects.vo.SupplierVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Supplier)表服务实现类
 *
 * @author makejava
 * @since 2021-06-01 11:05:42
 */
@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {
    @Resource
    private SupplierDao supplierDao;

    /**
     * 通过ID查询单条数据
     *
     * @param sId 主键
     * @return 实例对象
     */
    @Override
    public Supplier queryById(Integer sId) {
        return this.supplierDao.queryById(sId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Supplier> queryAllByLimit(int offset, int limit) {
        return this.supplierDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param supplier 实例对象
     * @return 实例对象
     */
    @Override
    public Supplier insert(Supplier supplier) {
        this.supplierDao.insert(supplier);
        return supplier;
    }

    /**
     * 修改数据
     *
     * @param supplier 实例对象
     * @return 实例对象
     */
    @Override
    public Supplier update(Supplier supplier) {
        this.supplierDao.update(supplier);
        return this.queryById(supplier.getSId());
    }

    /**
     * 通过主键删除数据
     *
     * @param sId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer sId) {
        return this.supplierDao.deleteById(sId) > 0;
    }

    @Override
    public List<Supplier> queryall() {
        return this.supplierDao.queryall();
    }



    /**
     * 供货商，供货商类型，供货商所属地区，所属分店的链表查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<SupplierVo> findAllPage(Integer currentPage, Integer pageSize) {
        List<Supplier> list = supplierDao.findAll();
        Page<Supplier> page= PageHelper.startPage(currentPage,pageSize,true);
        List<Supplier> list2 = supplierDao.findAll();
        List<SupplierVo> vos = new ArrayList<>();
        BeanTools.copyList(list2,vos,SupplierVo.class);
        PageInfo<SupplierVo> info = new PageInfo<>(vos);
        info.setTotal((long)list.size());
        return info;
    }

    /**
     * 根据分店类型和关键字查询
     * //@param branchid
     * //@param suppliername
     * @return
     */
    @Override
    public PageInfo<SupplierVo> findAllByName(String branchnames, String suppliername, Integer currentPage, Integer pageSize) {
        List<Supplier> list = supplierDao.findAllByName(branchnames,suppliername);
        Page<Supplier> page = PageHelper.startPage(currentPage,pageSize,true);
        List<Supplier> list2 = supplierDao.findAllByName(branchnames,suppliername);
        List<SupplierVo> vos = new ArrayList<>();
        BeanTools.copyList(list2,vos,SupplierVo.class);
        PageInfo<SupplierVo> info = new PageInfo<>(vos);
        info.setTotal((long)list.size());
        return info;
    }

    /**
     * 添加供货商
     * @param supplier
     * @return
     */
    @Override
    public Integer addsupplier(Supplier supplier) {
        return this.supplierDao.insert(supplier);
    }

    /**
     * 修改供货商
     * @param supplier
     * @return
     */
    @Override
    public Boolean upsupplier(Supplier supplier) {

        return supplierDao.update(supplier);
    }

    /**
     * 批量删除数据
     * @param supplierid
     * @return
     */
    @Override
    public Integer deletepl(Integer[] supplierid) {

        return supplierDao.pildelsup(supplierid);
    }

    @Override
    public void numbersmoney(double money, int supplierid) {
        this.supplierDao.numbersmoney(money,supplierid);
    }

}
