package com.trkj.projects.service;


import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.DocumentList;
import com.trkj.projects.vo.DocumentlistVo;
import com.trkj.projects.vo.SpcgmxVo;

import java.util.List;

/**
 * (DocumentList)表服务接口
 *
 * @author makejava
 * @since 2021-06-03 22:08:18
 */
public interface DocumentListService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DocumentList queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<DocumentList> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param documentList 实例对象
     * @return 实例对象
     */
    DocumentList insert(DocumentList documentList);

    /**
     * 修改数据
     *
     * @param documentList 实例对象
     * @return 实例对象
     */
    DocumentList update(DocumentList documentList);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 查询单据状态为待审核的单据
     */
    List<DocumentlistVo> selectvo(DocumentlistVo documentShopVo);

    /**
     * 模糊查询单据状态为待审核的单据
     */
    List<DocumentlistVo> likevo(String text);

    /**
     * 将未审核的单据状态改为已审核
     */
    void updatestaticzore(DocumentList documentList);

    /**
     * 查询往来账务
     */
    List<DocumentlistVo> selectwlzw();

    /**
     * 查询给定的俩个时间节点之间的单据
     */
    List<DocumentlistVo> selectdate(String date1, String date2);

    /**
     * 根据给定的时间节点查询状态为待审核的单据
     */
    List<DocumentlistVo> selectdatesdanju(String date1, String date2);

    PageInfo<SpcgmxVo> cgdj(int currentPage, int pageSize);

}