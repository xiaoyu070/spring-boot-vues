package com.trkj.projects.vo;

import lombok.Data;

@Data
public class SysUser_roles {
    private Integer user_id;
    private String user_name;
    private Integer roles_lv;
    private String roles_name;
    private Integer user_state;
}
