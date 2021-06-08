package com.trkj.projects.service;


import com.trkj.projects.mybatis.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAll();
}
