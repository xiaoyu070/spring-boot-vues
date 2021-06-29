package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.Dbtype;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Dbtype)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-28 09:04:30
 */
@Mapper
public interface DbtypeDao {


    List<Dbtype> selectdbtype();




}

