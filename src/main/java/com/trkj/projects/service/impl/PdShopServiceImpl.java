package com.trkj.projects.service.impl;

import com.trkj.projects.mybatis.entity.PdShop;
import com.trkj.projects. mybatis.dao.PdShopDao;
import com.trkj.projects.service.PdShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PdShop)表服务实现类
 *
 * @author makejava
 * @since 2021-06-17 19:07:35
 */
@Service("pdShopService")
public class PdShopServiceImpl implements PdShopService {
    @Resource
    private PdShopDao pdShopDao;

    @Override
    public int insertBatch(List<PdShop> entities) {
        return pdShopDao.insertBatch(entities);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
//    @Override
//    public PdShop queryById() {
//        return this.pdShopDao.queryById();
//    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<PdShop> queryAllByLimit(int offset, int limit) {
        return this.pdShopDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param pdShop 实例对象
     * @return 实例对象
     */
    @Override
    public PdShop insert(PdShop pdShop) {
        System.out.println("in service  "+pdShop);
        this.pdShopDao.insert(pdShop);
        return pdShop;
    }

    @Override
    public PdShop update(PdShop pdShop) {
        return null;
    }

    @Override
    public boolean deleteById() {
        return false;
    }


    /**
     * 修改盘点商品盘点数量
     * @param pdnum
     * @param pddh
     * @return
     */
    @Override
    public int updatepdnumber(Integer pdnum, String pddh) {
        return this.pdShopDao.updatepdnumber(pdnum,pddh);
    }

    @Override
    public void deleteshop(int delect) {
        pdShopDao.delectshop(delect);
    }
}
