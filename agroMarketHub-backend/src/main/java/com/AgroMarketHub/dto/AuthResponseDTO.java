package com.AgroMarketHub.dto;

public class AuthResponseDTO {
	
	private String userName;
	private String token;
	
	public AuthResponseDTO() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "AuthResponseDTO [userName=" + userName + ", token=" + token + "]";
	}
	
	

}
