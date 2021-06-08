package com.trkj.projects.service.impl;

import com.trkj.projects.mybatis.dao.SysMenuDao;
import com.trkj.projects.mybatis.entity.SysMenu;
import com.trkj.projects.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysMenu)表服务实现类
 *
 * @author makejava
 * @since 2021-05-25 09:08:49
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SysMenuDao sysMenuDao;

    @Override
    public List<SysMenu> queryListById(int userid) {
        return this.sysMenuDao.findListById(userid);
    }
}
