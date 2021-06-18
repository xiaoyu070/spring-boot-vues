package com.trkj.projects.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.dao.DocumentShopDao;
import com.trkj.projects.mybatis.entity.DocumentShop;
import com.trkj.projects.service.DocumentShopService;
import com.trkj.projects.vo.CgdjVo;
import com.trkj.projects.vo.DocumentShopVo;
import com.trkj.projects.vo.ShopVo;
import com.trkj.projects.vo.SpcgmxVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (DocumentShop)表服务实现类
 *
 * @author makejava
 * @since 2021-06-04 10:36:33
 */
@Service("documentShopService")
public class DocumentShopServiceImpl implements DocumentShopService {
    @Resource
    private DocumentShopDao documentShopDao;

    /**
     * j根据分店id查询销售
     * @param cid
     * @param data1
     * @param data2
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<DocumentShopVo> selectbycid(Integer cid, String data1, String data2,Integer currentPage, Integer pageSize,String name) {
        List<DocumentShopVo> list = documentShopDao.querybycustomeridanddata(cid,data1,data2,name);
        Page<DocumentShopVo> page = PageHelper.startPage(currentPage,pageSize,true);
        List<DocumentShopVo> list2 = documentShopDao.querybycustomeridanddata(cid,data1,data2,name);
        PageInfo<DocumentShopVo> info = new PageInfo<>(list2);
        info.setTotal(list.size());
        return info;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DocumentShop queryById(Integer id) {
        return this.documentShopDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<DocumentShop> queryAllByLimit(int offset, int limit) {
        return this.documentShopDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param documentShop 实例对象
     * @return 实例对象
     */
    @Override
    public DocumentShop insert(DocumentShop documentShop) {
        this.documentShopDao.insert(documentShop);
        return documentShop;
    }

    /**
     * 修改数据
     *
     * @param documentShop 实例对象
     * @return 实例对象
     */
    @Override
    public DocumentShop update(DocumentShop documentShop) {
        this.documentShopDao.update(documentShop);
        return this.queryById(documentShop.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.documentShopDao.deleteById(id) > 0;
    }

    @Override
    public int insertBatch(List<DocumentShop> entities) {
        return this.documentShopDao.insertBatch(entities);
    }

    @Override
    public List<DocumentShopVo> selectnumber(String number,int wid,int branchid) {
        return this.documentShopDao.selectnumber(number,wid,branchid);
    }

    @Override
    public List<DocumentShopVo> selectstatezreonumber(String number, int wid) {
        return this.documentShopDao.selectstatezreonumber(number,wid);
    }

    @Override
    public PageInfo<SpcgmxVo> flcx(SpcgmxVo spcgmxVo, int currentPage, int pageSize) {
        List<SpcgmxVo> list=this.documentShopDao.flcx(spcgmxVo);
        //封装分页插件
        PageHelper.startPage(currentPage,pageSize,true);
        //再查所有最终传过去的数据
        List<SpcgmxVo> list2=this.documentShopDao.flcx(spcgmxVo);
        //封装到pageinfo再设置总条数获取第一个list的大小size()方法
        PageInfo<SpcgmxVo> info = new PageInfo<>(list);
        info.setTotal(list.size());
        System.out.println(list);
        return info;
    }


    @Override
    public PageInfo<SpcgmxVo> selectPurch(int currentPage, int pageSize) {
        List<SpcgmxVo> list=this.documentShopDao.selectPurch(currentPage,pageSize);
        //封装分页插件
        PageHelper.startPage(currentPage,pageSize,true);
        //再查所有最终传过去的数据
        List<SpcgmxVo> list2 = this.documentShopDao.selectPurch(currentPage,pageSize);
        //封装到pageinfo再设置总条数获取第一个list的大小size()方法
        PageInfo<SpcgmxVo> info = new PageInfo<>(list2);
        info.setTotal(list.size());
        System.out.println(list);
        return info;
    }


    @Override
    public List<CgdjVo> selectfltj() {
        List<CgdjVo> list2 = this.documentShopDao.selectfltj();
        return list2;
    }

    @Override
    public void deleteshoplist(String number) {
        this.documentShopDao.deleteshoplist(number);
    }

}
