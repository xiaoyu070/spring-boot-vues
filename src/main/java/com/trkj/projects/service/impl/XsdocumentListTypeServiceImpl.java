package com.trkj.projects.service.impl;

import com.trkj.projects.mybatis.entity.XsdocumentListType;
import com.trkj.projects.mybatis.dao.XsdocumentListTypeDao;
import com.trkj.projects.service.XsdocumentListTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (XsdocumentListType)表服务实现类
 *
 * @author makejava
 * @since 2021-06-10 16:23:20
 */
@Service("xsdocumentListTypeService")
public class XsdocumentListTypeServiceImpl implements XsdocumentListTypeService {
    @Resource
    private XsdocumentListTypeDao xsdocumentListTypeDao;



    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<XsdocumentListType> queryAllByLimit(int offset, int limit) {
        return this.xsdocumentListTypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param xsdocumentListType 实例对象
     * @return 实例对象
     */
    @Override
    public XsdocumentListType insert(XsdocumentListType xsdocumentListType) {
        this.xsdocumentListTypeDao.insert(xsdocumentListType);
        return xsdocumentListType;
    }


}
