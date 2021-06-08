package com.trkj.projects.controller;


import com.trkj.projects.mybatis.entity.Address;
import com.trkj.projects.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {
    @Resource
    private AddressService addressService;

    @GetMapping("findaddress")
    public List<Address> findall(){
        return addressService.findAll();
    }
}
