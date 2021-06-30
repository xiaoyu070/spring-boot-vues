package com.trkj.projects.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.Dbdanju;
import com.trkj.projects.mybatis.dao.DbdanjuDao;
import com.trkj.projects.service.DbdanjuService;
import com.trkj.projects.vo.DbdanjuVo;
import com.trkj.projects.vo.StockVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Dbdanju)表服务实现类
 *
 * @author makejava
 * @since 2021-06-28 11:31:41
 */
@Service("dbdanjuService")
public class DbdanjuServiceImpl implements DbdanjuService {
    @Resource
    private DbdanjuDao dbdanjuDao;

    /**
     * 新增数据
     *
     * @param dbdanju 实例对象
     * @return 实例对象
     */
    @Override
    public Dbdanju insert(Dbdanju dbdanju) {
        this.dbdanjuDao.insert(dbdanju);
        return dbdanju;
    }

    @Override
    public List<DbdanjuVo> selectdbcx() {
        return this.dbdanjuDao.selectdbcx11();
    }


}
