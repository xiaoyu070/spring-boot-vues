package com.trkj.projects.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.dao.EstablishmentDao;
import com.trkj.projects.mybatis.entity.Establishment;
import com.trkj.projects.service.EstablishmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Establishment)表服务实现类
 *
 * @author makejava
 * @since 2021-06-06 21:45:48
 */
@Service("establishmentService")
public class EstablishmentServiceImpl implements EstablishmentService {
    @Resource
    private EstablishmentDao establishmentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param xid 主键
     * @return 实例对象
     */
    @Override
    public Establishment queryById(Integer xid) {
        return this.establishmentDao.queryById(xid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Establishment> queryAllByLimit(int offset, int limit) {
        return this.establishmentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param establishment 实例对象
     * @return 实例对象
     */
    @Override
    public Establishment insert(Establishment establishment) {
        this.establishmentDao.insert(establishment);
        return establishment;
    }

    /**
     * 修改数据
     *
     * @param establishment 实例对象
     * @return 实例对象
     */
    @Override
    public Establishment update(Establishment establishment) {
        this.establishmentDao.update(establishment);
        return this.queryById(establishment.getXid());
    }

    /**
     * 通过主键删除数据
     *
     * @param xid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer xid) {
        return this.establishmentDao.deleteById(xid) > 0;
    }

    @Override
    public List<Establishment> selectestab(Integer id) {
        return this.establishmentDao.selectestab(id);
    }

    @Override
    public void updateestab(Establishment establishment) {
        this.establishmentDao.updateestab(establishment);
    }

    @Override
    public List<Establishment> selectbybranchid(Integer branchid) {
        return this.establishmentDao.selectbybranchid(branchid);
    }

    //----------------------------------------老弟的
//查询所有
    public PageInfo<Establishment> findAll(int pageSize, int size) {
        List<Establishment> list=this.establishmentDao.selectByAll();
        //封装分页插件
        PageHelper.startPage(pageSize,size);
        //再查所有最终传过去的数据
        List<Establishment> list2 = this.establishmentDao.selectByAll();
        //封装到pageinfo再设置总条数获取第一个list的大小size()方法
        PageInfo<Establishment> info = new PageInfo<>(list2);
        info.setTotal(list.size());
        System.out.println("--------------"+list);
        return info;
    }
    //分店查询
    @Override
    public PageInfo<Establishment> findbranchid(int pageSize, int size,Integer branchid) {
        List<Establishment> list = this.establishmentDao.selectByBrachid(branchid);
        PageHelper.startPage(pageSize,size);
        List<Establishment> list2 = this.establishmentDao.selectByBrachid(branchid);
        //封装到pageinfo再设置总条数获取第一个list的大小size()方法
        PageInfo<Establishment> info = new PageInfo<>(list2);
        info.setTotal(list.size());
        System.out.println("--------------"+list);
        return info;
    }
    //添加银行
    @Override
    public Establishment addEstab(Establishment establishment) {
        this.establishmentDao.insert(establishment);
        return establishment;
    }
    //修改
    @Override
    public Establishment updataEstab(Establishment establishment) {
        this.establishmentDao.updateByPrimaryKey(establishment);
        return establishment;
    }

    @Override
    public void delectEstab(Integer xid) {
        this.establishmentDao.deleteByPrimaryKey(xid);
    }

    @Override
    public Integer delect(Integer[] xid) {
        return this.establishmentDao.delete(xid);
    }

    @Override
    public List<Establishment> finAll() {
        return establishmentDao.selectByAll();
    }

}
