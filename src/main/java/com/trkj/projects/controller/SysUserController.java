package com.trkj.projects.controller;

import com.trkj.projects.mybatis.entity.SysMenu;
import com.trkj.projects.mybatis.entity.SysUser;
import com.trkj.projects.service.SysMenuService;
import com.trkj.projects.service.SysUserService;
import com.trkj.projects.util.JwtTokenUtil;
import com.trkj.projects.util.yan;
import com.trkj.projects.vo.AjaxResponse;
import com.trkj.projects.vo.SysUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2021-05-25 09:00:53
 */
@Slf4j
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysMenuService sysMenuService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
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

    @PostMapping("Login")
    private AjaxResponse getChildrens(@RequestBody SysUser sysUser) {
        SysUser sysUser1=sysUserService.findByNames(sysUser.getUserName(),sysUser.getUserPass());
        SysUserVo sysUserVo=new SysUserVo();
        System.out.println(sysUser.getUserName()+"");
        if(!sysUser1.equals(null)){
            if(sysUser1.getUserstate()==0){
                //获取父菜单
                List<SysMenu> usermenu = sysMenuService.queryListById(sysUser1.getUserId());
                List<SysMenu> treemenu = usermenu.stream().filter(m -> m.getParentId() == 0).map(
                        (m) -> {
                            m.setChildMenu(getChildrens(m, usermenu));
                            return m;
                        }
                ).collect(Collectors.toList());
                System.out.println(treemenu);
                String Token=jwtTokenUtil.generateToken(sysUser1.getUserName(),sysUser1.getUserId()+"");
                sysUserVo.setToken(Token);
                sysUserVo.setSysUser(sysUser1);
                sysUserVo.setVatedata(true);
                sysUserVo.setSysMenu(treemenu);
            }else{
                return AjaxResponse.success("该用户已禁用，请联系管理员后进行登录！");
            }
            return AjaxResponse.success(sysUserVo);
        }else{
            return AjaxResponse.success("没有该用户！");
        }
    }
    @GetMapping("Logincode")
    public AjaxResponse queryByPhone(String phone){
        System.out.println("phone:"+phone);
        Map<String,Object> map=new HashMap<>();
        SysUser list = this.sysUserService.findByPhone(phone);
        if(list.equals(null)){
            return AjaxResponse.success("没有该用户！");
        }else if(list.getUserstate()==1){
            return AjaxResponse.success("该用户已被禁用！请联系管理员后进行登录！");
        }else{
            yan yan=new yan();
            String codes=yan.yanzheng(phone,2);
            map.put("code",codes);
            return AjaxResponse.success(map);
        }
    }

    @GetMapping("LoginGo")
    public AjaxResponse queryByPhoneandCode(String phone,String code){
        System.out.println("phone:"+phone+"mmmm"+"code"+code);
        Map<String,String> mapyz=yan.mm();
        System.out.println("mapyz:"+mapyz.get("phone")+","+mapyz.get("code"));
        Map<String,Object> map=new HashMap<>();
        if(mapyz.get("phone").equals(phone) && mapyz.get("code").equals(code)){
            SysUserVo sysUserVo = new SysUserVo();
            SysUser list = this.sysUserService.findByPhone(phone);
            if (!list.equals(null)) {
                if (list.getUserstate() == 0) {
                    //获取父菜单
                    List<SysMenu> usermenu = sysMenuService.queryListById(list.getUserId());
                    List<SysMenu> treemenu = usermenu.stream().filter(m -> m.getParentId() == 0).map(
                            (m) -> {
                                m.setChildMenu(getChildrens(m, usermenu));
                                return m;
                            }
                    ).collect(Collectors.toList());
                    System.out.println(treemenu);
                    String Token = jwtTokenUtil.generateToken(list.getUserName(), list.getUserId() + "");
                    sysUserVo.setToken(Token);
                    sysUserVo.setSysUser(list);
                    sysUserVo.setVatedata(true);
                    sysUserVo.setSysMenu(treemenu);
                    map.put("vo",sysUserVo);
                }
            } else {
                map.put("success","没有该用户！");
            }
        }else{
            map.put("success","该手机号与验证码不匹配！");
        }
        return AjaxResponse.success(map);
    }
}