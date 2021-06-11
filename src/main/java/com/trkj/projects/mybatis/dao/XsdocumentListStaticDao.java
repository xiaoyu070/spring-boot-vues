package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.XsdocumentListStatic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (XsdocumentListStatic)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-10 16:22:17
 */
@Mapper
public interface XsdocumentListStaticDao {



    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XsdocumentListStatic> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param xsdocumentListStatic 实例对象
     * @return 对象列表
     */
    List<XsdocumentListStatic> queryAll(XsdocumentListStatic xsdocumentListStatic);

    /**
     * 新增数据
     *
     * @param xsdocumentListStatic 实例对象
     * @return 影响行数
     */
    int insert(XsdocumentListStatic xsdocumentListStatic);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<XsdocumentListStatic> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<XsdocumentListStatic> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<XsdocumentListStatic> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<XsdocumentListStatic> entities);




}

