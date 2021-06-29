package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.Dbshop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Dbshop)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-28 11:39:06
 */
@Mapper
public interface DbshopDao {


    /**
     * 新增数据
     *
     * @param dbshop 实例对象
     * @return 影响行数
     */
    int insert(Dbshop dbshop);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Dbshop> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Dbshop> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Dbshop> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Dbshop> entities);



}

