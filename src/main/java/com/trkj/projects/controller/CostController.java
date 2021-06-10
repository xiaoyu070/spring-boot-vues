package com.trkj.projects.controller;

import com.trkj.projects.mybatis.entity.Cost;
import com.trkj.projects.service.CostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("cost")
public class CostController {
    @Resource
    private CostService service;
    @GetMapping("selectcostAll")
    public List<Cost> findAll(@RequestParam("Projecttype") String Projecttype){
        return service.selectAll(Projecttype);
    }
}
