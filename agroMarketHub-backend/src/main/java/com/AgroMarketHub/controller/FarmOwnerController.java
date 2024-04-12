package com.AgroMarketHub.controller;

import com.AgroMarketHub.dto.FarmProductsDTO;
import com.AgroMarketHub.dto.MailDTO;
import com.AgroMarketHub.entity.FarmProducts;
import com.AgroMarketHub.serviceRequester.FarmOwnerRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

	@PostMapping(value = "create_product", produces = {MediaType.APPLICATION_JSON_VALUE})
	private FarmProductsDTO createProduct(@RequestBody FarmProductsDTO farmProductsDTO){
		return farmOwnerRequester.createProducts(farmProductsDTO);
	}

	@GetMapping("getProducts")
	private List<FarmProducts> getAllProducts(){
		List<FarmProducts> all = farmOwnerRequester.getAllProducts();
		return farmOwnerRequester.getAllProducts();
	}

	@DeleteMapping("deleteProductById/{id}")
	private void deleteById(@PathVariable long id){
		farmOwnerRequester.removeById(id);
	}

	@PutMapping(value = "updateProducts/{id}", produces={MediaType.APPLICATION_JSON_VALUE})
	private FarmProducts updateProduct(@PathVariable int id, @RequestBody FarmProductsDTO farmProductsDTO){
		return farmOwnerRequester.updateProduct(id, farmProductsDTO);
	}

	@PostMapping("mail")
	private void sendEmail(@RequestBody MailDTO mailDTO){
		farmOwnerRequester.sendEmail(mailDTO.getTo(), mailDTO.getSubject(), mailDTO.getText());
	}
}

