package com.trkj.projects.vo;

import com.trkj.projects.mybatis.entity.SysMenu;
import lombok.Data;

import java.util.List;


@Data
public class MenusVo {
    /**
     * 菜单id
     */
    private Integer menuId;
    /**
     * 菜单名称
     */
    private String label;
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
    private List<MenusVo> Children;
}
