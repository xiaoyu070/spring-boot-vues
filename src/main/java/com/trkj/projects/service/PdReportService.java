package com.trkj.projects.service;

import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.PdReport;
import com.trkj.projects.vo.BsReportVo;
import com.trkj.projects.vo.PdResponseVo;

import java.util.List;

/**
 * (PdReport)表服务接口
 *
 * @author makejava
 * @since 2021-06-17 19:02:07
 */
public interface PdReportService {

    /**
     * 通过ID查询单条数据
     *
     * @param 主键
     * @return 实例对象
     */
    PdReport queryById();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<PdReport> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param pdReport 实例对象
     * @return 实例对象
     */
    PdReport insert(PdReport pdReport);

    /**
     * 修改数据
     *
     * @param pdReport 实例对象
     * @return 实例对象
     */
    PdReport update(PdReport pdReport);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    boolean deleteById();



    PageInfo<PdResponseVo> selectddh(int currentPage, int pageSize);

    /**
     * 通过盘点单号查询盘点信息
     * @param currentPage
     * @param pageSize
     * @param param1
     * @return
     */
    PageInfo<PdResponseVo>selectpdid(Integer currentPage, Integer pageSize, String param1);

    void delectpdd(String pdid);


    PageInfo<PdResponseVo> selectpddone(int currentPage, int pageSize);

    PageInfo<PdResponseVo> selectwherewid(Integer currentPage, Integer pageSize,Integer w);

    PageInfo<PdResponseVo> selectwherepdid(Integer currentPage, Integer pageSize,String pd);

    PageInfo<PdResponseVo> selectpddh(int currentPage, int pageSize);

    List<PdResponseVo> selectpadate(String date1, String date2);


}
