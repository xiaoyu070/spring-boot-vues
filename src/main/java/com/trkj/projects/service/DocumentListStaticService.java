package com.trkj.projects.service;


import com.trkj.projects.mybatis.entity.DocumentListStatic;

import java.util.List;

/**
 * (DocumentListStatic)表服务接口
 *
 * @author makejava
 * @since 2021-06-03 22:08:28
 */
public interface DocumentListStaticService {


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<DocumentListStatic> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param documentListStatic 实例对象
     * @return 实例对象
     */
    DocumentListStatic insert(DocumentListStatic documentListStatic);



}
