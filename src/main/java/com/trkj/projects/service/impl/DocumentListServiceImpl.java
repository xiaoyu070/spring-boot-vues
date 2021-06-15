package com.trkj.projects.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.dao.DocumentListDao;
import com.trkj.projects.mybatis.entity.DocumentList;
import com.trkj.projects.service.DocumentListService;
import com.trkj.projects.vo.CghzVo;
import com.trkj.projects.vo.DocumentlistVo;
import com.trkj.projects.vo.SpcgmxVo;
import com.trkj.projects.vo.SpxsmxVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DocumentList)表服务实现类
 *
 * @author makejava
 * @since 2021-06-03 22:08:18
 */
@Service("documentListService")
public class DocumentListServiceImpl implements DocumentListService {
    @Resource
    private DocumentListDao documentListDao;

    /**
     * kk:条件查询销售审核单
     * @param branchid
     * @param customerid
     * @param userid
     * @param gjz
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<DocumentlistVo> findallbyfdandkhanduserandgjz(String qishitime,String zuihotime,int branchid, int customerid, int userid, String gjz, int currentPage, int pageSize) {
        List<DocumentlistVo> list = documentListDao.findallbyfdandkhanduserandgjz(qishitime,zuihotime,branchid,userid,customerid,gjz);
        Page<DocumentlistVo> page= PageHelper.startPage(currentPage,pageSize,true);
        List<DocumentlistVo> list2 = documentListDao.findallbyfdandkhanduserandgjz(qishitime,zuihotime,branchid,userid,customerid,gjz);
        PageInfo<DocumentlistVo> info=new PageInfo<>(list2);
        info.setTotal((long)list.size() );
        return info;
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DocumentList queryById(Integer id) {
        return this.documentListDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<DocumentList> queryAllByLimit(int offset, int limit) {
        return this.documentListDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param documentList 实例对象
     * @return 实例对象
     */
    @Override
    public DocumentList insert(DocumentList documentList) {
        this.documentListDao.insert(documentList);
        return documentList;
    }

