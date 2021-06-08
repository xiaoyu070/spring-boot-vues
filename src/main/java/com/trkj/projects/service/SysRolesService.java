package com.trkj.projects.service;

import com.trkj.projects.mybatis.entity.SysRoles;

import java.util.List;

/**
 * (SysRoles)表服务接口
 *
 * @author makejava
 * @since 2021-05-25 08:55:23
 */
public interface SysRolesService {

    /**
     * 通过ID查询单条数据
     *
     * @param rolesId 主键
     * @return 实例对象
     */
    SysRoles queryById(Integer rolesId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysRoles> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysRoles 实例对象
     * @return 实例对象
     */
    SysRoles insert(SysRoles sysRoles);

    /**
     * 修改数据
     *
     * @param sysRoles 实例对象
     * @return 实例对象
     */
    SysRoles update(SysRoles sysRoles);

    /**
     * 通过主键删除数据
     *
     * @param rolesId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer rolesId);

}
