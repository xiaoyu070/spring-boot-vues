package com.trkj.projects.service;

import com.trkj.projects.mybatis.entity.Dbdanju;
import com.trkj.projects.vo.DbdanjuVo;

import java.util.List;

/**
 * (Dbdanju)表服务接口
 *
 * @author makejava
 * @since 2021-06-28 11:31:41
 */
public interface DbdanjuService {
    Dbdanju insert(Dbdanju dbdanju);

    List<DbdanjuVo>selectdbcx();
}
