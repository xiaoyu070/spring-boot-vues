package com.trkj.projects.service.impl;

import com.trkj.projects.mybatis.dao.AddressDao;
import com.trkj.projects.mybatis.entity.Address;
import com.trkj.projects.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressDao addressDao;
    @Override
    public List<Address> findAll() {
        return addressDao.findAll();
    }
}
