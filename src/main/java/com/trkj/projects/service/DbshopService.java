package com.trkj.projects.service;

import com.trkj.projects.mybatis.entity.BsByShop;
import com.trkj.projects.mybatis.entity.Dbshop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Dbshop)表服务接口
 *
 * @author makejava
 * @since 2021-06-28 11:39:35
 */
public interface DbshopService {



    /**
     * 新增数据
     *
     * @param dbshop 实例对象
     * @return 实例对象
     */
    Dbshop insert(Dbshop dbshop);

    /**
     * 修改数据
     *
     * @param dbshop 实例对象
     * @return 实例对象
     */
    Dbshop update(Dbshop dbshop);

    int insertBatch(@Param("entities") List<Dbshop> entities);


}
