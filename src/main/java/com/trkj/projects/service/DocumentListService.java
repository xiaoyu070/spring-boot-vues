package com.trkj.projects.service;


import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.DocumentList;
import com.trkj.projects.vo.DocumentlistVo;
import com.trkj.projects.vo.SpcgmxVo;
import com.trkj.projects.vo.SpxsmxVo;

import java.util.List;

/**
 * (DocumentList)表服务接口
 *
 * @author makejava
 * @since 2021-06-03 22:08:18
 */
public interface DocumentListService {
    //邓峄楷
    PageInfo<DocumentlistVo> findallbyfdandkhanduserandgjz(String qishitime,String zuihotime,int branchid, int customerid, int userid, String gjz, int currentPage, int pageSize );


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
    boolean deleteById(String number);

    /**
     * 查询单据状态为待审核的单据
     */
    List<DocumentlistVo> selectvo(DocumentlistVo documentShopVo);

    /**
     * 查询销售出库单据状态为待审核的单据
     */
    List<DocumentlistVo> selectxsvo(DocumentlistVo documentShopVo);

    /**
     * 模糊查询单据状态为待审核的单据
     */
    List<DocumentlistVo> likevo(String text);
    /**
     * 模糊查询销售单据状态为待审核的单据
     */
    List<DocumentlistVo> xslikevo(String text);

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

    /**
     * 根据给定的时间节点查询状态为待审核的销售单据
     * @param date1
     * @param date2
     * @return
     */
    List<DocumentlistVo> xsselectdatesdanju(String date1, String date2);

    PageInfo<SpcgmxVo> cgdj(int currentPage, int pageSize);
    PageInfo<SpcgmxVo> djxq(int currentPage, int pageSize);
    PageInfo<SpcgmxVo> spmx(int currentPage, int pageSize);
    PageInfo<SpxsmxVo> ssdj(int currentPage, int pageSize);
    List<SpcgmxVo> ywymc();
    List<SpxsmxVo> ywymc1();
    List<SpxsmxVo> fdcx();
    List<SpxsmxVo> djlx();
    PageInfo<SpcgmxVo> ywycx(SpcgmxVo spcgmxVo , int currentPage, int pageSize);
    PageInfo<SpxsmxVo> ssdjcx(SpxsmxVo spxsmxVo , int currentPage, int pageSize);
    /**
     * 查询给定的俩个时间节点之间的单据
     */
    List<SpcgmxVo> sjcx(String date1, String date2);
}
