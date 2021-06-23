package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (SysRoles)实体类
 *
 * @author makejava
 * @since 2021-05-25 08:55:06
 */
@Data
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
     * 角色备注
     * @return
     */
    private String roles_beizhu;
}
