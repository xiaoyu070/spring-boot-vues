package com.trkj.projects.service.impl;

import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.PdReport;
import com.trkj.projects.mybatis.dao.PdReportDao;
import com.trkj.projects.service.PdReportService;

import com.trkj.projects.vo.BsReportVo;
import com.trkj.projects.vo.PdResponseVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PdReport)表服务实现类
 *
 * @author makejava
 * @since 2021-06-17 19:02:07
 */
@Service("pdReportService")
public class PdReportServiceImpl implements PdReportService {
    @Resource
    private PdReportDao pdReportDao;

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
//    @Override
//    public PdReport queryById() {
//        return this.pdReportDao.queryById();
//    }

    @Override
    public PdReport queryById() {
        return null;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<PdReport> queryAllByLimit(int offset, int limit) {
        return this.pdReportDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param pdReport 实例对象
     * @return 实例对象
     */
    @Override
    public PdReport insert(PdReport pdReport) {
        this.pdReportDao.insert(pdReport);
        return pdReport;
    }

    @Override
    public PdReport update(PdReport pdReport) {
        return null;
    }

    @Override
    public boolean deleteById() {
        return false;
    }

    /**
     * 修改数据
     *
     * @param pdReport 实例对象
     * @return 实例对象
     */
//    @Override
//    public PdReport update(PdReport pdReport) {
//        this.pdReportDao.update(pdReport);
//        return this.queryById(pdReport.get());
//    }

    /**
     * 通过主键删除数据
//     *
//     * @param 主键
//     * @return 是否成功
//     */
//    @Override
//    public boolean deleteById() {
//        return this.pdReportDao.deleteById() > 0;
//    }

    @Override
    public PageInfo<PdResponseVo> selectddh(int currentPage, int pageSize) {
        List<PdResponseVo> list =this.pdReportDao.selectddh();
        PageInfo<PdResponseVo> info=new PageInfo<>(list);
        info.setTotal(list.size());
        return info;
    }

    /**
     * 根据盘点单号查询盘点商品信息
     * @param currentPage
     * @param pageSize
     * @param param1
     * @return
     */
    @Override
    public PageInfo<PdResponseVo> selectpdid(Integer currentPage, Integer pageSize, String param1) {
        List<PdResponseVo> list =this.pdReportDao.selectpdid(param1);
        PageInfo<PdResponseVo> info=new PageInfo<>(list);
        info.setTotal(list.size());
        return info;
    }

    @Override
    public void delectpdd(String pdid) {
        pdReportDao.delectpdd(pdid);
    }


    /**
     * 查询所有盘点单号
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<PdResponseVo> selectpddone(int currentPage, int pageSize) {
        List<PdResponseVo> list =this.pdReportDao.selectpddone();
        PageInfo<PdResponseVo> info=new PageInfo<>(list);
        info.setTotal(list.size());
        return info;
    }

    @Override
    public PageInfo<PdResponseVo> selectwherewid(Integer currentPage, Integer pageSize, Integer w) {
        List<PdResponseVo> list =this.pdReportDao.selectwherewid(w);
        PageInfo<PdResponseVo> info=new PageInfo<>(list);
        info.setTotal(list.size());
        return info;
    }

    @Override
    public PageInfo<PdResponseVo> selectwherepdid(Integer currentPage, Integer pageSize, String pd) {
        List<PdResponseVo> list = this.pdReportDao.selectwherepdid(pd);
        PageInfo<PdResponseVo> info = new PageInfo<>(list);
        info.setTotal(list.size());
        return info;
    }

    @Override
    public PageInfo<PdResponseVo> selectpddh(int currentPage, int pageSize) {
        List<PdResponseVo> list =this.pdReportDao.selectpddh();
        PageInfo<PdResponseVo> info=new PageInfo<>(list);
        info.setTotal(list.size());
        return info;
    }

    @Override
    public List<PdResponseVo> selectpadate(String date1, String date2) {
        return this.pdReportDao.selectpadate(date1,date2);
    }
}
