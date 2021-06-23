package com.trkj.projects.service;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.projects.anntation.Log;
import com.trkj.projects.mybatis.entity.SysRoles;
import com.trkj.projects.mybatis.entity.SysUser;
import com.trkj.projects.vo.SysUser_roles;
import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2021-05-25 08:54:00
 */
public interface SysUserService {

    //新增用户
    void insertuser(SysUser sysUser);
    /**
     * 根据用户名称查询用户
     * @param sysUser
     * @return
     */
    SysUser findByNames(SysUser sysUser);

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
     * 查询所有用户vo
     * @return
     */
    List<SysUser_roles> selectuserall();
    

    //修改用户状态为0
    void updateuserstatezero(int id);
    //修改用户状态为1
    void updateuserstateone(int id);
    //修改用户
    void updateusers(SysUser sysUser);
    //根据用户id修改用户对应的角色id
    void updateuserandroles(@Param("rolesid") int rolesid, @Param("userid") int userid);
    //修改用户状态为1(删除)
    void deleteuserid(int userid);
    //修改用户最后登录时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    void updateerror(Date date, int userid);
}
