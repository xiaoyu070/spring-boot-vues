package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.SysUser;
import com.trkj.projects.vo.SysUser_roles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-25 08:53:20
 */
@Mapper
public interface SysUserDao {
    /**
     * 根据账户密码查询用户
     * @param name
     * @param pass
     * @return
     */
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

