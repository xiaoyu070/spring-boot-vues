package com.trkj.projects.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.trkj.projects.anntation.Log;
import com.trkj.projects.mybatis.entity.SysMenu;
import com.trkj.projects.mybatis.entity.SysRoles;
import com.trkj.projects.mybatis.entity.SysUser;
import com.trkj.projects.mybatis.entity.SysUserRoles;
import com.trkj.projects.service.SysMenuService;
import com.trkj.projects.service.SysRolesService;
import com.trkj.projects.service.SysUserService;
import com.trkj.projects.util.JwtTokenUtil;
import com.trkj.projects.util.yan;
import com.trkj.projects.vo.AjaxResponse;
import com.trkj.projects.vo.SysUserVo;
import com.trkj.projects.vo.SysUser_roles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.Year;
import java.util.*;
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

    //用户
    @Resource
    private SysMenuService sysMenuService;

    //角色
    @Resource
    private SysRolesService sysRolesService;

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
    public AjaxResponse getChildrens(@RequestBody SysUser sysUser) {
        SysUser sysUser1=sysUserService.findByNames(sysUser);
        SysUserVo sysUserVo=new SysUserVo();
        if(!StringUtils.isEmpty(sysUser1)){
            if(sysUser1.getUserstate() == 0 && sysUser1.getUserStatie() == 0){
                sysUser1.setUserError(new Date());
                this.sysUserService.updateerror(new Date(),sysUser1.getUserId());
                //获取父菜单
                List<SysMenu> usermenu = sysMenuService.queryListById(sysUser1.getUserId());
                List<SysMenu> treemenu = usermenu.stream().filter(m -> m.getParentId() == 0).map(
                        (m) -> {
                            m.setChildMenu(getChildrens(m, usermenu));
                            return m;
                        }
                ).collect(Collectors.toList());
                String Token=jwtTokenUtil.generateToken(sysUser1.getUserName(),sysUser1.getUserId()+"");
                sysUserVo.setToken(Token);
                sysUserVo.setSysUser(sysUser1);
                sysUserVo.setVatedata(true);
                sysUserVo.setSysMenu(treemenu);
            }else if(sysUser1.getUserStatie() == 1){
                return AjaxResponse.success("该用户已被删除！");
            }else{
                return AjaxResponse.success("该用户已禁用，请联系管理员后进行登录！");
            }
        }else{
            return AjaxResponse.success("账户或密码有误，请检查后登入！");
        }
        return AjaxResponse.success(sysUserVo);
    }
    @GetMapping("Logincode")
    public AjaxResponse queryByPhone(String phone){
        Map<String,Object> map=new HashMap<>();
        System.out.println("phone:"+phone);
        SysUser list = this.sysUserService.findByPhone(phone);
        if(list.equals(null)){
            return AjaxResponse.success("没有该用户！");
        }else if( (list.getUserstate() == 1 && list.getUserStatie() == 0) || list.getUserstate() == 1 && list.getUserStatie() == 1){
            return AjaxResponse.success("该用户已被禁用！请联系管理员后进行登录！");
        }else if(list.getUserStatie() == 1){
            return AjaxResponse.success("该用户已被删除！");
        }else{
            yan yan=new yan();
            String codes=yan.yanzheng(phone,2);
            map.put("code",codes);
            return AjaxResponse.success(map);
        }
    }

    @GetMapping("LoginGo")
    public AjaxResponse queryByPhoneandCode(String phone,String code){
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.
                        getRequestAttributes()).getRequest();
        HttpSession session=request.getSession();
        SysUserVo sysUserVo = new SysUserVo();
        yan yan = new yan();
        Map<String,Object> map=new HashMap<>();
        if(yan.isphonecode(phone) == null || !yan.isphonecode(phone).equals(code)){
            SysUser sysUser1 = this.sysUserService.findByPhone(phone);
            if (!sysUser1.equals(null)) {
                if (sysUser1.getUserstate() == 0 && sysUser1.getUserStatie() == 0) {
                    sysUser1.setUserError(new Date());
                    this.sysUserService.updateerror(new Date(),sysUser1.getUserId());
                    //获取父菜单
                    List<SysMenu> usermenu = sysMenuService.queryListById(sysUser1.getUserId());
                    List<SysMenu> treemenu = usermenu.stream().filter(m -> m.getParentId() == 0).map(
                            (m) -> {
                                m.setChildMenu(getChildrens(m, usermenu));
                                return m;
                            }
                    ).collect(Collectors.toList());
                    String Token=jwtTokenUtil.generateToken(sysUser1.getUserName(),sysUser1.getUserId()+"");
                    sysUserVo.setToken(Token);
                    sysUserVo.setSysUser(sysUser1);
                    sysUserVo.setVatedata(true);
                    sysUserVo.setSysMenu(treemenu);
                }else if(sysUser1.getUserstate() == 1){
                    map.put("success","该用户已被禁用！");
                    return AjaxResponse.success(map);
                }else if(sysUser1.getUserStatie() == 1){
                    map.put("success","该用户已被删除！");
                    return AjaxResponse.success(map);
                }
            } else {
                map.put("success","没有该用户！");
                return AjaxResponse.success(map);
            }
        }else{
            map.put("success","该手机号与验证码不匹配！");
            return AjaxResponse.success(map);
        }
        return AjaxResponse.success(sysUserVo);
    }
    //根据当前登录的用户查询该用户的角色
    @GetMapping("findByUser_roles")
    public AjaxResponse findByUser_roles(int uid){
        SysUser_roles list=this.sysUserService.findByUser_roles(uid);
        return AjaxResponse.success(list);
    }
    //查询所有用户
    @PostMapping("selectuserall")
    public AjaxResponse selectuserall(@RequestBody String a){
        JSONObject jsonObject = JSON.parseObject(a);
        int  currenPage = jsonObject.getInteger("currenPage");
        int  pageSize = jsonObject.getInteger("pageSize");
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<SysUser_roles> list = this.sysUserService.selectuserall();
        Map<String,Object> map=new HashMap<>();
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }

    /**
     * 查询所有用户没有参数
     * @return
     */
    @GetMapping("findalluser")
    public AjaxResponse findalluser(){
        List<SysUser_roles> list = this.sysUserService.selectuserall();
        return AjaxResponse.success(list);
    }

    @PostMapping("selectallroles")
    public AjaxResponse selectallRoles(@RequestBody String a){
        JSONObject jsonObject = JSON.parseObject(a);
        int  currenPage = jsonObject.getInteger("currenPage");
        int  pageSize = jsonObject.getInteger("pageSize");
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<SysRoles> list = this.sysRolesService.selectall();
        Map<String,Object> map=new HashMap<>();
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    //新增角色
    @PostMapping("insertroles")
    public AjaxResponse insertroles(@RequestBody SysRoles sysRoles){
        sysRoles.setRolesLv(1);
        System.out.println("roles:"+sysRoles.toString());
        this.sysRolesService.insertroles(sysRoles);
        return AjaxResponse.success("新增角色成功!");
    }
    //修改角色
    @PostMapping("updateroles")
    public AjaxResponse updateroles(@RequestBody SysRoles sysRoles){
        System.out.println("roles:"+sysRoles.toString());
        this.sysRolesService.update(sysRoles);
        return AjaxResponse.success("角色信息修改成功!");
    }
    //删除用户
    @GetMapping("deleteroles")
    public AjaxResponse deleteroles(Integer id){
        List<SysUserRoles> list = this.sysRolesService.selectuseranroles(id);
        String message = "";
        if(list.size()<=0){
            message = "删除成功！";
            this.sysRolesService.deleteById(id);
        }else{
            message = "该角色下存在用户，不可删除！";
        }
        return AjaxResponse.success(message);
    }

    //修改角色状态
    @PostMapping("userstatechange")
    public AjaxResponse userstatechange(@RequestBody String a){
        JSONObject jsonObject = JSON.parseObject(a);
        Integer id = jsonObject.getInteger("id");
        Integer statie = jsonObject.getInteger("statie");
        String message = "";
        if(statie == 0){
            this.sysUserService.updateuserstatezero(id);
            message = "用户启用成功！";
        }else{
            this.sysUserService.updateuserstateone(id);
            message = "用户禁用成功！";
        }
        return AjaxResponse.success(message);
    }
    //模糊查询角色
    @PostMapping("likeusers")
    public AjaxResponse likeroles(@RequestBody String a){
        JSONObject jsonObject = JSON.parseObject(a);
        String rolestext = jsonObject.getString("ttt");
        int  currenPage = jsonObject.getInteger("currenPage");
        int  pageSize = jsonObject.getInteger("pageSize");
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<SysUser> list = this.sysUserService.likeusers(rolestext);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    //根据用户id修改对应的角色
    @GetMapping("updaterolesidanduser")
    public AjaxResponse updaterolesidanduser(@RequestBody String a){
        JSONObject jsonObject = JSON.parseObject(a);
        int userid = jsonObject.getInteger("userid");
        int rolesid = jsonObject.getInteger("rolesid");
        System.out.println("roles:"+rolesid+",,"+"user:"+userid);

        //修改用户修改的信息
        this.sysUserService.updateuserandroles(rolesid,userid);
        return AjaxResponse.success("修改角色成功！");
    }
    //新增用户
    @PostMapping("insertusers")
    public AjaxResponse insertusers(@RequestBody String a){
        JSONObject jsonObject = JSON.parseObject(a);
        String sys = jsonObject.getString("form");
        String roles = jsonObject.getString("roles");
        SysUser sysUser = JSONArray.parseObject(sys,SysUser.class);
        String str = roles.substring(roles.indexOf("[")+1,roles.indexOf("]"));
        String[] rolesid = str.split(",");
        SysUser list = this.sysUserService.findByNames(sysUser);
        SysUser list2 = this.sysUserService.findByPhone(sysUser.getUserPhone());
        String message = "";
        if(!StringUtils.isEmpty(list)){
            message = "该用户名已被使用!";
            return AjaxResponse.success(message);
        }else if(!StringUtils.isEmpty(list2)){
            message = "该手机号已被使用！";
            return AjaxResponse.success(message);
        }else{
            //新增成功后再查詢出該用戶的數據，添加他選擇的角色
            sysUser.setCreate_date(new Date());
            System.out.println("sysUser:users"+sysUser.toString());
            this.sysUserService.insertuser(sysUser);
            SysUser sss = this.sysUserService.findByNames(sysUser);
            System.out.println("sss"+sss.toString());
            for(int i = 0;i<rolesid.length;i++){
                System.out.println("rolesid:"+rolesid[i]);
                //新增用户选择的所有角色
                this.sysUserService.insertuserandroles(sss.getUserId(),Integer.parseInt(rolesid[i]));
            }
            message = "新增成功！";
        }
        return AjaxResponse.success(message);
    }
    //删除用户
    @GetMapping("deleteusers")
    public AjaxResponse deleteusers(int userid){
        System.out.println("userid:"+userid);
        this.sysUserService.deleteuserid(userid);
        return AjaxResponse.success("删除成功！");
    }
    //编辑用户信息
    @PostMapping("updateusers")
    public AjaxResponse updateusers(@RequestBody String a){
        Map<String,Object> map = new HashMap<>();
        JSONObject jsonObject = JSON.parseObject(a);
        String sys= jsonObject.getString("form");
        String roles= jsonObject.getString("roles");
        String str = roles.substring(roles.indexOf("[")+1,roles.indexOf("]"));
        String[] rolesid = str.split(",");
        SysUser sysUser = JSONArray.parseObject(sys,SysUser.class);
        //根据用户id删除中间表中所有的数据
        this.sysUserService.deleteuserandroles(sysUser.getUserId());
        for(int i = 0;i<rolesid.length;i++){
            //新增用户选择的所有角色
            this.sysUserService.insertuserandroles(sysUser.getUserId(),Integer.parseInt(rolesid[i]));
        }
        List<SysMenu> menulist = this.sysMenuService.queryListById(sysUser.getUserId());
        List<SysMenu> treemenu = menulist.stream().filter(m -> m.getParentId() == 0).map(
                (m) -> {
                    m.setChildMenu(getChildrens(m, menulist));
                    return m;
                }
        ).collect(Collectors.toList());
        map.put("message","修改成功！");
        map.put("sysMenu",treemenu);
        this.sysUserService.updateusers(sysUser);
        return AjaxResponse.success(map);
    }
    //修改个人信息
    @PostMapping("updateusersjc")
    public AjaxResponse userusersjc(@RequestBody String a){
        JSONObject jsonObject = JSON.parseObject(a);
        String users = jsonObject.getString("users");
        SysUser sysUser = JSONObject.parseObject(users,SysUser.class);
        System.out.println("sys:"+sysUser.toString());
        this.sysUserService.updateusers(sysUser);
        SysUser sysUser1 =this.sysUserService.findByUid(sysUser.getUserId());
        return AjaxResponse.success(getChildrens(sysUser1));
    }
    //根据userid查询对应的所有角色
    @PostMapping("findbyuseridroles")
    public AjaxResponse findbyuseridroles(@RequestBody String a){
        JSONObject jsonObject = JSON.parseObject(a);
        System.out.println("ssss"+jsonObject);
        int userid = jsonObject.getInteger("userid");
        int currenPage = jsonObject.getInteger("currenPage");
        int pageSize = jsonObject.getInteger("pageSize");
        System.out.println("user:"+userid+","+"ccc:"+currenPage+"..."+pageSize);
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<SysRoles> list=this.sysRolesService.findbyuseridroles(userid);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    //根据用户id查询用户
    @GetMapping("findByuseruids")
    public AjaxResponse findByuseruids(Integer uid){
        return AjaxResponse.success(this.sysUserService.findByUid(uid));
    }
}