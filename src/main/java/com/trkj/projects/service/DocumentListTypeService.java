package com.trkj.projects.service;


import com.trkj.projects.mybatis.entity.DocumentListType;

import java.util.List;

/**
 * (DocumentListType)表服务接口
 *
 * @author makejava
 * @since 2021-06-03 22:08:40
 */
public interface DocumentListTypeService {


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<DocumentListType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param documentListType 实例对象
     * @return 实例对象
     */
    DocumentListType insert(DocumentListType documentListType);

}
