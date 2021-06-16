package com.trkj.projects.service;


import com.trkj.projects.mybatis.entity.SysUser;
import com.trkj.projects.vo.SysUser_roles;

import java.util.List;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2021-05-25 08:54:00
 */
public interface SysUserService {


    SysUser findByNames(String name,String pass);

    /**
     * 根据手机号查询用户
     */
    SysUser findByPhone(String phone);

    /**
     * 根据当前登录的用户查询他的权限
     * @param uid
     * @return
     */
    SysUser_roles findByUser_roles(int uid);
    /**
     * 查询所有用户
     * @return
     */
    List<SysUser_roles> selectuserall();
}
