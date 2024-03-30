package com.AgroMarketHub.repository;

import com.AgroMarketHub.entity.FarmProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmProductRepository extends JpaRepository<FarmProducts, Long> {
}
