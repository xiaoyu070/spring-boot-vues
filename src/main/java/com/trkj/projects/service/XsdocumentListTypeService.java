package com.trkj.projects.service;

import com.trkj.projects.mybatis.entity.XsdocumentListType;

import java.util.List;

/**
 * (XsdocumentListType)表服务接口
 *
 * @author makejava
 * @since 2021-06-10 16:23:19
 */
public interface XsdocumentListTypeService {



    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XsdocumentListType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param xsdocumentListType 实例对象
     * @return 实例对象
     */
    XsdocumentListType insert(XsdocumentListType xsdocumentListType);



}
