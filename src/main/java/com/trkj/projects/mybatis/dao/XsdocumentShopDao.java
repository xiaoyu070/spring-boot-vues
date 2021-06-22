package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.XsdocumentShop;
import com.trkj.projects.vo.SpcgmxVo;
import com.trkj.projects.vo.SpxstjVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (XsdocumentShop)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-18 17:06:59
 */
@Mapper
public interface XsdocumentShopDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    XsdocumentShop queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XsdocumentShop> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param xsdocumentShop 实例对象
     * @return 对象列表
     */
    List<XsdocumentShop> queryAll(XsdocumentShop xsdocumentShop);

    /**
     * 新增数据
     *
     * @param xsdocumentShop 实例对象
     * @return 影响行数
     */
    int insert(XsdocumentShop xsdocumentShop);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<XsdocumentShop> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<XsdocumentShop> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<XsdocumentShop> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<XsdocumentShop> entities);

    /**
     * 修改数据
     *
     * @param xsdocumentShop 实例对象
     * @return 影响行数
     */
    int update(XsdocumentShop xsdocumentShop);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 商品销售统计查询
     */
    List<SpxstjVo> xsspmx(int currentPage, int pageSize);
    List<SpxstjVo> xssphz();
    List<SpxstjVo> xsspfltj();
    List<SpxstjVo> ckcx();
}
