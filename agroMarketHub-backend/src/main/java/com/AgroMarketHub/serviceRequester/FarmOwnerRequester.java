package com.AgroMarketHub.serviceRequester;

import com.AgroMarketHub.dto.FarmOwnerDTO;
import com.AgroMarketHub.dto.FarmProductsDTO;
import com.AgroMarketHub.entity.FarmProducts;

import java.util.List;

public interface FarmOwnerRequester {
	
	FarmOwnerDTO createFarmowner(FarmOwnerDTO farmOwnerDTO);

	FarmProductsDTO createProducts(FarmProductsDTO farmProductsDTO);

	List<FarmProducts> getAllProducts();
}
