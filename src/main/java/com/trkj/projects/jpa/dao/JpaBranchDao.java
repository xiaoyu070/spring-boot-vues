package com.trkj.projects.jpa.dao;

import com.trkj.projects.jpa.entity.BranchEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaBranchDao extends CrudRepository<BranchEntity,Integer> {
   public Page<BranchEntity> findAll(Pageable pageable);
   public List<BranchEntity> findAll();
}
