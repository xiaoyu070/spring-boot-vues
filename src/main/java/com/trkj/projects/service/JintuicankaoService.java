package com.trkj.projects.service;



import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.Jintuicankao;
import com.trkj.projects.mybatis.entity.Stock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Jintuicankao)表服务接口
 *
 * @author makejava
 * @since 2021-06-22 19:56:04
 */
public interface JintuicankaoService {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    Jintuicankao queryById();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Jintuicankao> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param jintuicankao 实例对象
     * @return 实例对象
     */
    Jintuicankao insert(Jintuicankao jintuicankao);

    /**
     * 修改数据
     *
     * @param jintuicankao 实例对象
     * @return 实例对象
     */
    Jintuicankao update(Jintuicankao jintuicankao);

    /**
     * 通过主键删除数据
     *
     * @return 是否成功
     */
    boolean deleteById();

    /**
     * 查询所有的进货参考商品
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Jintuicankao>selectjinhuocangkao(int currentPage, int pageSize);

    /**
     * 修改退货参考
     * @param tuihuo
     * @param sid
     * @return
     */
    int updatecangkao(Integer tuihuo ,String sid );

    /**
     * 删除
     * @param
     * @return
     */
    void deletecangkao(String q);


}
