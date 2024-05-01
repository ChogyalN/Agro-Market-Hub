package com.AgroMarketHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AgroMarketHub.entity.DocsEntity;

@Repository
public interface DocsRepository extends JpaRepository<DocsEntity, Long>{

	
	
}
