package com.trkj.projects.service;

import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.XsdocumentShop;
import com.trkj.projects.vo.*;
import com.trkj.projects.mybatis.entity.DocumentShop;
import com.trkj.projects.mybatis.entity.XsdocumentShop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (XsdocumentShop)表服务接口
 *
 * @author makejava
 * @since 2021-06-18 17:07:15
 */
public interface XsdocumentShopService {
    /**
     * 新增数据
     *
     * @param xsdocumentShop 实例对象
     * @return 实例对象
     */
    XsdocumentShop insert(XsdocumentShop xsdocumentShop);

    /**
     * 修改数据
     *
     * @param xsdocumentShop 实例对象
     * @return 实例对象
     */
    XsdocumentShop update(XsdocumentShop xsdocumentShop);
    /**
     * 根据单据号删除商品
     */
    void deleteshoplist(String number);
    /**
     * 根据单据号查询商品
     */
    List<DocumentShopVo> selectnumber(String number,int wid,int branchid);
    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DocumentShop> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<XsdocumentShop> entities);
    Integer uptshopstate(Integer id,String danju,String ysdanju);

    PageInfo<DocumentShopVo> selectbycid(Integer cid, String data1, String data2, Integer currentPage, Integer pageSize, String name);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    XsdocumentShop queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XsdocumentShop> queryAllByLimit(int offset, int limit);


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    /**
     * 销售商品明细
     */
    PageInfo<SpxstjVo> xsspmx(int currentPage, int pageSize);
    List<SpxstjVo> khtj();
    List<SpxstjVo> xssphz();
    List<SpxstjVo> xsspfltj();
    List<SpxstjVo> ghstj();
    List<SpxstjVo> artj();
    List<SpxstjVo> ckcx();
    List<SpxstjVo> lbcx();
    List<SpxstjVo> selectnumber3xyz(String ccontacts);
    List<SpxstjVo> selectnumber4xyz(String suppliername);
    PageInfo<SpxstjVo> xsmxcx(SpxstjVo spxstjVo , int currentPage, int pageSize);

}
