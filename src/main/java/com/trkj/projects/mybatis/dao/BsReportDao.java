package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.BsReport;
import com.trkj.projects.vo.BsReportVo;
import com.trkj.projects.vo.DocumentlistVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BsReport)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-15 20:26:33
 */
@Mapper
public interface BsReportDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bsId 主键
     * @return 实例对象
     */
    BsReport queryById(Integer bsId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BsReport> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bsReport 实例对象
     * @return 对象列表
     */
    List<BsReport> queryAll(BsReport bsReport);

    /**
     * 新增数据
     *
     * @param bsReport 实例对象
     * @return 影响行数
     */
    int insert(BsReport bsReport);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BsReport> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BsReport> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BsReport> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<BsReport> entities);

    /**
     * 修改数据
     *
     * @param bsReport 实例对象
     * @return 影响行数
     */
    int update(BsReport bsReport);

    /**
     * 通过主键删除数据
     *
     * @param bsId 主键
     * @return 影响行数
     */
    int deleteById(Integer bsId);

    /**
     * 查询所有报损报溢单号
     * @return
     */
    List<BsReportVo>selectdj();

    /**
     * 根据单据号查询所有报损报溢商品信息
     * @param param1
     * @return
     */
    List<BsReportVo>selectbsLossreport(String param1);

    /**
     * 根据报损报溢类型查询所有单据信息
     * @param documentsTypeId
     * @return
     */
    List<BsReportVo>selectbsbytype(int documentsTypeId);


    /**
     * 根据两个时间查询单据报损报溢单据
     * @param date1
     * @param date2
     * @return
     */
    List<BsReportVo> selectdate(String date1, String date2);




}

