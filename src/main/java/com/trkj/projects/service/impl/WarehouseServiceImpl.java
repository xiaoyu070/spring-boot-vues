package com.trkj.projects.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.dao.WarehouseDao;
import com.trkj.projects.mybatis.entity.Warehouse;
import com.trkj.projects.service.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Warehouse)表服务实现类
 *
 * @author makejava
 * @since 2021-05-31 20:00:17
 */
@Slf4j
@Service("warehouseService")
public class WarehouseServiceImpl implements WarehouseService {
    @Resource
    private WarehouseDao warehouseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param wid 主键
     * @return 实例对象
     */
    @Override
    public Warehouse queryById(Integer wid) {
        return this.warehouseDao.queryById(wid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Warehouse> queryAllByLimit(int offset, int limit) {
        return this.warehouseDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param warehouse 实例对象
     * @return 实例对象
     */
    @Override
    public Warehouse insert(Warehouse warehouse) {
        this.warehouseDao.insert(warehouse);
        return warehouse;
    }

    /**
     * 修改数据
     *
     * @param warehouse 实例对象
     * @return 实例对象
     */
    @Override
    public Warehouse update(Warehouse warehouse) {
        this.warehouseDao.update(warehouse);
        return this.queryById(warehouse.getWid());
    }

    /**
     * 通过主键删除数据
     *
     * @param wid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer wid) {
        return this.warehouseDao.deleteById(wid) > 0;
    }

    @Override
    public List<Warehouse> selectall() {
        return this.warehouseDao.selectall();
    }

    @Override
    public List<Warehouse> selectbranchid(int id) {
        return this.warehouseDao.selectbranchid(id);
    }

    @Override
    public List<Warehouse> queryBybranId(Integer branchid) {
        return this.warehouseDao.queryBybranchid(branchid);
    }

    //---------------------------------------老弟的

    //添加
    @Override
    public Warehouse addWarehouse(Warehouse warehouse) {
        warehouseDao.insert(warehouse);
        return warehouse;
    }
    @Override
    public Integer deleteWarehouse(Integer[] wid) {
        log.debug(wid.toString());
        return warehouseDao.deleteWarehouseId(wid);
    }
    //修改
    @Override
    public Warehouse updateWarehouse(Warehouse warehouse) {
        warehouseDao.updateByPrimaryKey(warehouse);
        return warehouse;
    }
    //分店查询
    @Override
    public PageInfo<Warehouse> findbranchid(int pageSize, int size, Integer branchid) {
        List<Warehouse> list = this.warehouseDao.selectByBrachid(branchid);
        PageHelper.startPage(pageSize,size);
        List<Warehouse> list2 = this.warehouseDao.selectByBrachid(branchid);
        //封装到pageinfo再设置总条数获取第一个list的大小size()方法
        PageInfo<Warehouse> info = new PageInfo<>(list2);
        info.setTotal(list.size());
        System.out.println("--------------"+list);
        return info;
    }
    //模糊查询
    @Override
    public PageInfo<Warehouse> findMohu(int pageSize, int size, String wname) {
        List<Warehouse> list = this.warehouseDao.selectMohu(wname);
        PageHelper.startPage(pageSize,size);
        List<Warehouse> list2 = this.warehouseDao.selectMohu(wname);
        //封装到pageinfo再设置总条数获取第一个list的大小size()方法
        PageInfo<Warehouse> info = new PageInfo<>(list2);
        info.setTotal(list.size());
        System.out.println("--------------"+list);
        return info;
    }

    //------------------------------一哥的
    @Override
    public List<Warehouse> queryWarehouse(int id) {
        return this.warehouseDao.queryWarehouse(id);
    }

    @Override
    public List<Warehouse> findAll(){
        return this.warehouseDao.findAll();
    }

}
