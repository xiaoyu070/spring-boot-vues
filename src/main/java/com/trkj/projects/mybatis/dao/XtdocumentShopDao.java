package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.XtdocumentShop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (XtdocumentShop)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-18 10:41:12
 */
@Mapper
public interface XtdocumentShopDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    XtdocumentShop queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XtdocumentShop> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param xtdocumentShop 实例对象
     * @return 对象列表
     */
    List<XtdocumentShop> queryAll(XtdocumentShop xtdocumentShop);

    /**
     * 新增数据
     *
     * @param xtdocumentShop 实例对象
     * @return 影响行数
     */
    int insert(XtdocumentShop xtdocumentShop);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<XtdocumentShop> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<XtdocumentShop> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<XtdocumentShop> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<XtdocumentShop> entities);

    /**
     * 修改数据
     *
     * @param xtdocumentShop 实例对象
     * @return 影响行数
     */
    int update(XtdocumentShop xtdocumentShop);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

