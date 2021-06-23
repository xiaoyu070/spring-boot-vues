package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.SysMenu;
import com.trkj.projects.mybatis.entity.SysRoles;
import com.trkj.projects.mybatis.entity.SysRolesMenu;
import com.trkj.projects.vo.MenusVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (SysMenu)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-25 09:08:34
 */
@Mapper
public interface SysMenuDao {

    //根据角色id查询该角色是否存在该菜单id
    List<SysRolesMenu> selectrolesidandmenusid(SysRolesMenu sysRolesMenu);

    //根据登录的角色查询他可用的菜单
    List<SysMenu> findListById(int userid);

    //查询所有tree菜单
    List<MenusVo> queryMenus();
    //查询所有菜单
    List<SysMenu> selectMenusall();

    //根据角色查询角色对应的菜单
    List<SysMenu> findListByRolesId(SysRoles sysRoles);
    //修改菜单
    void updateMenus(SysMenu sysMenu);

    //根据角色id新增菜单id的中间表
    void inserrolesidandmenusid(SysRolesMenu sysRolesMenu);

    //根据角色id和对应菜单id删除该角色的指定菜单权限
    void deleterolesidandmenusid(SysRolesMenu sysRolesMenu);
}

