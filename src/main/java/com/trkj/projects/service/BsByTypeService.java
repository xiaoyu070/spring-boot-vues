package com.trkj.projects.service;

import com.trkj.projects.mybatis.entity.BsByType;

import java.util.List;

/**
 * (BsByType)表服务接口
 *
 * @author makejava
 * @since 2021-06-10 14:54:38
 */
public interface BsByTypeService {




    /**
     * 报损报溢类型查询
     *
     * @return 实例对象
     */
    List<BsByType> queryById();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BsByType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bsByType 实例对象
     * @return 实例对象
     */
    BsByType insert(BsByType bsByType);

    /**
     * 修改数据
     *
     * @param bsByType 实例对象
     * @return 实例对象
     */
    BsByType update(BsByType bsByType);

    /**
     * 通过主键删除数据
     *
     * @param bsByByid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer bsByByid);

}
