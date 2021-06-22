package com.trkj.projects.service.impl;

<<<<<<< HEAD
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.XsdocumentShop;
import com.trkj.projects.mybatis.dao.XsdocumentShopDao;
import com.trkj.projects.service.XsdocumentShopService;
import com.trkj.projects.vo.CgdjVo;
import com.trkj.projects.vo.SpcgmxVo;
import com.trkj.projects.vo.SpxstjVo;
=======
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.DocumentShop;
import com.trkj.projects.mybatis.entity.XsdocumentShop;
import com.trkj.projects.mybatis.dao.XsdocumentShopDao;
import com.trkj.projects.service.XsdocumentShopService;
import com.trkj.projects.vo.DocumentShopVo;
>>>>>>> 588e348bed5392313284cf3e74f05d9c902b1699
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (XsdocumentShop)表服务实现类
 *
 * @author makejava
<<<<<<< HEAD
 * @since 2021-06-18 17:07:15
=======
 * @since 2021-06-18 15:47:03
>>>>>>> 588e348bed5392313284cf3e74f05d9c902b1699
 */
@Service("xsdocumentShopService")
public class XsdocumentShopServiceImpl implements XsdocumentShopService {
    @Resource
    private XsdocumentShopDao xsdocumentShopDao;

<<<<<<< HEAD
=======
    @Override
    public void deleteshoplist(String number) {
        this.xsdocumentShopDao.deleteshoplist(number);
    }
    @Override
    public List<DocumentShopVo> selectnumber(String number,int wid,int branchid) {
        return this.xsdocumentShopDao.selectnumber(number,wid,branchid);
    }
    @Override
    public int insertBatch(List<XsdocumentShop> entities) {
        return this.xsdocumentShopDao.insertBatch(entities);
    }
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
    public PageInfo<DocumentShopVo> selectbycid(Integer cid, String data1, String data2, Integer currentPage, Integer pageSize, String name) {
        List<DocumentShopVo> list = xsdocumentShopDao.querybycustomeridanddata(cid,data1,data2,name);
        Page<DocumentShopVo> page = PageHelper.startPage(currentPage,pageSize,true);
        List<DocumentShopVo> list2 = xsdocumentShopDao.querybycustomeridanddata(cid,data1,data2,name);
        PageInfo<DocumentShopVo> info = new PageInfo<>(list2);
        info.setTotal(list.size());
        return info;
    }
    @Override
    public Integer uptshopstate(Integer id) {

        return this.xsdocumentShopDao.uptxsshopstate(id);
    }
>>>>>>> 588e348bed5392313284cf3e74f05d9c902b1699
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public XsdocumentShop queryById(Integer id) {
        return this.xsdocumentShopDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<XsdocumentShop> queryAllByLimit(int offset, int limit) {
        return this.xsdocumentShopDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param xsdocumentShop 实例对象
     * @return 实例对象
     */
    @Override
    public XsdocumentShop insert(XsdocumentShop xsdocumentShop) {
        this.xsdocumentShopDao.insert(xsdocumentShop);
        return xsdocumentShop;
    }

    /**
     * 修改数据
     *
     * @param xsdocumentShop 实例对象
     * @return 实例对象
     */
    @Override
    public XsdocumentShop update(XsdocumentShop xsdocumentShop) {
        this.xsdocumentShopDao.update(xsdocumentShop);
        return this.queryById(xsdocumentShop.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.xsdocumentShopDao.deleteById(id) > 0;
    }
<<<<<<< HEAD

    @Override
    public PageInfo<SpxstjVo> xsspmx(int currentPage, int pageSize) {
        List<SpxstjVo> list=this.xsdocumentShopDao.xsspmx(currentPage,pageSize);
        //封装分页插件
        PageHelper.startPage(currentPage,pageSize,true);
        //再查所有最终传过去的数据
        List<SpxstjVo> list2=this.xsdocumentShopDao.xsspmx(currentPage,pageSize);
        //封装到pageinfo再设置总条数获取第一个list的大小size()方法
        PageInfo<SpxstjVo> info = new PageInfo<>(list2);
        info.setTotal(list.size());
        System.out.println(list);
        return info;
    }

    @Override
    public List<SpxstjVo> xssphz() {
        List<SpxstjVo> list2 = this.xsdocumentShopDao.xssphz();
        return list2;
    }

    @Override
    public List<SpxstjVo> xsspfltj() {
        List<SpxstjVo> list2 = this.xsdocumentShopDao.xsspfltj();
        return list2;
    }
    @Override
    public List<SpxstjVo> ckcx() {
        List<SpxstjVo> list2 = this.xsdocumentShopDao.ckcx();
        return list2;
    }
=======
>>>>>>> 588e348bed5392313284cf3e74f05d9c902b1699
}
