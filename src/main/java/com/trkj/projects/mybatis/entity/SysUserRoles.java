package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (SysUserRoles)实体类
 *
 * @author makejava
 * @since 2021-05-25 09:06:33
 */
@Data
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
}
