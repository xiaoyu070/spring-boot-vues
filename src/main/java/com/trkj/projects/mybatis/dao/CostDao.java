package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.Cost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CostDao {
    int deleteByPrimaryKey(Integer fid);

    int insert(Cost record);

    int insertSelective(Cost record);

    Cost selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(Cost record);

    int updateByPrimaryKey(Cost record);

    //根据类型查询所有项目名
    List<Cost> selectall(String Projecttype);
}