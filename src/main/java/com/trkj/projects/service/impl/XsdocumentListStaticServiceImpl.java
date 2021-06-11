package com.trkj.projects.service.impl;

import com.trkj.projects.mybatis.entity.XsdocumentListStatic;
import com.trkj.projects.mybatis.dao.XsdocumentListStaticDao;
import com.trkj.projects.service.XsdocumentListStaticService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (XsdocumentListStatic)表服务实现类
 *
 * @author makejava
 * @since 2021-06-10 16:22:30
 */
@Service("xsdocumentListStaticService")
public class XsdocumentListStaticServiceImpl implements XsdocumentListStaticService {
    @Resource
    private XsdocumentListStaticDao xsdocumentListStaticDao;



    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<XsdocumentListStatic> queryAllByLimit(int offset, int limit) {
        return this.xsdocumentListStaticDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param xsdocumentListStatic 实例对象
     * @return 实例对象
     */
    @Override
    public XsdocumentListStatic insert(XsdocumentListStatic xsdocumentListStatic) {
        this.xsdocumentListStaticDao.insert(xsdocumentListStatic);
        return xsdocumentListStatic;
    }




}
