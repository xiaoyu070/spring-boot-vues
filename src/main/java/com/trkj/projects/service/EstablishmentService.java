package com.trkj.projects.service;


import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.Establishment;

import java.util.List;

/**
 * (Establishment)表服务接口
 *
 * @author makejava
 * @since 2021-06-06 21:45:48
 */
public interface EstablishmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param xid 主键
     * @return 实例对象
     */
    Establishment queryById(Integer xid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Establishment> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param establishment 实例对象
     * @return 实例对象
     */
    Establishment insert(Establishment establishment);

    /**
     * 修改数据
     *
     * @param establishment 实例对象
     * @return 实例对象
     */
    Establishment update(Establishment establishment);

    /**
     * 通过主键删除数据
     *
     * @param xid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer xid);

    /**
     * 通过店面外键查询银行
     */
    List<Establishment> selectestab(Integer id);

    /**
     * 通过id减少银行金额（给供货商付款）
     */
    void updateestab(Establishment establishment);
    /**
     * 通过id增加银行金额（退货后供货商的实付金额）
     */
    void updateestabjia(Establishment establishment);

    /**
     * 增加银行金额
     * @param
     */
//    void updateestab2(Establishment establishment);

    List<Establishment> selectbybranchid(Integer branchid);


    //-------------------------老弟的
    PageInfo<Establishment> findAll(int pageSize, int size);
    PageInfo<Establishment> findbranchid(int pageSize, int size, Integer branchid);
    Establishment addEstab(Establishment establishment);
    Establishment updataEstab(Establishment establishment);
    void delectEstab(Integer xid);
    public Integer delect(Integer[] xid);
    //查询所有付款账户
    public List<Establishment> finAll();


}
