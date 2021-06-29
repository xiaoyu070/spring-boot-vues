package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.PdReport;
import com.trkj.projects.vo.BsReportVo;
import com.trkj.projects.vo.PdResponseVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PdReport)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-17 19:01:47
 */
@Mapper
public interface PdReportDao {
    /**
     * 查询所有盘点单号
     * @return
     */
    List<PdResponseVo> selectddh();

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PdReport> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param pdReport 实例对象
     * @return 对象列表
     */
    List<PdReport> queryAll(PdReport pdReport);

    /**
     * 新增数据
     *
     * @param pdReport 实例对象
     * @return 影响行数
     */
    int insert(PdReport pdReport);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PdReport> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PdReport> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PdReport> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<PdReport> entities);

    /**
     * 根据单号查询所有的盘点商品信息
     * @param param1
     * @return
     */
    List<PdResponseVo>selectpdid(String param1);


    int delectpdd(String pdid);

    List<PdResponseVo>selectpddone();

    /**
     * 根据仓库查询所有的盘点单号
     * @param w
     * @return
     */
    List<PdResponseVo> selectwherewid(int w);

    List<PdResponseVo>selectwherepdid(String pd);

    List<PdResponseVo>selectpddh();

    List<PdResponseVo> selectpadate(String date1, String date2);


}

