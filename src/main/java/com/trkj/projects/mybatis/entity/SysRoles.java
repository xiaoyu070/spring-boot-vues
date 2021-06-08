package com.trkj.projects.mybatis.entity;

import java.io.Serializable;

/**
 * (SysRoles)实体类
 *
 * @author makejava
 * @since 2021-05-25 08:55:06
 */
public class SysRoles implements Serializable {
    private static final long serialVersionUID = -35611825193752235L;
    /**
     * 角色id
     */
    private Integer rolesId;
    /**
     * 角色权限等级0为最高
     */
    private Integer rolesLv;
    /**
     * 角色名称
     */
    private String rolesName;
    /**
     * 菜单id
     */
    private Integer menuId;


    public Integer getRolesId() {
        return rolesId;
    }

    public void setRolesId(Integer rolesId) {
        this.rolesId = rolesId;
    }

    public Integer getRolesLv() {
        return rolesLv;
    }

    public void setRolesLv(Integer rolesLv) {
        this.rolesLv = rolesLv;
    }

    public String getRolesName() {
        return rolesName;
    }

    public void setRolesName(String rolesName) {
        this.rolesName = rolesName;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

}
