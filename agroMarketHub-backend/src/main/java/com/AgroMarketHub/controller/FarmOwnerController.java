package com.AgroMarketHub.controller;

import com.AgroMarketHub.dto.FarmProductsDTO;
import com.AgroMarketHub.entity.FarmProducts;
import com.AgroMarketHub.serviceRequester.FarmOwnerRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.AgroMarketHub.dto.FarmOwnerDTO;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class FarmOwnerController {
	
	@Autowired
	FarmOwnerRequester farmOwnerRequester;
	
	@PostMapping("create_farmowner")
	private FarmOwnerDTO createFarmOwner(@RequestBody FarmOwnerDTO farmownerDTO) {
		return farmOwnerRequester.createFarmowner(farmownerDTO);
	}

	@PostMapping("create_product")
	private FarmProductsDTO createProduct(@RequestBody FarmProductsDTO farmProductsDTO){
		return farmOwnerRequester.createProducts(farmProductsDTO);
	}

	@GetMapping("getProducts")
	private List<FarmProducts> getAllProducts(){
		List<FarmProducts> all = farmOwnerRequester.getAllProducts();
		return farmOwnerRequester.getAllProducts();
	}
}
