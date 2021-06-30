package com.trkj.projects.mybatis.dao;

import com.github.pagehelper.PageInfo;
import com.trkj.projects.mybatis.entity.Dbdanju;
import com.trkj.projects.vo.DbdanjuVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Dbdanju)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-28 11:31:24
 */
@Mapper
public interface DbdanjuDao {



    /**
     * 新增数据
     *
     * @param dbdanju 实例对象
     * @return 影响行数
     */
    int insert(Dbdanju dbdanju);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Dbdanju> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Dbdanju> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Dbdanju> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Dbdanju> entities);


    List<DbdanjuVo> selectdbcx11();


}

