package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Dbtype)实体类
 *
 * @author makejava
 * @since 2021-06-28 09:04:29
 */
@Data
public class Dbtype implements Serializable {
    private static final long serialVersionUID = 377179528071732350L;
    /**
     * 调拨类型id
     */
    private Integer id;
    /**
     * 调拨名称
     */
    private String dbname;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

}
