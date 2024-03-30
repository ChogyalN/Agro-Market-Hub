package com.AgroMarketHub.serviceImpl;

import com.AgroMarketHub.dto.FarmProductsDTO;
import com.AgroMarketHub.entity.FarmProducts;
import com.AgroMarketHub.repository.FarmProductRepository;
import com.AgroMarketHub.serviceRequester.FarmOwnerRequester;
import org.springframework.beans.factory.annotation.Autowired;

import com.AgroMarketHub.dto.FarmOwnerDTO;
import com.AgroMarketHub.entity.FarmOwner;
import com.AgroMarketHub.repository.FarmOwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmOwnerImpl implements FarmOwnerRequester {
	@Autowired
	FarmOwnerRepository repository;

	@Autowired
	FarmProductRepository farmProductRepository;
		
	@Override
	public FarmOwnerDTO createFarmowner(FarmOwnerDTO farmOwnerDTO) {
		FarmOwner farmOwner;
		try {
			 farmOwner = new FarmOwner(farmOwnerDTO.getName(),
					farmOwnerDTO.getLocation(), 
					farmOwnerDTO.getAddress(),
					farmOwnerDTO.getFarmSize(),
					farmOwnerDTO.getPhoneNo(),
					 farmOwnerDTO.getDzongkhag(),
					 farmOwnerDTO.getGewog(),
					 farmOwnerDTO.getVillage());
			
			if(repository.save(farmOwner) != null) {
				farmOwnerDTO.setStatus();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return farmOwnerDTO;
	}

	@Override
	public FarmProductsDTO createProducts(FarmProductsDTO farmProductsDTO) {
		FarmProducts farmProducts;
		try{
			farmProducts = new FarmProducts(
					farmProductsDTO.getProductName(),
					farmProductsDTO.getProduct_desc(),
					farmProductsDTO.getQuantity(),
					farmProductsDTO.getUnitPrice(),
					farmProductsDTO.getQuantity(),
					farmProductsDTO.getAvailableDate(),
					farmProductsDTO.getProdtStatus()
			);
			if(farmProductRepository.save(farmProducts) != null){
				farmProductsDTO.setStatus();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return farmProductsDTO;
	}

	@Override
	public List<FarmProducts> getAllProducts() {
		List<FarmProducts> products= farmProductRepository.findAll();
		return farmProductRepository.findAll();
	}
}
