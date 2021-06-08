package com.trkj.projects.service;


import com.trkj.projects.mybatis.entity.SysUser;

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
}
