package com.trkj.projects.service.impl;

import com.trkj.projects.mybatis.dao.SysRolesDao;
import com.trkj.projects.mybatis.entity.SysRoles;
import com.trkj.projects.service.SysRolesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysRoles)表服务实现类
 *
 * @author makejava
 * @since 2021-05-25 08:55:23
 */
@Service("sysRolesService")
public class SysRolesServiceImpl implements SysRolesService {
    @Resource
    private SysRolesDao sysRolesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param rolesId 主键
     * @return 实例对象
     */
    @Override
    public SysRoles queryById(Integer rolesId) {
        return this.sysRolesDao.queryById(rolesId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SysRoles> queryAllByLimit(int offset, int limit) {
        return this.sysRolesDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysRoles 实例对象
     * @return 实例对象
     */
    @Override
    public SysRoles insert(SysRoles sysRoles) {
        this.sysRolesDao.insert(sysRoles);
        return sysRoles;
    }

    /**
     * 修改数据
     *
     * @param sysRoles 实例对象
     * @return 实例对象
     */
    @Override
    public SysRoles update(SysRoles sysRoles) {
        this.sysRolesDao.update(sysRoles);
        return this.queryById(sysRoles.getRolesId());
    }

    /**
     * 通过主键删除数据
     *
     * @param rolesId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer rolesId) {
        return this.sysRolesDao.deleteById(rolesId) > 0;
    }
}
