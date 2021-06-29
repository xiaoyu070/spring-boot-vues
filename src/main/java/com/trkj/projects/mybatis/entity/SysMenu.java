package com.trkj.projects.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (SysMenu)实体类
 *
 * @author makejava
 * @since 2021-05-25 09:08:34
 */
@Data
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 412269874065234215L;
    /**
     * 菜单id
     */
    private Integer menuId;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 路由名称
     */
    private String menuPathname;
    /**
     * 路由地址
     */
    private String menuPath;
    /**
     * 菜单图片
     */
    private String menuIcon;
    /**
     * 父级菜单id
     */
    private Integer parentId;
    /**
     * 显示顺序
     */
    private Integer orderNum;
    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    private String menuType;
    /**
     * 菜单状态（0显示 1隐藏）
     */
    private Integer visible;
    /**
     * 组件地址
     */
    private String component;

    private List<SysMenu> ChildMenu;


}
