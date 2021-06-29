package com.trkj.projects.service;

import com.trkj.projects.mybatis.entity.Dbtype;

import java.util.List;

/**
 * (Dbtype)表服务接口
 *
 * @author makejava
 * @since 2021-06-28 09:04:48
 */
public interface DbtypeService {




    List<Dbtype> selectdbtype();

}
