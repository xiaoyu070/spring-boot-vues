package com.trkj.projects.service.impl;


import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.dao.JintuicankaoDao;
import com.trkj.projects.mybatis.entity.Jintuicankao;
import com.trkj.projects.service.JintuicankaoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Jintuicankao)表服务实现类
 *
 * @author makejava
 * @since 2021-06-22 19:56:04
 */
@Service("jintuicankaoService")
public class JintuicankaoServiceImpl implements JintuicankaoService {
    @Resource
    private JintuicankaoDao jintuicankaoDao;

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */
//    @Override
//    public Jintuicankao queryById() {
//        return this.jintuicankaoDao.queryById();
//    }

    @Override
    public Jintuicankao queryById() {
        return null;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Jintuicankao> queryAllByLimit(int offset, int limit) {
        return this.jintuicankaoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param jintuicankao 实例对象
     * @return 实例对象
     */
    @Override
    public Jintuicankao insert(Jintuicankao jintuicankao) {
        this.jintuicankaoDao.insert(jintuicankao);
        return jintuicankao;
    }

    @Override
    public Jintuicankao update(Jintuicankao jintuicankao) {
        return null;
    }

    @Override
    public boolean deleteById() {
        return false;
    }

    @Override
    public PageInfo<Jintuicankao> selectjinhuocangkao(int currentPage, int pageSize) {
        List<Jintuicankao> list =this.jintuicankaoDao.selectjinhuocangkao();
        PageInfo<Jintuicankao> info=new PageInfo<>(list);
        info.setTotal(list.size());
        return info;
    }

    /**
     * 修改
     * @param tuihuo
     * @param sid
     * @return
     */
    @Override
    public int updatecangkao( Integer tuihuo ,String sid ) {

        return this.jintuicankaoDao.updatecangkao(tuihuo,sid);
    }
    /*
    根据商品id删除进货参考
     */
    @Override
    public void deletecangkao(String q) {
        jintuicankaoDao.deletecangkao(q);
    }




}
