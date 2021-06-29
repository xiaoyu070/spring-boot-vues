package com.trkj.projects.service.impl;

import com.trkj.projects.mybatis.dao.BsByShopDao;
import com.trkj.projects.mybatis.entity.BsByShop;
import com.trkj.projects.service.BsByShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsByShop)表服务实现类
 *
 * @author makejava
 * @since 2021-06-12 20:50:36
 */
@Service("bsByShopService")
public class BsByShopServiceImpl implements BsByShopService {
    @Resource
    private BsByShopDao bsByShopDao;

    @Override
    public int insertBatch(List<BsByShop> entities) {

        return this.bsByShopDao.insertBatch(entities);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BsByShop queryById(Integer id) {
        return this.bsByShopDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BsByShop> queryAllByLimit(int offset, int limit) {
        return this.bsByShopDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bsByShop 实例对象
     * @return 实例对象
     */
    @Override
    public BsByShop insert(BsByShop bsByShop) {
        this.bsByShopDao.insert(bsByShop);
        return bsByShop;
    }

    /**
     * 修改数据
     *
     * @param bsByShop 实例对象
     * @return 实例对象
     */
    @Override
    public BsByShop update(BsByShop bsByShop) {
        this.bsByShopDao.update(bsByShop);
        return this.queryById(bsByShop.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.bsByShopDao.deleteById(id) > 0;
    }

    @Override
    public int insertOrUpdateBatch(List<BsByShop> entities) {

        return this.bsByShopDao.insertBatch(entities);
    }
}
