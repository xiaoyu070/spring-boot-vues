package com.trkj.projects.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2021-05-25 08:53:20
 */
@Data
public class SysUser implements  Serializable {
    private static final long serialVersionUID = -15505283450357673L;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserImgs() {
        return userImgs;
    }

    public void setUserImgs(String userImgs) {
        this.userImgs = userImgs;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getUserCjr() {
        return userCjr;
    }

    public void setUserCjr(String userCjr) {
        this.userCjr = userCjr;
    }

    public String getUserGxr() {
        return userGxr;
    }

    public void setUserGxr(String userGxr) {
        this.userGxr = userGxr;
    }

    public Integer getUserstate() {
        return userstate;
    }

    public void setUserstate(Integer userstate) {
        this.userstate = userstate;
    }

    public Date getUserError() {
        return userError;
    }

    public void setUserError(Date userError) {
        this.userError = userError;
    }

    public Integer getUserStatie() {
        return userStatie;
    }

    public void setUserStatie(Integer userStatie) {
        this.userStatie = userStatie;
    }
}