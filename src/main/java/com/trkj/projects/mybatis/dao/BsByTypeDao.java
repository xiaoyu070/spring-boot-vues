package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.BsByType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (BsByType)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-10 14:53:22
 */
@Mapper
public interface BsByTypeDao {


    /**
     * 报损报溢类型
     *
     * @return 实例对象
     */
    List<BsByType> queryById();

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BsByType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bsByType 实例对象
     * @return 对象列表
     */
    List<BsByType> queryAll(BsByType bsByType);

    /**
     * 新增数据
     *
     * @param bsByType 实例对象
     * @return 影响行数
     */
    int insert(BsByType bsByType);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BsByType> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BsByType> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BsByType> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<BsByType> entities);

    /**
     * 修改数据
     *
     * @param bsByType 实例对象
     * @return 影响行数
     */
    int update(BsByType bsByType);

    /**
     * 通过主键删除数据
     *
     * @param bsByByid 主键
     * @return 影响行数
     */
    int deleteById(Integer bsByByid);

}

