package com.trkj.projects.service;

import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.Supplier;
import com.trkj.projects.vo.SupplierVo;

import java.util.List;

/**
 * (Supplier)表服务接口
 *
 * @author makejava
 * @since 2021-06-01 11:05:42
 */
public interface SupplierService {

    /**
     * 通过ID查询单条数据
     *
     * @param sId 主键
     * @return 实例对象
     */
    Supplier queryById(Integer sId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Supplier> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param supplier 实例对象
     * @return 实例对象
     */
    Supplier insert(Supplier supplier);

    /**
     * 修改数据
     *
     * @param supplier 实例对象
     * @return 实例对象
     */
    Supplier update(Supplier supplier);

    /**
     * 通过主键删除数据
     *
     * @param sId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer sId);

    List<Supplier> queryall();


    PageInfo<SupplierVo> findAllPage(Integer currentPage, Integer pageSize);
    PageInfo<SupplierVo> findAllByName(String branchnames,String suppliername,Integer currentPage, Integer pageSize);
    Integer addsupplier(Supplier supplier);

    Boolean upsupplier(Supplier supplier);

    Integer deletepl(Integer[] supplierid);


    /**
     * 单据号审核通过后，该单据中包含的商品根据供应商将采购付款一一对应加入到供货商的初期余额中
     */
    void numbersmoney(double money,int supplierid);

    /**
     * 退货单据审核通过后，该单据中包含的商品根据提供的供应商id将退货实际收款一一对应并减少供货商的初期余额
     */
    void numbersmoneyjian(double money,int supplierid);
}
