package com.trkj.projects.service.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trkj.projects.mybatis.dao.SysUserDao;
import com.trkj.projects.mybatis.entity.SysRoles;
import com.trkj.projects.mybatis.entity.SysUser;
import com.trkj.projects.service.SysUserService;
import com.trkj.projects.vo.SysUser_roles;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2021-05-25 08:54:00
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;


    @Override
    public void insertuser(SysUser sysUser) {
        this.sysUserDao.insertuser(sysUser);
    }

    @Override
    public SysUser findByNames(SysUser s) {
        return this.sysUserDao.findByNames(s);
    }

    @Override
    public SysUser findByUid(int id) {
        return this.sysUserDao.findByUid(id);
    }

    @Override
    public SysUser findByPhone(String phone) {
        return this.sysUserDao.findByPhone(phone);
    }

    @Override
    public SysUser findByName(String userName) {
        return this.sysUserDao.findByName(userName);
    }

    @Override
    public SysUser_roles findByUser_roles(int uid) {
        return this.sysUserDao.findByUser_roles(uid);
    }

    @Override
    public List<SysUser_roles> selectuserall() {
        return this.sysUserDao.selectuserall();
    }

    @Override
    public void updateuserstatezero(int id) {
        this.sysUserDao.updateuserstatezero(id);
    }

    @Override
    public void updateuserstateone(int id) {
        this.sysUserDao.updateuserstateone(id);
    }

    @Override
    public void updateusers(SysUser sysUser) {
        this.sysUserDao.updateusers(sysUser);
    }

    @Override
    public void updateuserandroles(int rolesid, int userid) {
        this.sysUserDao.updateuserandroles(rolesid,userid);
    }

    @Override
    public void insertuserandroles(int userid, int rolesid) {
        this.sysUserDao.insertuserandroles(userid,rolesid);
    }

    @Override
    public void deleteuserandroles(int userid) {
        this.sysUserDao.deleteuserandroles(userid);
    }


    @Override
    public void deleteuserid(int userid) {
        this.sysUserDao.deleteuserid(userid);
    }

    @Override
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void updateerror(Date date, int userid) {
        this.sysUserDao.updateerror(date,userid);
    }

    @Override
    public List<SysUser> likeusers(String ttt) {
        return this.sysUserDao.likeusers(ttt);
    }


}
