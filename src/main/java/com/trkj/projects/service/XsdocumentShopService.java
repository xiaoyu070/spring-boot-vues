package com.trkj.projects.service;

import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.XsdocumentShop;
import com.trkj.projects.vo.SpcgmxVo;
import com.trkj.projects.vo.SpxstjVo;

import java.util.List;

/**
 * (XsdocumentShop)表服务接口
 *
 * @author makejava
 * @since 2021-06-18 17:07:15
 */
public interface XsdocumentShopService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    XsdocumentShop queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XsdocumentShop> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param xsdocumentShop 实例对象
     * @return 实例对象
     */
    XsdocumentShop insert(XsdocumentShop xsdocumentShop);

    /**
     * 修改数据
     *
     * @param xsdocumentShop 实例对象
     * @return 实例对象
     */
    XsdocumentShop update(XsdocumentShop xsdocumentShop);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    /**
     * 销售商品明细
     */
    PageInfo<SpxstjVo> xsspmx(int currentPage, int pageSize);
    List<SpxstjVo> xssphz();
    List<SpxstjVo> xsspfltj();
    List<SpxstjVo> ckcx();
}
