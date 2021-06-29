package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.Jintuicankao;
import com.trkj.projects.mybatis.entity.Jintuicankaoa;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Jintuicankaoa)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-28 18:41:15
 */
@Mapper
public interface JintuicankaoaDao {


    /**
     * 新增数据
     *
     * @param jintuicankaoa 实例对象
     * @return 影响行数
     */
    int insert(Jintuicankaoa jintuicankaoa);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Jintuicankaoa> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Jintuicankaoa> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Jintuicankaoa> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Jintuicankaoa> entities);



    List<Jintuicankaoa> selectjinhuocangkao1();

    int updatecangkao1 (@Param("ckTuihuonumber")Integer ckTuihuonumber ,@Param("spShopid") String spShopid);

    int deletecangkao1(String spShopid);
}

