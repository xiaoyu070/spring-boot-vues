package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.SysRoles;
import com.trkj.projects.mybatis.entity.SysUserRoles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SysRoles)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-25 08:55:06
 */
@Mapper
public interface SysRolesDao {

    //新增角色
    void insertroles(SysRoles sysRoles);
    /**
     * 查询所有
     * @return
     */
    List<SysRoles> selectall();
    /**
     * 通过ID查询单条数据
     *
     * @param rolesId 主键
     * @return 实例对象
     */
    SysRoles queryById(Integer rolesId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysRoles> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysRoles 实例对象
     * @return 对象列表
     */
    List<SysRoles> queryAll(SysRoles sysRoles);

    /**
     * 新增数据
     *
     * @param sysRoles 实例对象
     * @return 影响行数
     */
    int insert(SysRoles sysRoles);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysRoles> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysRoles> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysRoles> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SysRoles> entities);

    /**
     * 修改数据
     *
     * @param sysRoles 实例对象
     * @return 影响行数
     */
    int update(SysRoles sysRoles);

    /**
     * 通过主键删除数据
     *
     * @param rolesId 主键
     * @return 影响行数
     */
    int deleteById(Integer rolesId);

    //删除角色前先查询该角色下是否存在用户
    List<SysUserRoles> selectuseranroles(Integer rolesId);

    //模糊查询角色
    List<SysRoles> likeroles(String rolestext);

    //根据userid查询对应的所有角色
    List<SysRoles> findbyuseridroles(int userid);
}

