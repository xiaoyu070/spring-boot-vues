package com.trkj.projects.service;

import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.Jintuicankao;
import com.trkj.projects.mybatis.entity.Jintuicankaoa;

import java.util.List;

/**
 * (Jintuicankaoa)表服务接口
 *
 * @author makejava
 * @since 2021-06-28 18:41:39
 */
public interface JintuicankaoaService {




    /**
     * 新增数据
     *
     * @param jintuicankaoa 实例对象
     * @return 实例对象
     */
    Jintuicankaoa insert(Jintuicankaoa jintuicankaoa);

    PageInfo<Jintuicankaoa> selectjinhuocangkao1(int currentPage, int pageSize);

    int updatecangkao1(Integer tuihuo ,String sid );
    void deletecangkao1(String q);

}
