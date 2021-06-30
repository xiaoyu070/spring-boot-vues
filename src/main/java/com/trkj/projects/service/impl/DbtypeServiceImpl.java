package com.trkj.projects.service.impl;

import com.trkj.projects.mybatis.entity.Dbtype;
import com.trkj.projects.mybatis.dao.DbtypeDao;
import com.trkj.projects.service.DbtypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Dbtype)表服务实现类
 *
 * @author makejava
 * @since 2021-06-28 09:04:48
 */
@Service("dbtypeService")
public class DbtypeServiceImpl implements DbtypeService {
    @Resource
    private DbtypeDao dbtypeDao;





    @Override
    public List<Dbtype> selectdbtype() {
        return this.dbtypeDao.selectdbtype();
    }
}
