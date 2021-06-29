package com.trkj.projects.service.impl;


import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.dao.BsReportDao;
import com.trkj.projects.mybatis.dao.SysUserDao;
import com.trkj.projects.mybatis.entity.BsReport;
import com.trkj.projects.mybatis.entity.SysUser;
import com.trkj.projects.service.BsReportService;
import com.trkj.projects.vo.BsReportVo;
import com.trkj.projects.vo.StockVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsReport)表服务实现类
 *
 * @author makejava
 * @since 2021-06-15 21:52:39
 */
@Service("bsReportService")
public class BsReportServiceImpl implements BsReportService {
    @Resource
    private BsReportDao bsReportDao;

    @Resource
    private SysUserDao sysUserDao;
    /**
     * 通过ID查询单条数据
     *
     * @param bsId 主键
     * @return 实例对象
     */
    @Override
    public BsReport queryById(Integer bsId) {
        return this.bsReportDao.queryById(bsId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BsReport> queryAllByLimit(int offset, int limit) {
        return this.bsReportDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bsReport 实例对象
     * @return 实例对象
     */
    @Override
    public BsReport insert(BsReport bsReport) {
        this.bsReportDao.insert(bsReport);
        return bsReport;
    }

    /**
     * 修改数据
     *
     * @param bsReport 实例对象
     * @return 实例对象
     */
    @Override
    public BsReport update(BsReport bsReport) {
        this.bsReportDao.update(bsReport);
        return this.queryById(bsReport.getBsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param bsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bsId) {
        return this.bsReportDao.deleteById(bsId) > 0;
    }

    /**
     * 查询报损报溢单号
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<BsReportVo> selectdj(int currentPage, int pageSize) {
        List<BsReportVo> list =this.bsReportDao.selectdj();

        SysUser sysUser=this.sysUserDao.findByUid(list.get(0).getUserId());
//        for(int i = 0;i<list.size();i++){
//            list.get(i).setUserName(sysUser.getUserName());
//        }
        PageInfo<BsReportVo> info=new PageInfo<>(list);
        info.setTotal(list.size());
        return info;
    }

    /**
     * 根据单号查询报损报溢商品信息
     * @param currentPage
     * @param pageSize
     * @param param1
     * @return
     */
    @Override
    public PageInfo<BsReportVo> selectbsLossreport(Integer currentPage, Integer pageSize, String param1) {
        List<BsReportVo> list =this.bsReportDao.selectbsLossreport(param1);
        PageInfo<BsReportVo> info=new PageInfo<>(list);
        info.setTotal(list.size());
        return info;
    }

    /**
     * 根据报损报溢类型查询报损报溢类型
     * @param currentPage
     * @param pageSize
     * @param documentsTypeId
     * @return
     */
    @Override
    public PageInfo<BsReportVo> selectbsbytype(Integer currentPage, Integer pageSize, Integer documentsTypeId) {
        List<BsReportVo> list=this.bsReportDao.selectbsbytype(documentsTypeId);
        PageInfo<BsReportVo> info=new PageInfo<>(list);
        info.setTotal(list.size());
        return info;
    }

    /**
     * 查询两个时间段的单据信息
     * @param date1
     * @param date2
     * @return
     */
    @Override
    public List<BsReportVo> selectdate(String date1, String date2) {

        return this.bsReportDao.selectdate(date1,date2);
    }


}
