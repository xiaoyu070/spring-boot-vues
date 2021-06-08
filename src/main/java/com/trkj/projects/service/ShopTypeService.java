package com.trkj.projects.service;


import com.trkj.projects.mybatis.entity.ShopType;

import java.util.List;

/**
 * (ShopType)表服务接口
 *
 * @author makejava
 * @since 2021-06-01 09:52:44
 */
public interface ShopTypeService {

    /**
     * 查询商品类型表中的所有类型
     */
    List<ShopType> queryall();


    List<ShopType> queryTypeAll();

    /**
     * 新增数据
     *
     * @param shoptype 实例对象
     * @return 实例对象
     */
    Integer insert(ShopType shoptype);

    /**
     * 修改数据
     *
     * @param shoptype 实例对象
     * @return 实例对象
     */
    Integer update(ShopType shoptype);

    /**
     * 通过主键删除数据
     *
     * @param shoptypeid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer shoptypeid);

}
