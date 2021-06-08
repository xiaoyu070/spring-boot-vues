package com.trkj.projects.mybatis.entity;

import java.io.Serializable;
import java.util.List;

/**
 * (SysMenu)实体类
 *
 * @author makejava
 * @since 2021-05-25 09:08:34
 */
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

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuPathname() {
        return menuPathname;
    }

    public void setMenuPathname(String menuPathname) {
        this.menuPathname = menuPathname;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }
    public List<SysMenu> getChildMenu() {
        return ChildMenu;
    }

    public void setChildMenu(List<SysMenu> childMenu) {
        ChildMenu = childMenu;
    }
}
