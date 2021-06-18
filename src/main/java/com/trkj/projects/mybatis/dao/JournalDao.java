package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.Journal;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Journal)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-16 23:33:20
 */
@Mapper
public interface JournalDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Journal queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Journal> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param journal 实例对象
     * @return 对象列表
     */
    List<Journal> queryAll(Journal journal);

    /**
     * 新增数据
     *
     * @param journal 实例对象
     * @return 影响行数
     */
    int insert(Journal journal);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Journal> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Journal> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Journal> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Journal> entities);

    /**
     * 修改数据
     *
     * @param journal 实例对象
     * @return 影响行数
     */
    int update(Journal journal);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

