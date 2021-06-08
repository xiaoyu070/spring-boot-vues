package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.DocumentListStatic;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (DocumentListStatic)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-03 22:07:33
 */
@Mapper
public interface DocumentListStaticDao {

    /**
     * 通过ID查询单条数据
     *
     * @param 主键
     * @return 实例对象
     */
    DocumentListStatic queryById();

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<DocumentListStatic> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param documentListStatic 实例对象
     * @return 对象列表
     */
    List<DocumentListStatic> queryAll(DocumentListStatic documentListStatic);

    /**
     * 新增数据
     *
     * @param documentListStatic 实例对象
     * @return 影响行数
     */
    int insert(DocumentListStatic documentListStatic);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DocumentListStatic> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DocumentListStatic> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DocumentListStatic> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<DocumentListStatic> entities);



}

