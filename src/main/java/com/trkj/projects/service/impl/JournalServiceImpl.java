package com.trkj.projects.service.impl;

import com.trkj.projects.mybatis.dao.JournalDao;
import com.trkj.projects.mybatis.entity.Journal;
import com.trkj.projects.service.JournalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Journal)表服务实现类
 *
 * @author makejava
 * @since 2021-06-16 23:33:28
 */
@Service("journalService")
public class JournalServiceImpl implements JournalService {
    @Resource
    private JournalDao journalDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Journal queryById(Integer id) {
        return this.journalDao.queryById(id);
    }

    @Override
    public List<Journal> findAll() {
        return this.journalDao.findAll();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Journal> queryAllByLimit(int offset, int limit) {
        return this.journalDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param journal 实例对象
     * @return 实例对象
     */
    @Override
    public Journal insert(Journal journal) {
        this.journalDao.insert(journal);
        return journal;
    }

    /**
     * 修改数据
     *
     * @param journal 实例对象
     * @return 实例对象
     */
    @Override
    public Journal update(Journal journal) {
        this.journalDao.update(journal);
        return this.queryById(journal.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.journalDao.deleteById(id) > 0;
    }
}
