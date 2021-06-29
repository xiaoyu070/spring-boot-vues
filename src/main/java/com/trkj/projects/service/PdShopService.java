package com.trkj.projects.service;

import com.trkj.projects.mybatis.entity.BsByShop;
import com.trkj.projects.mybatis.entity.PdShop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PdShop)表服务接口
 *
 * @author makejava
 * @since 2021-06-17 19:07:33
 */
public interface PdShopService {
    int insertBatch(@Param("entities") List<PdShop> entities);
    /**
     * 通过ID查询单条数据
//     *
//     * @param 主键
//     * @return 实例对象
//     */
//    PdShop queryById();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PdShop> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param pdShop 实例对象
     * @return 实例对象
     */
    PdShop insert(PdShop pdShop);

    /**
     * 修改数据
     *
     * @param pdShop 实例对象
     * @return 实例对象
     */
    PdShop update(PdShop pdShop);

    /**
     * 通过主键删除数据
     *
     * @param 主键
     * @return 是否成功
     */
    boolean deleteById();

    int updatepdnumber(Integer pdnum,String pddh);

    /**
     * 删除盘点商品
     * @param delect
     */
    void deleteshop(int delect);

}
