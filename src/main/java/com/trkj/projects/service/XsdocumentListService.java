package com.trkj.projects.service;

import com.trkj.projects.mybatis.entity.DocumentList;
import com.trkj.projects.mybatis.entity.XsdocumentList;
import com.trkj.projects.vo.DocumentlistVo;
import com.trkj.projects.vo.XsDocumentlistVo;

import java.util.List;

/**
 * (XsdocumentList)表服务接口
 *
 * @author makejava
 * @since 2021-06-10 16:21:32
 */
public interface XsdocumentListService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    XsdocumentList queryById(Integer id);

    XsDocumentlistVo queryBydlnumber(String dlnumber);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XsdocumentList> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param xsdocumentList 实例对象
     * @return 实例对象
     */
    XsdocumentList insert(XsdocumentList xsdocumentList);

    /**
     * 修改数据
     *
     * @param xsdocumentList 实例对象
     * @return 实例对象
     */
    XsdocumentList update(XsdocumentList xsdocumentList);

    /**
     * 将未审核的销售单据状态改为已审核
     */
    void updatestaticzore(XsdocumentList xsdocumentList);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String number);
    /**
     * 查询销售出库单据状态为待审核的单据
     */
    List<XsDocumentlistVo> selectxsvo(XsDocumentlistVo documentShopVo);
    /**
     * 模糊查询销售单据状态为待审核的单据
     */
    List<XsDocumentlistVo> xslikevo(String text);
    /**
     * 查询给定的俩个时间节点之间的销售单据
     */
    List<XsDocumentlistVo> xsselectdate(String date1, String date2);
}
