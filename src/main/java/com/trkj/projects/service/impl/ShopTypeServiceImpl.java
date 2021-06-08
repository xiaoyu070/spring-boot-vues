package com.trkj.projects.service.impl;

import com.trkj.projects.mybatis.dao.ShopTypeDao;
import com.trkj.projects.mybatis.entity.ShopType;
import com.trkj.projects.service.ShopTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ShopType)表服务实现类
 *
 * @author makejava
 * @since 2021-06-01 09:52:44
 */
@Service("shopTypeService")
public class ShopTypeServiceImpl implements ShopTypeService {
    @Resource
    private ShopTypeDao shopTypeDao;


    @Override
    public List<ShopType> queryall() {
        return this.shopTypeDao.queryall();
    }

    /**
     * 新增数据
     *
     * @param shoptype 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(ShopType shoptype) {
        return this.shopTypeDao.insert(shoptype);
    }
    /**
     * 查询所有商品类型
     * @return
     */
    @Override
    public List<ShopType> queryTypeAll() {
        return this.shopTypeDao.queryall();
    }

    /**
     * 修改数据
     *
     * @param shoptype 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(ShopType shoptype) {

        return this.shopTypeDao.update(shoptype);
    }

    /**
     * 通过主键删除数据
     *
     * @param shoptypeid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer shoptypeid) {
        return this.shopTypeDao.deleteById(shoptypeid) > 0;
    }


}
