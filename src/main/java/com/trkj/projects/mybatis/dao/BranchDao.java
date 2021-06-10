package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.Branch;
import com.trkj.projects.vo.BranchVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Branch)表数据库访问层
 *
 * @author makejava
 * @since 2021-05-31 21:13:23
 */
@Mapper
public interface BranchDao {

    /**
     * 通过ID查询单条数据
     *
     * @param branchid 主键
     * @return 实例对象
     */
    Branch queryById(Integer branchid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Branch> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param branch 实例对象
     * @return 对象列表
     */
    List<Branch> queryAll(Branch branch);

    /**
     * 新增数据
     *
     * @param branch 实例对象
     * @return 影响行数
     */
    int insert(Branch branch);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Branch> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Branch> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Branch> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Branch> entities);

    /**
     * 修改数据
     *
     * @param branch 实例对象
     * @return 影响行数
     */
    int update(Branch branch);

    /**
     * 通过主键删除数据
     *
     * @param branchid 主键
     * @return 影响行数
     */
    int deleteById(Integer branchid);

    /**
     * 查询所有店面
     */
    List<Branch> selectall();

    List<Branch> findAll();

    /**
     * 查询总店
     * 用于采购进货
     * @return
     */
    List<BranchVo> selecttypeidand1();

    //--------------------------------老弟的
    int deleteByPrimaryKey(Integer branchid);

    /**
     * 批量删除分店
     * @param branchid
     * @return
     */
    Integer deleteByBranchAndNames(@Param("branchid")Integer[] branchid);
    //添加分店
    int insertSelective(Branch record);

    Branch selectByPrimaryKey(Integer branchid);

    int updateByPrimaryKeySelective(Branch record);
    //修改分店信息
    int updateByPrimaryKey(Branch record);


    //------------------------一哥的
    /**
     * 查询所有店面
     * @return
     */
    List<Branch>queryBranchAll();



}

