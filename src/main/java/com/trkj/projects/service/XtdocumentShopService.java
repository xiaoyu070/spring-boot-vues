package com.trkj.projects.service;

import com.trkj.projects.mybatis.entity.XtdocumentShop;

import java.util.List;

/**
 * (XtdocumentShop)表服务接口
 *
 * @author makejava
 * @since 2021-06-18 10:42:28
 */
public interface XtdocumentShopService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    XtdocumentShop queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XtdocumentShop> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param xtdocumentShop 实例对象
     * @return 实例对象
     */
    XtdocumentShop insert(XtdocumentShop xtdocumentShop);
    List<XtdocumentShop> plinsert(List<XtdocumentShop> xtdocumentShop);

    /**
     * 修改数据
     *
     * @param xtdocumentShop 实例对象
     * @return 实例对象
     */
    XtdocumentShop update(XtdocumentShop xtdocumentShop);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
