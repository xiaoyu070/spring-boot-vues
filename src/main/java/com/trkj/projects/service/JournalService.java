package com.trkj.projects.service;


import com.trkj.projects.mybatis.entity.Journal;
import com.trkj.projects.vo.JournalVo;

import java.util.List;

/**
 * (Journal)表服务接口
 *
 * @author makejava
 * @since 2021-06-16 23:33:27
 */
public interface JournalService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Journal queryById(Integer id);
    /**
     * 查询全部
     */
    List<Journal> findAll();
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Journal> queryAllByLimit(int offset, int limit);
    /**
     * 根据时间查询日志
     */
    List<JournalVo> selectdates(String createDate);
    /**
     * 新增数据
     *
     * @param journal 实例对象
     * @return 实例对象
     */
    Journal insert(Journal journal);
    /**
     * 根据userid查询
     */
    List<Journal> findByuserId(int userid);
    /**
     * 修改数据
     *
     * @param journal 实例对象
     * @return 实例对象
     */
    Journal update(Journal journal);
    /**
     * 模糊查询
     */
    List<Journal> findAlllike(String text);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
