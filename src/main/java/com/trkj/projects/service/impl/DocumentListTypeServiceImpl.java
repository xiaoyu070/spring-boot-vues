package com.trkj.projects.service.impl;

import com.trkj.projects.mybatis.dao.DocumentListTypeDao;
import com.trkj.projects.mybatis.entity.DocumentListType;
import com.trkj.projects.service.DocumentListTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DocumentListType)表服务实现类
 *
 * @author makejava
 * @since 2021-06-03 22:08:40
 */
@Service("documentListTypeService")
public class DocumentListTypeServiceImpl implements DocumentListTypeService {
    @Resource
    private DocumentListTypeDao documentListTypeDao;


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<DocumentListType> queryAllByLimit(int offset, int limit) {
        return this.documentListTypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param documentListType 实例对象
     * @return 实例对象
     */
    @Override
    public DocumentListType insert(DocumentListType documentListType) {
        this.documentListTypeDao.insert(documentListType);
        return documentListType;
    }



}
