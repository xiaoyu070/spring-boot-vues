package com.trkj.projects.service;

import com.trkj.projects.mybatis.entity.BsByShop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BsByShop)表服务接口
 *
 * @author makejava
 * @since 2021-06-12 20:50:36
 */
public interface BsByShopService {
    int insertBatch(@Param("entities") List<BsByShop> entities);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BsByShop queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BsByShop> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bsByShop 实例对象
     * @return 实例对象
     */
    BsByShop insert(BsByShop bsByShop);

    /**
     * 修改数据
     *
     * @param bsByShop 实例对象
     * @return 实例对象
     */
    BsByShop update(BsByShop bsByShop);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BsByShop> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<BsByShop> entities);


}
