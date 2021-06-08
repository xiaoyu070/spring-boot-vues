package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.SysMenu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (SysMenu)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-25 09:08:34
 */
@Mapper
public interface SysMenuDao {


    List<SysMenu> findListById(int userid);
}

