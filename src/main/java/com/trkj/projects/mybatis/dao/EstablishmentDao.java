package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.Establishment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Establishment)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-06 21:45:36
 */
@Mapper
public interface EstablishmentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param xid 主键
     * @return 实例对象
     */
    Establishment queryById(Integer xid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Establishment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param establishment 实例对象
     * @return 对象列表
     */
    List<Establishment> queryAll(Establishment establishment);

    /**
     * 新增数据
     *
     * @param establishment 实例对象
     * @return 影响行数
     */
    int insert(Establishment establishment);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Establishment> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Establishment> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Establishment> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Establishment> entities);

    /**
     * 修改数据
     *
     * @param establishment 实例对象
     * @return 影响行数
     */
    int update(Establishment establishment);

    /**
     * 通过主键删除数据
     *
     * @param xid 主键
     * @return 影响行数
     */
    int deleteById(Integer xid);

    /**
     * 通过店面外键查询银行
     */
    List<Establishment> selectestab(Integer id);

    /**
     * 通过id减少银行金额（给供货商付款）
     */
    void updateestab(Establishment establishment);

    /**
     * 通过id增加银行金额
     * @param establishment
     */
//    void updateestab2(Establishment establishment);

    /**
     * 通过id增加银行金额（退货后供货商的实付金额）
     */
    void updateestabjia(Establishment establishment);
    /**
     * 楷楷的
     */
    List<Establishment> selectbybranchid(Integer branchid);


    //---------------------------------------老弟的

    int deleteByPrimaryKey(Integer xid);

    int insertSelective(Establishment record);

    Establishment selectByPrimaryKey(Integer xid);

    int updateByPrimaryKeySelective(Establishment record);

    int updateByPrimaryKey(Establishment record);

    List<Establishment> selectByBrachid(Integer branchid);
    //查询所有
    List<Establishment> selectByAll();

    Integer delete(@Param("xid")Integer[] xid);


}

