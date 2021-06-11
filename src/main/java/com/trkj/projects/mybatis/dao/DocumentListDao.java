package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.DocumentList;
import com.trkj.projects.vo.DocumentlistVo;
import com.trkj.projects.vo.SpcgmxVo;
import com.trkj.projects.vo.SpxsmxVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (DocumentList)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-03 22:06:16
 */
@Mapper
public interface DocumentListDao {
    //邓峄楷
    List<DocumentlistVo> findallbyfdandkhanduserandgjz(@Param("qishitime")String qishitime,@Param("zuihotime")String zuihotime,@Param("branchid") int branchid,@Param("customerid") int customerid,@Param("userid")int userid,@Param("gjz") String gjz);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DocumentList queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<DocumentList> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param documentList 实例对象
     * @return 对象列表
     */
    List<DocumentList> queryAll(DocumentList documentList);

    /**
     * 新增数据
     *
     * @param documentList 实例对象
     * @return 影响行数
     */
    int insert(DocumentList documentList);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DocumentList> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DocumentList> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DocumentList> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<DocumentList> entities);

    /**
     * 修改数据
     *
     * @param documentList 实例对象
     * @return 影响行数
     */
    int update(DocumentList documentList);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String number);

    /**
     * 查询单据状态为待审核的单据
     */
    List<DocumentlistVo> selectvo(DocumentlistVo documentShopVo);

    /**
     * 查询销售单据状态为待审核的单据
     */
    List<DocumentlistVo> selectxsvo(DocumentlistVo documentShopVo);

    /**
     * 模糊查询单据状态为待审核的单据
     */
    List<DocumentlistVo> likevo(String text);
    /**
     * 模糊查询单据状态为待审核的单据
     */
    List<DocumentlistVo> xslikevo(String text);

    /**
     * 将采购未审核的单据状态改为已审核
     */
    void updatestaticzore(DocumentList documentList);

    /**
     * 将退货未审核的单据状态改为已审核
     */
    void updatestatictwo(DocumentList documentList);

    /**
     * 查询往来账务
     */
    List<DocumentlistVo> selectwlzw();

    /**
     * 查询给定的俩个时间节点之间的单据
     */
    List<DocumentlistVo> selectdate(String date1, String date2);

    /**
     * 根据给定的时间节点查询状态为待审核的单据
     */
    List<DocumentlistVo> selectdatesdanju(String date1, String date2);
    /**
     * 根据给定的时间节点查询状态为待审核的销售单据
     */
    List<DocumentlistVo> xsselectdatesdanju(String date1, String date2);

    List<SpcgmxVo> cgdj(int currentPage, int pageSize);
    List<SpcgmxVo> djxq(int currentPage, int pageSize);
    List<SpcgmxVo> spmx(int currentPage, int pageSize);
    List<SpxsmxVo> ssdj(int currentPage, int pageSize);
    List<SpcgmxVo> ywymc();
    List<SpxsmxVo> ywymc1();
    List<SpxsmxVo> fdcx();
    List<SpxsmxVo> djlx();
    List<SpcgmxVo> ywycx(SpcgmxVo spcgmxVo);
    List<SpxsmxVo> ssdjcx(SpxsmxVo spxsmxVo);
    /**
     * 查询给定的俩个时间节点之间的单据
     */
    List<SpcgmxVo> sjcx(String date1, String date2);

}

