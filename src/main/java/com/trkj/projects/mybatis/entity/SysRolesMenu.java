package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (SysRolesMenu)实体类
 *
 * @author makejava
 * @since 2021-05-25 09:07:05
 */
@Data
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

}
