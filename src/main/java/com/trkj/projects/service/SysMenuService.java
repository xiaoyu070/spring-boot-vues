package com.trkj.projects.service;


import com.trkj.projects.mybatis.entity.SysMenu;

import java.util.List;

/**
 * (SysMenu)表服务接口
 *
 * @author makejava
 * @since 2021-05-25 09:08:49
 */
public interface SysMenuService {


    List<SysMenu> queryListById(int userid);
}
