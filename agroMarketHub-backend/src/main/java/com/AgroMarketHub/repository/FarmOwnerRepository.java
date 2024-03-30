package com.AgroMarketHub.repository;

import com.AgroMarketHub.entity.FarmOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface FarmOwnerRepository extends JpaRepository<FarmOwner, Integer>{

}
