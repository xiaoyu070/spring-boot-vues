package com.trkj.projects.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.dao.DocumentListDao;
import com.trkj.projects.mybatis.entity.DocumentList;
import com.trkj.projects.service.DocumentListService;
import com.trkj.projects.vo.DocumentlistVo;
import com.trkj.projects.vo.SpcgmxVo;
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

    @Override
    public List<DocumentlistVo> likevo(String text) {
        return this.documentListDao.likevo(text);
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



}
