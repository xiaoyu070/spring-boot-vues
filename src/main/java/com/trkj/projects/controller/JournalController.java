package com.trkj.projects.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.trkj.projects.mybatis.entity.Journal;
import com.trkj.projects.service.JournalService;
import com.trkj.projects.service.SysUserService;
import com.trkj.projects.vo.AjaxResponse;
import com.trkj.projects.vo.JournalVo;
import org.assertj.core.util.DateUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * (Journal)表控制层
 *
 * @author makejava
 * @since 2021-06-16 23:33:28
 */
@RestController
@RequestMapping("journal")
public class JournalController {
    /**
     * 服务对象
     */
    @Resource
    private JournalService journalService;
    @Resource
    private SysUserService sysUserService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Journal selectOne(Integer id) {
        return this.journalService.queryById(id);
    }

    @PostMapping("findAll")
    public AjaxResponse findAll(@RequestBody String a){
        JSONObject jsonObject = JSON.parseObject(a);
        Integer currenPage = jsonObject.getInteger("currenPage");
        Integer pageSize = jsonObject.getInteger("pageSize");
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<Journal> list = this.journalService.findAll();
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    @PostMapping("findByuserId")
    public AjaxResponse findByuserId(@RequestBody String a){
        JSONObject jsonObject = JSON.parseObject(a);
        Integer currenPage = jsonObject.getInteger("currenPage");
        Integer pageSize = jsonObject.getInteger("pageSize");
        int userid = jsonObject.getInteger("userid");
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<Journal> list = this.journalService.findByuserId(userid);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    @PostMapping("findBylike")
    public AjaxResponse findBylike(@RequestBody String a){
        JSONObject jsonObject = JSON.parseObject(a);
        Integer currenPage = jsonObject.getInteger("currenPage");
        Integer pageSize = jsonObject.getInteger("pageSize");
        String text = jsonObject.getString("text");
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<Journal> list = this.journalService.findAlllike(text);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    @PostMapping("findDates")
    public AjaxResponse findDates(@RequestBody String a) throws ParseException {
        JSONObject jsonObject = JSON.parseObject(a);
        Integer currenPage = jsonObject.getInteger("currenPage");
        Integer pageSize = jsonObject.getInteger("pageSize");
        String dates = jsonObject.getString("dates");
        char i = dates.charAt(9);
        int num = Integer.parseInt(String.valueOf(i));
        String as=String.valueOf(num);
        StringBuilder sb=new StringBuilder(as);
        String time=dates.substring(0,9);
        sb.insert(0,time);
        time=sb.toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(time));
        c.add(Calendar.DATE, 1);
        time = sdf.format(c.getTime());
        time=time+"%";
        Map<String,Object> map=new HashMap<>();
        Page<Object> pg= PageHelper.startPage(currenPage,pageSize);
        List<JournalVo> list = this.journalService.selectdates(time);
        map.put("total",pg.getTotal());
        map.put("rows",list);
        return AjaxResponse.success(map);
    }
    @GetMapping("findUsers")
    public AjaxResponse findUsers(){
        return AjaxResponse.success(this.sysUserService.findByuserAll());
    }
}
