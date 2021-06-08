package com.trkj.projects.service.impl;

import com.trkj.projects.mybatis.dao.SysUserDao;
import com.trkj.projects.mybatis.entity.SysUser;
import com.trkj.projects.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public SysUser findByNames(String name,String pass) {
        return this.sysUserDao.findByNames(name,pass);
    }

    @Override
    public SysUser findByPhone(String phone) {
        return this.sysUserDao.findByPhone(phone);
    }
}
