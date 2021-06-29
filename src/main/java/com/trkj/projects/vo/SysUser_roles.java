package com.trkj.projects.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SysUser_roles {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPass;
    /**
     * 用户性别
     */
    private String userSex;
    /**
     * 用户电话
     */
    private String userPhone;
    /**
     * 用户头像
     */
    private String userImgs;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_date;
    /**
     * 用户创建人
     */
    private String userCjr;
    /**
     * 用户更新人
     */
    private String userGxr;
    /**
     * 用户角色状态 0:可用 1：已删除
     */
    private Integer userstate;
    /**
     * 用户最后登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date userError;
    /**
     *用户删除 0：可用 1：已删除
     */
    private Integer userStatie;

    private Integer roles_lv;
    private Integer roles_id;
    private String roles_name;

}
