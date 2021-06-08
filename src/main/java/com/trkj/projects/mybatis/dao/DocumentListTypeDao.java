package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.DocumentListType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (DocumentListType)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-03 22:07:53
 */
@Mapper
public interface DocumentListTypeDao {


    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<DocumentListType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param documentListType 实例对象
     * @return 对象列表
     */
    List<DocumentListType> queryAll(DocumentListType documentListType);

    /**
     * 新增数据
     *
     * @param documentListType 实例对象
     * @return 影响行数
     */
    int insert(DocumentListType documentListType);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DocumentListType> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DocumentListType> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DocumentListType> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<DocumentListType> entities);



}

