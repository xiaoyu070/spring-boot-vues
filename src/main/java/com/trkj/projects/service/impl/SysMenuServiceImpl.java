package com.trkj.projects.service.impl;

import com.trkj.projects.mybatis.dao.SysMenuDao;
import com.trkj.projects.mybatis.entity.SysMenu;
import com.trkj.projects.mybatis.entity.SysRoles;
import com.trkj.projects.mybatis.entity.SysRolesMenu;
import com.trkj.projects.service.SysMenuService;
import com.trkj.projects.vo.MenusVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysMenu)表服务实现类
 *
 * @author makejava
 * @since 2021-05-25 09:08:49
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SysMenuDao sysMenuDao;

    @Override
    public List<SysMenu> queryListById(int userid) {
        return this.sysMenuDao.findListById(userid);
    }

    @Override
    public List<MenusVo> queryMenus() {
        return this.sysMenuDao.queryMenus();
    }

    @Override
    public List<SysMenu> findListByRolesId(SysRoles sysRoles) {
        return this.sysMenuDao.findListByRolesId(sysRoles);
    }

    @Override
    public List<SysMenu> selectMenusall() {
        return this.sysMenuDao.selectMenusall();
    }

    @Override
    public void updateMenus(SysMenu sysMenu) {
        this.sysMenuDao.updateMenus(sysMenu);
    }

    @Override
    public void updatemenuszero(int meunsid) {
        this.sysMenuDao.updatemenuszero(meunsid);
    }

    @Override
    public void updatemenusone(int meunsid) {
        this.sysMenuDao.updatemenusone(meunsid);
    }

    @Override
    public List<SysRolesMenu> selectrolesidandmenusid(SysRolesMenu sysRolesMenu) {
        return this.sysMenuDao.selectrolesidandmenusid(sysRolesMenu);
    }

    @Override
    public void inserrolesidandmenusid(SysRolesMenu sysRolesMenu) {
        this.sysMenuDao.inserrolesidandmenusid(sysRolesMenu);
    }

    @Override
    public void deleterolesidandmenusid(SysRolesMenu sysRolesMenu) {
        this.sysMenuDao.deleterolesidandmenusid(sysRolesMenu);
    }

    @Override
    public void deleterolesid(int sysrolesid) {
        this.sysMenuDao.deleterolesid(sysrolesid);
    }

    @Override
    public void addallrolesidandmenusid(@Param("entities")List<SysRolesMenu> entities) {
        this.sysMenuDao.addallrolesidandmenusid(entities);
    }
}
