package com.trkj.projects.service.impl;

import com.trkj.projects.mybatis.entity.BsByType;
import com.trkj.projects.mybatis.dao.BsByTypeDao;
import com.trkj.projects.service.BsByTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsByType)表服务实现类
 *
 * @author makejava
 * @since 2021-06-10 14:54:38
 */
@Service("bsByTypeService")
public class BsByTypeServiceImpl implements BsByTypeService {
    @Resource
    private BsByTypeDao bsByTypeDao;

    /**
     * 报损报溢类型查询
     * @return
     */
    @Override
    public List<BsByType> queryById() {
        return this.bsByTypeDao.queryById();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BsByType> queryAllByLimit(int offset, int limit) {
        return this.bsByTypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bsByType 实例对象
     * @return 实例对象
     */
    @Override
    public BsByType insert(BsByType bsByType) {
        this.bsByTypeDao.insert(bsByType);
        return bsByType;
    }

    @Override
    public BsByType update(BsByType bsByType) {
        return null;
    }


    /**
     * 通过主键删除数据
     *
     * @param bsByByid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bsByByid) {
        return this.bsByTypeDao.deleteById(bsByByid) > 0;
    }
}
