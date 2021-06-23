package com.trkj.projects.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.trkj.projects.mybatis.entity.SysMenu;
import com.trkj.projects.mybatis.entity.SysRoles;
import com.trkj.projects.mybatis.entity.SysRolesMenu;
import com.trkj.projects.mybatis.entity.SysUser;
import com.trkj.projects.service.SysMenuService;
import com.trkj.projects.vo.AjaxResponse;
import com.trkj.projects.vo.MenusVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * (SysMenu)表控制层
 *
 * @author makejava
 * @since 2021-05-25 09:08:49
 */
@RestController
@RequestMapping("sysMenu")
public class SysMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SysMenuService sysMenuService;

    //tree树形控制结构[vo]
    private List<MenusVo> getChildrens(MenusVo root, List<MenusVo> all) {
        List<MenusVo> children = all.stream().filter(m -> {
            return Objects.equals(m.getParentId(), root.getMenuId());
        }).map(
                (m) -> {
                    m.setChildren(getChildrens(m, all));
                    return m;
                }
        ).collect(Collectors.toList());
        return children;
    }
    //tree树形控制结构[muen实体]
    private List<SysMenu> getChildrens(SysMenu root, List<SysMenu> all) {
        List<SysMenu> children = all.stream().filter(m -> {
            return Objects.equals(m.getParentId(), root.getMenuId());
        }).map(
                (m) -> {
                    m.setChildMenu(getChildrens(m, all));
                    return m;
                }
        ).collect(Collectors.toList());
        return children;
    }
    //查询所有菜单muen实体
    @PostMapping("findListByRolesId")
    public AjaxResponse findListByRolesId(@RequestBody SysRoles sysRoles){
        List<SysMenu> list = this.sysMenuService.findListByRolesId(sysRoles);
        List<SysMenu> treemenu = list.stream().filter(m -> m.getParentId() == 0).map(
                (m) -> {
                    m.setChildMenu(getChildrens(m, list));
                    return m;
                }
        ).collect(Collectors.toList());
        return AjaxResponse.success(treemenu);
    }
    //查询所有菜单vo
    @GetMapping("queryMenus")
    public AjaxResponse queryMenus(){
        List<MenusVo> list = this.sysMenuService.queryMenus();
        List<MenusVo> treemenu = list.stream().filter(m -> m.getParentId() == 0).map(
                (m) -> {
                    m.setChildren(getChildrens(m, list));
                    return m;
                }
        ).collect(Collectors.toList());
        return AjaxResponse.success(treemenu);
    }
    //查询所有菜单
    @GetMapping("selectMenusall")
    public AjaxResponse selectMenusall(){
        List<SysMenu> list = this.sysMenuService.selectMenusall();
        List<SysMenu> treemenu = list.stream().filter(m -> m.getParentId() == 0).map(
                (m) -> {
                    m.setChildMenu(getChildrens(m, list));
                    return m;
                }
        ).collect(Collectors.toList());
        return AjaxResponse.success(treemenu);
    }
    @PostMapping("updateMenus")
    public AjaxResponse updateMenus(@RequestBody SysMenu sysMenu){
        this.sysMenuService.updateMenus(sysMenu);
        return AjaxResponse.success("修改成功！");
    }
//    //修改角色的菜单权限
//    @PostMapping("updateRolesMenus")
//    public AjaxResponse updateRolesMenus(@RequestBody String a){
//        JSONObject jsonObject= JSON.parseObject(a);
//        String munus = jsonObject.getString("munuslist");
//        String roles = jsonObject.getString("roles");
//        List<SysMenu> menuslist = JSON.parseArray(munus,SysMenu.class);
//        SysRoles sysRoles = JSON.parseObject(roles,SysRoles.class);
//        System.out.println("munuslist:"+menuslist);
//        System.out.println("sysRoles:"+sysRoles.toString());
//
//        return AjaxResponse.success();
//    }
    //根据角色id和菜单id查询中间表中是否存在该菜单
    @PostMapping("selectrolesidandmenusid")
    public AjaxResponse selectrolesidandmenusid(@RequestBody String a){
        JSONObject jsonObject= JSON.parseObject(a);
        String rolesidandmunesid = jsonObject.getString("rolesandmeun");
        System.out.println("rolesidandmunesid"+rolesidandmunesid);
        SysRolesMenu sysRolesMenu = JSONObject.parseObject(rolesidandmunesid,SysRolesMenu.class);
        System.out.println("sysRolesMenu:"+sysRolesMenu.toString());
        List<SysRolesMenu> list = this.sysMenuService.selectrolesidandmenusid(sysRolesMenu);
        System.out.println("list:"+list.toString());
        String message = "";
        if(list.size()<=0){
            this.sysMenuService.inserrolesidandmenusid(sysRolesMenu);
            message = "添加菜单成功！";
        }else{
            this.sysMenuService.deleterolesidandmenusid(sysRolesMenu);
            message = "已清空该节点对应菜单权限！";
        }
        return AjaxResponse.success(message);
    }
}
