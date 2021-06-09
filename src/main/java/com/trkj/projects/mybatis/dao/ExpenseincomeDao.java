package com.trkj.projects.mybatis.dao;

import com.trkj.projects.mybatis.entity.Expenseincome;
import com.trkj.projects.vo.ExpenEntryVo;
import com.trkj.projects.vo.ExpenseincomeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ExpenseincomeDao {
    int deleteByPrimaryKey(Integer sid);

    /**
     * 分页查询费用及收入
     * @return
     */
    List<ExpenEntryVo> selectExpen();

    //根据项目名称查询
    List<ExpenseincomeVo> selectEntry(@Param("typeName")String typeName);

    int insert(Expenseincome record);

    int insertSelective(Expenseincome record);

    Expenseincome selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Expenseincome record);

    int updateByPrimaryKey(Expenseincome record);
}