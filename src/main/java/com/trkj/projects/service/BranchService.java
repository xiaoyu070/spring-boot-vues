package com.trkj.projects.service;


import com.trkj.projects.jpa.entity.BranchEntity;
import com.trkj.projects.mybatis.entity.Branch;
import com.trkj.projects.vo.BranchVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Branch)表服务接口
 *
 * @author makejava
 * @since 2021-05-31 21:13:34
 */
public interface BranchService {

    /**
     * 通过ID查询单条数据
     *
     * @param branchid 主键
     * @return 实例对象
     */
    Branch queryById(Integer branchid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Branch> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param branch 实例对象
     * @return 实例对象
     */
    Branch insert(Branch branch);

    /**
     * 修改数据
     *
     * @param branch 实例对象
     * @return 实例对象
     */
    Branch update(Branch branch);

    /**
     * 通过主键删除数据
     *
     * @param branchid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer branchid);

    /**
     * 查询所有分店
     */
    List<Branch> selctall();

    public List<Branch> findall();

    /**
     * 查询总店
     * 用于采购进货
     * @return
     */
    List<BranchVo> selecttypeidand1();

    //-----------------------------------老弟的
    public Page<BranchEntity> findAll(Pageable pageable);
    Branch addBranch(Branch branch);
    Branch updateBranch(Branch branch);
    void deleteBranch(int id);
    void  deleteWarehouse(int id);
    public Integer  deleteByBranch(Integer[] branchid);
    public Integer deleteByWarehouse(Integer[] branchid);
    public List<BranchEntity> findalls();


    //-------------------一哥的
    /**
     * 查询所有店面
     * @return
     */
    List<Branch> queryBranchAll();

}
