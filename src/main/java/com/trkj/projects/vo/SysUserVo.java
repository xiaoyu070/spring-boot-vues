package com.trkj.projects.vo;

import com.trkj.projects.mybatis.entity.SysMenu;
import com.trkj.projects.mybatis.entity.SysUser;
import lombok.Data;

import java.util.List;

@Data
public class SysUserVo {
    private String token;
    private boolean isVatedata;
    private SysUser sysUser;
    private List<SysMenu> sysMenu;
}