    /**
     * 修改数据
     *
     * @param documentList 实例对象
     * @return 实例对象
     */
    @Override
    public DocumentList update(DocumentList documentList) {
        this.documentListDao.update(documentList);
        return this.queryById(documentList.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String number) {
        return this.documentListDao.deleteById(number) > 0;
    }

    @Override
    public List<DocumentlistVo> selectvo(DocumentlistVo documentShopVo) {
        return this.documentListDao.selectvo(documentShopVo);
    }

    /**
     * 查询销售为待审核的单据
     * @param documentShopVo
     * @return
     */
    @Override
    public List<DocumentlistVo> selectxsvo(DocumentlistVo documentShopVo) {
        return this.documentListDao.selectxsvo(documentShopVo);
    }


    @Override
    public List<DocumentlistVo> likevo(String text) {
        return this.documentListDao.likevo(text);
    }

    /**
     * 模糊查询销售单据
     * @param text
     * @return
     */
    @Override
    public List<DocumentlistVo> xslikevo(String text) {
        return this.documentListDao.xslikevo(text);
    }

    @Override
    public void updatestaticzore(DocumentList documentList) {
        this.documentListDao.updatestaticzore(documentList);
    }

    @Override
    public List<DocumentlistVo> selectwlzw() {
        return this.documentListDao.selectwlzw();
    }


    @Override
    public List<DocumentlistVo> selectdate(String date1, String date2) {
        return this.documentListDao.selectdate(date1,date2);
    }

    @Override
    public List<DocumentlistVo> selectdatesdanju(String date1, String date2) {
        return this.documentListDao.selectdatesdanju(date1,date2);
    }
    //根据时间段查询销售单据信息
    @Override
    public List<DocumentlistVo> xsselectdatesdanju(String date1, String date2) {
        return this.documentListDao.xsselectdatesdanju(date1,date2);
    }


    @Override
    public PageInfo<SpcgmxVo> cgdj(int currentPage, int pageSize) {
        List<SpcgmxVo> list=this.documentListDao.cgdj(currentPage,pageSize);
        //封装分页插件
        PageHelper.startPage(currentPage,pageSize,true);
        //再查所有最终传过去的数据
        List<SpcgmxVo> list2 = this.documentListDao.cgdj(currentPage,pageSize);
        //封装到pageinfo再设置总条数获取第一个list的大小size()方法
        PageInfo<SpcgmxVo> info = new PageInfo<>(list2);
        info.setTotal(list.size());
        System.out.println(list);
        return info;
    }

    @Override
    public PageInfo<CghzVo> cghz(int currentPage, int pageSize) {
        List<CghzVo> list=this.documentListDao.cghz(currentPage,pageSize);
        //封装分页插件
        PageHelper.startPage(currentPage,pageSize,true);
        //再查所有最终传过去的数据
        List<CghzVo> list2 = this.documentListDao.cghz(currentPage,pageSize);
        //封装到pageinfo再设置总条数获取第一个list的大小size()方法
        PageInfo<CghzVo> info = new PageInfo<>(list2);
        info.setTotal(list.size());
        System.out.println(list);
        return info;
    }

    @Override
    public PageInfo<CghzVo> fltj(int currentPage, int pageSize) {
        List<CghzVo> list=this.documentListDao.fltj(currentPage,pageSize);
        //封装分页插件
        PageHelper.startPage(currentPage,pageSize,true);
        //再查所有最终传过去的数据
        List<CghzVo> list2 = this.documentListDao.fltj(currentPage,pageSize);
        //封装到pageinfo再设置总条数获取第一个list的大小size()方法
        PageInfo<CghzVo> info = new PageInfo<>(list2);
        info.setTotal(list.size());
        System.out.println(list);
        return info;
    }


    @Override
    public PageInfo<SpcgmxVo> djxq(int currentPage, int pageSize) {
        List<SpcgmxVo> list=this.documentListDao.djxq(currentPage,pageSize);
        //封装分页插件
        PageHelper.startPage(currentPage,pageSize,true);
        //再查所有最终传过去的数据
        List<SpcgmxVo> list2 = this.documentListDao.djxq(currentPage,pageSize);
        //封装到pageinfo再设置总条数获取第一个list的大小size()方法
        PageInfo<SpcgmxVo> info = new PageInfo<>(list2);
        info.setTotal(list.size());
        System.out.println(list);
        return info;
    }

    @Override
    public PageInfo<SpcgmxVo> spmx(int currentPage, int pageSize) {
        List<SpcgmxVo> list=this.documentListDao.spmx(currentPage,pageSize);
        //封装分页插件
        PageHelper.startPage(currentPage,pageSize,true);
        //再查所有最终传过去的数据
        List<SpcgmxVo> list2 = this.documentListDao.spmx(currentPage,pageSize);
        //封装到pageinfo再设置总条数获取第一个list的大小size()方法
        PageInfo<SpcgmxVo> info = new PageInfo<>(list2);
        info.setTotal(list.size());
        System.out.println(list);
        return info;
    }

    @Override
    public PageInfo<SpxsmxVo> ssdj(int currentPage, int pageSize) {
        List<SpxsmxVo> list=this.documentListDao.ssdj(currentPage,pageSize);
        //封装分页插件
        PageHelper.startPage(currentPage,pageSize,true);
        //再查所有最终传过去的数据
        List<SpxsmxVo> list2 = this.documentListDao.ssdj(currentPage,pageSize);
        //封装到pageinfo再设置总条数获取第一个list的大小size()方法
        PageInfo<SpxsmxVo> info = new PageInfo<>(list2);
        info.setTotal(list.size());
        System.out.println(list);
        return info;
    }

    @Override
    public List<SpcgmxVo> ywymc() {
        List<SpcgmxVo> list2 = this.documentListDao.ywymc();
        return list2;
    }

    @Override
    public List<SpxsmxVo> ywymc1() {
        List<SpxsmxVo> list2 = this.documentListDao.ywymc1();
        return list2;
    }

    @Override
    public List<SpxsmxVo> fdcx() {
        List<SpxsmxVo> list2 = this.documentListDao.fdcx();
        return list2;
    }
    @Override
    public List<SpxsmxVo> djlx() {
        List<SpxsmxVo> list2 = this.documentListDao.djlx();
        return list2;
    }

    @Override
    public PageInfo<SpcgmxVo> ywycx(SpcgmxVo spcgmxVo, int currentPage, int pageSize) {
            List<SpcgmxVo> list=this.documentListDao.ywycx(spcgmxVo);
            //封装分页插件
            PageHelper.startPage(currentPage,pageSize,true);
            //再查所有最终传过去的数据
            List<SpcgmxVo> list2=this.documentListDao.ywycx(spcgmxVo);
            //封装到pageinfo再设置总条数获取第一个list的大小size()方法
            PageInfo<SpcgmxVo> info = new PageInfo<>(list);
            info.setTotal(list.size());
            System.out.println(list);
            return info;
        }

    @Override
    public PageInfo<SpxsmxVo> ssdjcx(SpxsmxVo spxsmxVo, int currentPage, int pageSize) {
        List<SpxsmxVo> list=this.documentListDao.ssdjcx(spxsmxVo);
        //封装分页插件
        PageHelper.startPage(currentPage,pageSize,true);
        //再查所有最终传过去的数据
        List<SpxsmxVo> list2=this.documentListDao.ssdjcx(spxsmxVo);
        //封装到pageinfo再设置总条数获取第一个list的大小size()方法
        PageInfo<SpxsmxVo> info = new PageInfo<>(list);
        info.setTotal(list.size());
        System.out.println(list);
        return info;
    }


    @Override
    public List<SpcgmxVo> sjcx(String date1, String date2) {
        return this.documentListDao.sjcx(date1,date2);
    }
}

