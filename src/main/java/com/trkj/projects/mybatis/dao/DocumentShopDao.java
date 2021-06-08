package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.DocumentShop;
import com.trkj.projects.vo.CgdjVo;
import com.trkj.projects.vo.DocumentShopVo;
import com.trkj.projects.vo.SpcgmxVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (DocumentShop)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-04 10:36:18
 */
@Mapper
public interface DocumentShopDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DocumentShop queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<DocumentShop> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param documentShop 实例对象
     * @return 对象列表
     */
    List<DocumentShop> queryAll(DocumentShop documentShop);

    /**
     * 新增数据
     *
     * @param documentShop 实例对象
     * @return 影响行数
     */
    int insert(DocumentShop documentShop);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DocumentShop> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DocumentShop> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DocumentShop> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<DocumentShop> entities);

    /**
     * 修改数据
     *
     * @param documentShop 实例对象
     * @return 影响行数
     */
    int update(DocumentShop documentShop);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 根据单据号查询商品
     */
    List<DocumentShopVo> selectnumber(String number);

    /**
     *模糊查询
     */
    List<SpcgmxVo> flcx(SpcgmxVo spcgmxVo);
    //    List<SpcgmxVo> cghz(SpcgmxVo spcgmxVo);
    List<SpcgmxVo> selectPurch(int currentPage,int pageSize);

//    List<CghzVo> selectcghz(int currentPage, int pageSize);

    List<CgdjVo> selectfltj();

}
