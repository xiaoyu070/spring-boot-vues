package com.trkj.projects.service.impl;

import com.trkj.projects.mybatis.dao.DocumentListStaticDao;
import com.trkj.projects.mybatis.entity.DocumentListStatic;
import com.trkj.projects.service.DocumentListStaticService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DocumentListStatic)表服务实现类
 *
 * @author makejava
 * @since 2021-06-03 22:08:28
 */
@Service("documentListStaticService")
public class DocumentListStaticServiceImpl implements DocumentListStaticService {
    @Resource
    private DocumentListStaticDao documentListStaticDao;


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<DocumentListStatic> queryAllByLimit(int offset, int limit) {
        return this.documentListStaticDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param documentListStatic 实例对象
     * @return 实例对象
     */
    @Override
    public DocumentListStatic insert(DocumentListStatic documentListStatic) {
        this.documentListStaticDao.insert(documentListStatic);
        return documentListStatic;
    }



}
