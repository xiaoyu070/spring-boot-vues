package com.trkj.projects.mybatis.entity;

import java.io.Serializable;

/**
 * (SysRolesMenu)实体类
 *
 * @author makejava
 * @since 2021-05-25 09:07:05
 */
public class SysRolesMenu implements Serializable {
    private static final long serialVersionUID = -89508861659355504L;
    /**
     * 角色id
     */
    private Integer sysRolesId;
    /**
     * 菜单id
     */
    private Integer sysMenuId;


    public Integer getSysRolesId() {
        return sysRolesId;
    }

    public void setSysRolesId(Integer sysRolesId) {
        this.sysRolesId = sysRolesId;
    }

    public Integer getSysMenuId() {
        return sysMenuId;
    }

    public void setSysMenuId(Integer sysMenuId) {
        this.sysMenuId = sysMenuId;
    }

}
