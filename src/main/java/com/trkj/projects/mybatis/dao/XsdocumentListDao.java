package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.DocumentList;
import com.trkj.projects.mybatis.entity.XsdocumentList;
import com.trkj.projects.vo.DocumentlistVo;
import com.trkj.projects.vo.XsDocumentlistVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (XsdocumentList)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-10 16:19:58
 */
@Mapper
public interface XsdocumentListDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    XsdocumentList queryById(Integer id);

    XsDocumentlistVo queryBydlnumber(String dlnumber);

    List<XsDocumentlistVo> findxswlzh(@Param("dlNumber")String dlNumber,@Param("cid")Integer cid,@Param("wid")Integer wid, @Param("agentid")Integer agentid,@Param("userid")Integer userid,@Param("branchid")Integer branchid, @Param("date1")String date1,@Param("date2")String date2);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<XsdocumentList> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param
     * @return 对象列表
     */
    List<XsDocumentlistVo> selectxsvo(XsDocumentlistVo documentlistVo);

    /**
     * 模糊查询单据状态为待审核的单据
     */
    List<XsDocumentlistVo> xslikevo(String text);
    /**
     * 查询给定的俩个时间节点之间的销售单据
     */
    List<XsDocumentlistVo> xsselectdate(String date1, String date2);
    /**
     * 新增数据
     *
     * @param xsdocumentList 实例对象
     * @return 影响行数
     */
    int insert(XsdocumentList xsdocumentList);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<XsdocumentList> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<XsdocumentList> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<XsdocumentList> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<XsdocumentList> entities);

    /**
     * 修改数据
     *
     * @param xsdocumentList 实例对象
     * @return 影响行数
     */
    int update(XsdocumentList xsdocumentList);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String number);

    /**
     * 将未审核的单据状态改为已审核
     */
    void updatestaticzore(XsdocumentList xsdocumentList);
    /**
     * 将未审核的单据状态改为已审核
     */
    void updatestaticzoret(XsdocumentList xsdocumentList);

}

