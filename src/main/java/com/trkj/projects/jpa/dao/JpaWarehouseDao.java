package com.trkj.projects.jpa.dao;


import com.trkj.projects.jpa.entity.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaWarehouseDao extends JpaRepository<WarehouseEntity, Long> {

}
