package com.trkj.projects.service;


import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.DocumentShop;
import com.trkj.projects.vo.CgdjVo;
import com.trkj.projects.vo.DocumentShopVo;
import com.trkj.projects.vo.SpcgmxVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (DocumentShop)表服务接口
 *
 * @author makejava
 * @since 2021-06-04 10:36:33
 */
public interface DocumentShopService {

    PageInfo<DocumentShopVo> selectbycid(Integer cid,String data1,String data2,Integer currentPage, Integer pageSize,String name);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DocumentShop queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<DocumentShop> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param documentShop 实例对象
     * @return 实例对象
     */
    DocumentShop insert(DocumentShop documentShop);

    /**
     * 修改数据
     *
     * @param documentShop 实例对象
     * @return 实例对象
     */
    DocumentShop update(DocumentShop documentShop);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DocumentShop> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DocumentShop> entities);

    /**
     * 根据单据号查询商品
     */
    List<DocumentShopVo> selectnumber(String number,int wid,int branchid);

    /**
     * 通过单据号查询待审核单据中的商品
     */
    List<DocumentShopVo> selectstatezreonumber(String number,int wid);

    /**
     * 模糊查询
     */
    PageInfo<SpcgmxVo> flcx(SpcgmxVo spcgmxVo , int currentPage, int pageSize);
//    PageInfo<SpcgmxVo> cghz(SpcgmxVo spcgmxVo , int currentPage, int pageSize);
    /**
     * 查询
     * @return
     */
    PageInfo<SpcgmxVo> selectPurch(int currentPage, int pageSize);

//    PageInfo<CghzVo> selcetcghz(int currentPage, int pageSize);

    List<CgdjVo> selectfltj();

    /**
     * 根据单据号删除商品
     */
    void deleteshoplist(String number);
}
