package com.trkj.projects.service;

import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.BsReport;
import com.trkj.projects.vo.BsReportVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (BsReport)表服务接口
 *
 * @author makejava
 * @since 2021-06-15 21:52:39
 */
public interface BsReportService {

    /**
     * 通过ID查询单条数据
     *
     * @param bsId 主键
     * @return 实例对象
     */
    BsReport queryById(Integer bsId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BsReport> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bsReport 实例对象
     * @return 实例对象
     */
    BsReport insert(BsReport bsReport);

    /**
     * 修改数据
     *
     * @param bsReport 实例对象
     * @return 实例对象
     */
    BsReport update(BsReport bsReport);

    /**
     * 通过主键删除数据
     *
     * @param bsId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer bsId);

    /**
     * 查询所有报损报溢单号
     * @return
     */
   PageInfo<BsReportVo> selectdj(int currentPage, int pageSize);

    /**
     * 根据单号查询报损报溢商品信息
     * @param currentPage
     * @param pageSize
     * @param param1
     * @return
     */
   PageInfo<BsReportVo>selectbsLossreport(Integer currentPage, Integer pageSize,String param1);

    /**
     * 根据报损报溢类型查询所有单据类型
     * @param currentPage
     * @param pageSize
     * @param documentsTypeId
     * @return
     */
   PageInfo<BsReportVo>selectbsbytype(Integer currentPage, Integer pageSize,Integer documentsTypeId);

   //查询两个时间段的单据号
   List<BsReportVo> selectdate(String date1, String date2);

}
