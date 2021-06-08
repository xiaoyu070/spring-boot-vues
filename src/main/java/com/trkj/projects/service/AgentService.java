package com.trkj.projects.service;

import com.trkj.projects.mybatis.entity.Agent;

import java.util.List;

/**
 * (Agent)表服务接口
 *
 * @author makejava
 * @since 2021-06-03 18:50:18
 */
public interface AgentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Agent queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Agent> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param agent 实例对象
     * @return 实例对象
     */
    Agent insert(Agent agent);

    /**
     * 修改数据
     *
     * @param agent 实例对象
     * @return 实例对象
     */
    Agent update(Agent agent);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 根据店面外键查询经办人
     */
    List<Agent> querybyBranchid(int id);

    List<Agent> selectallbybranchid(Integer branchid);
}
