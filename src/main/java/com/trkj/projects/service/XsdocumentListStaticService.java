package com.trkj.projects.service;

import com.trkj.projects.mybatis.entity.XsdocumentListStatic;

import java.util.List;

/**
 * (XsdocumentListStatic)表服务接口
 *
 * @author makejava
 * @since 2021-06-10 16:22:29
 */
public interface XsdocumentListStaticService {



    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XsdocumentListStatic> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param xsdocumentListStatic 实例对象
     * @return 实例对象
     */
    XsdocumentListStatic insert(XsdocumentListStatic xsdocumentListStatic);



}
