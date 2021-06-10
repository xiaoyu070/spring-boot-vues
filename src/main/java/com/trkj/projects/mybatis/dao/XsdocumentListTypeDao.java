package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.XsdocumentListType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (XsdocumentListType)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-10 16:23:04
 */
@Mapper
public interface XsdocumentListTypeDao {

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XsdocumentListType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param xsdocumentListType 实例对象
     * @return 对象列表
     */
    List<XsdocumentListType> queryAll(XsdocumentListType xsdocumentListType);

    /**
     * 新增数据
     *
     * @param xsdocumentListType 实例对象
     * @return 影响行数
     */
    int insert(XsdocumentListType xsdocumentListType);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<XsdocumentListType> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<XsdocumentListType> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<XsdocumentListType> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<XsdocumentListType> entities);



}

