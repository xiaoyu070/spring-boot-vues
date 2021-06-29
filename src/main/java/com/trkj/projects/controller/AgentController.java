package com.trkj.projects.controller;

import com.trkj.projects.anntation.Log;
import com.trkj.projects.mybatis.entity.Agent;
import com.trkj.projects.service.AgentService;
import com.trkj.projects.vo.AjaxResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Agent)表控制层
 *
 * @author makejava
 * @since 2021-06-03 18:50:18
 */
@RestController
@RequestMapping("agent")
public class AgentController {
    /**
     * 服务对象
     */
    @Resource
    private AgentService agentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Agent selectOne(Integer id) {
        return this.agentService.queryById(id);
    }

    @GetMapping("selectbyall")
    public AjaxResponse selectbyall(int id){
        List<Agent> list=this.agentService.querybyBranchid(id);
        return AjaxResponse.success(list);
    }


    /**
     * 查询所有经办人
     * @return
     */
    @Log("查询所有经办人")
    @GetMapping("selectAgentname")
    public AjaxResponse selectAgentname(){
        List<Agent> list=this.agentService.slectagentname();
        return AjaxResponse.success(list);
    }


}
