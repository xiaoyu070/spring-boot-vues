package com.trkj.projects.service.impl;

import com.github.pagehelper.PageInfo;

import com.trkj.projects.mybatis.entity.Jintuicankaoa;
import com.trkj.projects.mybatis.dao.JintuicankaoaDao;
import com.trkj.projects.service.JintuicankaoaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Jintuicankaoa)表服务实现类
 *
 * @author makejava
 * @since 2021-06-28 18:41:39
 */
@Service("jintuicankaoaService")
public class JintuicankaoaServiceImpl implements JintuicankaoaService {
    @Resource
    private JintuicankaoaDao jintuicankaoaDao;

    /**
     * 新增数据
     *
     * @param jintuicankaoa 实例对象
     * @return 实例对象
     */
    @Override
    public Jintuicankaoa insert(Jintuicankaoa jintuicankaoa) {
        this.jintuicankaoaDao.insert(jintuicankaoa);
        return jintuicankaoa;
    }

    @Override
    public PageInfo<Jintuicankaoa> selectjinhuocangkao1(int currentPage, int pageSize) {
            List<Jintuicankaoa> list=this.jintuicankaoaDao.selectjinhuocangkao1();
            PageInfo<Jintuicankaoa> info=new PageInfo<>(list);
            info.setTotal(list.size());
            return info;
    }

    @Override
    public int updatecangkao1(Integer tuihuo, String sid) {
        return this.jintuicankaoaDao.updatecangkao1(tuihuo,sid);
    }

    @Override
    public void deletecangkao1(String q) {
        jintuicankaoaDao.deletecangkao1(q);
    }


}
