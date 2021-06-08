package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.SysUser;
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
}

