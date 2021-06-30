package com.trkj.projects.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.DocumentList;
import com.trkj.projects.mybatis.entity.Shops;
import com.trkj.projects.mybatis.entity.XsdocumentList;
import com.trkj.projects.mybatis.dao.XsdocumentListDao;
import com.trkj.projects.service.XsdocumentListService;
import com.trkj.projects.vo.DocumentlistVo;
import com.trkj.projects.vo.XsDocumentlistVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (XsdocumentList)表服务实现类
 *
 * @author makejava
 * @since 2021-06-10 16:21:32
 */
@Service("xsdocumentListService")
public class XsdocumentListServiceImpl implements XsdocumentListService {
    @Resource
    private XsdocumentListDao xsdocumentListDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public XsdocumentList queryById(Integer id) {
        return this.xsdocumentListDao.queryById(id);
    }

    /**
     * 根据单据查询单据信息
     * @param dlnumber
     * @return
     */
    @Override
    public XsDocumentlistVo queryBydlnumber(String dlnumber) {
        return this.xsdocumentListDao.queryBydlnumber(dlnumber);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<XsdocumentList> queryAllByLimit(int offset, int limit) {
        return this.xsdocumentListDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param xsdocumentList 实例对象
     * @return 实例对象
     */
    @Override
    public XsdocumentList insert(XsdocumentList xsdocumentList) {
        this.xsdocumentListDao.insert(xsdocumentList);
        return xsdocumentList;
    }

    /**
     * 修改数据
     *
     * @param xsdocumentList 实例对象
     * @return 实例对象
     */
    @Override
    public XsdocumentList update(XsdocumentList xsdocumentList) {
        this.xsdocumentListDao.update(xsdocumentList);
        return this.queryById(xsdocumentList.getId());
    }

    /**
     * 审核通过更改销售状态为出库
     * @param xsdocumentList
     */
    @Override
    public void updatestaticzore(XsdocumentList xsdocumentList) {
        this.xsdocumentListDao.updatestaticzore(xsdocumentList);
    }
    /**
     * 审核通过更改销售状态为出库
     * @param xsdocumentList
     */
    @Override
    public void updatestaticzoret(XsdocumentList xsdocumentList) {
        this.xsdocumentListDao.updatestaticzoret(xsdocumentList);
    }

    /**
     * 通过主键删除数据
     *
     * @param number 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String number) {
        return this.xsdocumentListDao.deleteById(number) > 0;
    }

    /**
     * 查询销售为待审核的单据
     * @param
     * @return
     */
    @Override
    public List<XsDocumentlistVo> selectxsvo(XsDocumentlistVo xsDocumentlistVo) {
        return this.xsdocumentListDao.selectxsvo(xsDocumentlistVo);
    }
    /**
     * 模糊查询销售单据
     * @param text
     * @return
     */
    @Override
    public List<XsDocumentlistVo> xslikevo(String text) {
        return this.xsdocumentListDao.xslikevo(text);
    }
    //根据时间段查询销售单据
    @Override
    public List<XsDocumentlistVo> xsselectdate(String date1, String date2) {
        return this.xsdocumentListDao.xsselectdate(date1,date2);
    }

    /**
     * 根据条件查询往来账务的单据
     * @param dlNumber
     * @param cid
     * @param wid
     * @param agentid
     * @param userid
     * @param branchid
     * @param date1
     * @param date2
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<XsDocumentlistVo> finxsdwlzw(String dlNumber, Integer cid, Integer wid, Integer agentid, Integer userid, Integer branchid, String date1, String date2,Integer currentPage, Integer pageSize) {
        List<XsDocumentlistVo> list = xsdocumentListDao.findxswlzh(dlNumber,cid,wid,agentid,userid,branchid,date1,date2);
        Page<XsDocumentlistVo> page= PageHelper.startPage(currentPage,pageSize,true);
        List<XsDocumentlistVo> list2 = xsdocumentListDao.findxswlzh(dlNumber,cid,wid,agentid,userid,branchid,date1,date2);
        PageInfo<XsDocumentlistVo> info = new PageInfo<>(list2);
        info.setTotal(list.size());
        System.out.println("往来账务数据："+info);
        return info;
    }

    @Override
    public void updatetwo(XsdocumentList documentlistVo) {

    }

}
