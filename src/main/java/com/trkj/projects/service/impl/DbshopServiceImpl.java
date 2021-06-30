package com.trkj.projects.service.impl;

import com.trkj.projects.mybatis.entity.Dbshop;
import com.trkj.projects.mybatis.dao.DbshopDao;
import com.trkj.projects.service.DbshopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Dbshop)表服务实现类
 *
 * @author makejava
 * @since 2021-06-28 11:39:35
 */
@Service("dbshopService")
public class DbshopServiceImpl implements DbshopService {
    @Resource
    private DbshopDao dbshopDao;

    /**
     * 通过ID查询单条数据
     *     */

    @Override
    public Dbshop insert(Dbshop dbshop) {
        this.dbshopDao.insert(dbshop);
        return dbshop;
    }

    @Override
    public Dbshop update(Dbshop dbshop) {
        return null;
    }

    @Override
    public int insertBatch(List<Dbshop> entities) {
        return this.dbshopDao.insertBatch(entities);
    }

}
