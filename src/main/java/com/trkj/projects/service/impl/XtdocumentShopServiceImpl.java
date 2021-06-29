package com.trkj.projects.service.impl;

import com.trkj.projects.mybatis.entity.XtdocumentShop;
import com.trkj.projects.mybatis.dao.XtdocumentShopDao;
import com.trkj.projects.service.XtdocumentShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (XtdocumentShop)表服务实现类
 *
 * @author makejava
 * @since 2021-06-18 10:42:28
 */
@Service("xtdocumentShopService")
public class XtdocumentShopServiceImpl implements XtdocumentShopService {
    @Resource
    private XtdocumentShopDao xtdocumentShopDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public XtdocumentShop queryById(Integer id) {
        return this.xtdocumentShopDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<XtdocumentShop> queryAllByLimit(int offset, int limit) {
        return this.xtdocumentShopDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param xtdocumentShop 实例对象
     * @return 实例对象
     */
    @Override
    public XtdocumentShop insert(XtdocumentShop xtdocumentShop) {
        this.xtdocumentShopDao.insert(xtdocumentShop);
        return xtdocumentShop;
    }
    /**
     * 批量新增数据
     *
     *
     * @return 实例对象
     */
    @Override
    public List<XtdocumentShop> plinsert(List<XtdocumentShop> xtdocumentShop) {
        this.xtdocumentShopDao.insertBatch(xtdocumentShop);
        return xtdocumentShop;
    }

    /**
     * 修改数据
     *
     * @param xtdocumentShop 实例对象
     * @return 实例对象
     */
    @Override
    public XtdocumentShop update(XtdocumentShop xtdocumentShop) {
        this.xtdocumentShopDao.update(xtdocumentShop);
        return this.queryById(xtdocumentShop.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.xtdocumentShopDao.deleteById(id) > 0;
    }
}
