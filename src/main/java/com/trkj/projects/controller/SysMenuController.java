package com.trkj.projects.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.trkj.projects.mybatis.entity.SysMenu;
import com.trkj.projects.mybatis.entity.SysRoles;
import com.trkj.projects.mybatis.entity.SysRolesMenu;
import com.trkj.projects.service.SysMenuService;
import com.trkj.projects.service.SysRolesService;
import com.trkj.projects.vo.AjaxResponse;
import com.trkj.projects.vo.MenusVo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    private SysRolesService sysRolesService;
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
    //新增一个用户
    @PostMapping("addrolesidandmenusid")
    public AjaxResponse addrolesidandmenusid(@RequestBody String a){
        JSONObject jsonObject= JSON.parseObject(a);
        //将传入的角色id拿到
        int sysRolesId = jsonObject.getInteger("sysRolesId");
        //将转换成js格式的数据通过name拿到后转换成string类型
        String sysMenu = jsonObject.getString("sysMenuId");
        //将拿到的菜单编号转换成list集合
        List<Integer> sysMenuId = JSONObject.parseArray(sysMenu,Integer.class);
        List<SysRolesMenu> sysRolesMenuList =new ArrayList<>();
        //将转换成integer类型的list数组循环添加到实体类中
        for (int i=0;i<sysMenuId.size();i++){
            SysRolesMenu ttt = new SysRolesMenu();
            ttt.setSysRolesId(sysRolesId);
            ttt.setSysMenuId(sysMenuId.get(i));
            //将传入到实体类中的角色id和对应的菜单id一个一个添加到list数组中
            sysRolesMenuList.add(ttt);
        }
        //先清空该角色的所有菜单权限
        this.sysMenuService.deleterolesid(sysRolesId);
        //然后将传过来的角色id和菜单权限进行批量新增
        this.sysMenuService.addallrolesidandmenusid(sysRolesMenuList);
        return AjaxResponse.success("修改角色权限成功！");
    }
}
