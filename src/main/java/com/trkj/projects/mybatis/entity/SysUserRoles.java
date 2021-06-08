package com.trkj.projects.mybatis.entity;

import java.io.Serializable;

/**
 * (SysUserRoles)实体类
 *
 * @author makejava
 * @since 2021-05-25 09:06:33
 */
public class SysUserRoles implements Serializable {
    private static final long serialVersionUID = 511300688531560427L;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 角色id
     */
    private Integer rolesId;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRolesId() {
        return rolesId;
    }

    public void setRolesId(Integer rolesId) {
        this.rolesId = rolesId;
    }

}
