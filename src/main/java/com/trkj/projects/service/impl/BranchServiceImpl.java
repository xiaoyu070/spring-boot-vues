package com.trkj.projects.service.impl;



import com.trkj.projects.jpa.dao.JpaBranchDao;
import com.trkj.projects.jpa.dao.JpaWarehouseDao;
import com.trkj.projects.jpa.entity.BranchEntity;
import com.trkj.projects.mybatis.dao.BranchDao;
import com.trkj.projects.mybatis.dao.WarehouseDao;
import com.trkj.projects.mybatis.entity.Branch;
import com.trkj.projects.service.BranchService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Branch)表服务实现类
 *
 * @author makejava
 * @since 2021-05-31 21:13:34
 */
@Service("branchService")
public class BranchServiceImpl implements BranchService {
    @Resource
    private BranchDao branchDao;
    @Resource
    private JpaBranchDao jpaBranchDao;

    @Resource
    private JpaWarehouseDao jpaWarehouseDao;
    @Resource
    private WarehouseDao warehouseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param branchid 主键
     * @return 实例对象
     */
    @Override
    public Branch queryById(Integer branchid) {
        return this.branchDao.queryById(branchid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Branch> queryAllByLimit(int offset, int limit) {
        return this.branchDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param branch 实例对象
     * @return 实例对象
     */
    @Override
    public Branch insert(Branch branch) {
        this.branchDao.insert(branch);
        return branch;
    }

    /**
     * 修改数据
     *
     * @param branch 实例对象
     * @return 实例对象
     */
    @Override
    public Branch update(Branch branch) {
        this.branchDao.update(branch);
        return this.queryById(branch.getBranchid());
    }

    /**
     * 通过主键删除数据
     *
     * @param branchid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer branchid) {
        return this.branchDao.deleteById(branchid) > 0;
    }

    @Override
    public List<Branch> selctall() {
        return this.branchDao.selectall();
    }

    @Override
    public List<Branch> findall() {
        return this.branchDao.findAll();
    }


//    @Override
//    public List<Branch> findall() {
//        return this.branchDao.findAll();
//    }

    //-----------------------------------老弟的
//    @Override
//    public Page<BranchEntity> findAll(Pageable pageable) {
//        Page<BranchEntity> page = this.jpaWarehouseDao.findAll(pageable);
//        for (BranchEntity b:page){
//            System.out.println(b);
//        }
//        return page;
//    }
    //添加
    @Override
    public Branch addBranch(Branch branch) {
        this.branchDao.insert(branch);
        return branch;
    }
    //修改
    @Override
    public Branch updateBranch(Branch branch) {
        this.branchDao.updateByPrimaryKey(branch);
        return branch;
    }
    //删除分店
    @Override
    public void deleteBranch(int id) {
        this.branchDao.deleteByPrimaryKey(id);
    }
    //删除分店下单仓库
    @Override
    public void deleteWarehouse(int id) {
        this.warehouseDao.deleteWarehouse(id);
    }
    //批量删除分店
    @Override
    public Integer deleteByBranch(Integer[] branchid) {
        return this.branchDao.deleteByBranchAndNames(branchid);
    }
    //批量删除分店下的子数据
    @Override
    public Integer deleteByWarehouse(Integer[] branchid) {
        return this.warehouseDao.deleteByWarehouse(branchid);
    }
    @Override
    public List<BranchEntity> findalls() {
        return this.jpaBranchDao.findAll();
    }

    @Override
    public Page<BranchEntity> findAll(Pageable pageable) {
        Page<BranchEntity> page = this.jpaBranchDao.findAll(pageable);
        for (BranchEntity b:page){
            System.out.println(b);
        }
        return page;
    }

    //------------------------一哥的
    /**
     * 查询所有店面
     * @return
     */
    @Override
    public List<Branch> queryBranchAll() {
        return this.branchDao.queryBranchAll();
    }

}
