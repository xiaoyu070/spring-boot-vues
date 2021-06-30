package com.trkj.projects.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Journal)实体类
 *
 * @author makejava
 * @since 2021-06-16 23:33:20
 */
@Data
public class Journal implements Serializable {
    private static final long serialVersionUID = 810679627081340207L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 获取的操作
     */
    private String paramsname;
    /**
     * 创建操作时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    /**
     * 操作员
     */
    private int userId;
    /**
     * 操作的方法
     */
    private String functions;
    /**
     * 参数长度
     */
    private String paramslength;
    /**
     * 获取用户ip地址
     */
    private String addressip;




}
