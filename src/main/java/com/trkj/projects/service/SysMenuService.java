package com.trkj.projects.service;


import com.trkj.projects.mybatis.entity.SysMenu;
import com.trkj.projects.mybatis.entity.SysRoles;
import com.trkj.projects.mybatis.entity.SysRolesMenu;
import com.trkj.projects.vo.MenusVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SysMenu)表服务接口
 *
 * @author makejava
 * @since 2021-05-25 09:08:49
 */
public interface SysMenuService {


    List<SysMenu> queryListById(int userid);

    //查询所有菜单
    List<MenusVo> queryMenus();
    //根据角色查询角色对应的菜单
    List<SysMenu> findListByRolesId(SysRoles sysRoles);
    //查询所有菜单
    List<SysMenu> selectMenusall();
    //修改菜单
    void updateMenus(SysMenu sysMenu);
    //修改菜单状态为启用
    void updatemenuszero(int meunsid);
    //修改菜单状态为禁用
    void updatemenusone(int meunsid);
    //根据角色id查询该角色是否存在该菜单id
    List<SysRolesMenu> selectrolesidandmenusid(SysRolesMenu sysRolesMenu);
    //根据角色id新增菜单id的中间表
    void inserrolesidandmenusid(SysRolesMenu sysRolesMenu);
    //根据角色id和对应菜单id删除该角色的指定菜单权限
    void deleterolesidandmenusid(SysRolesMenu sysRolesMenu);
    //根据角色id删除该角色的所有菜单权限
    void deleterolesid(int sysrolesid);
    //批量新增角色菜单中间表
    void addallrolesidandmenusid(@Param("entities") List<SysRolesMenu> entities);
}
