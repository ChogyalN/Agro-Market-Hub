package com.AgroMarketHub.dto;

import org.springframework.beans.factory.annotation.Value;

public class FarmOwnerDTO {
	private String name;
	private String location;
	private String address;
	private String farmSize;
	private long phoneNo;
	private String dzongkhag;
	private String gewog;
	private String village;
	@Value("${message.status}")
	String status;

	public FarmOwnerDTO() {
	}

	public FarmOwnerDTO(String name, String location, String address, String farmSize, long phoneNo, String dzongkhag, String gewog, String village) {
		this.name = name;
		this.location = location;
		this.address = address;
		this.farmSize = farmSize;
		this.phoneNo = phoneNo;
		this.dzongkhag = dzongkhag;
		this.gewog = gewog;
		this.village = village;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFarmSize() {
		return farmSize;
	}

	public void setFarmSize(String farmSize) {
		this.farmSize = farmSize;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(){
		this.status = "message.status";
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getDzongkhag() {
		return dzongkhag;
	}

	public void setDzongkhag(String dzongkhag) {
		this.dzongkhag = dzongkhag;
	}

	public String getGewog() {
		return gewog;
	}

	public void setGewog(String gewog) {
		this.gewog = gewog;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}
}
