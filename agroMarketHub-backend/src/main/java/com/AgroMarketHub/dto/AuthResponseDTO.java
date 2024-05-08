package com.AgroMarketHub.dto;

public class AuthResponseDTO {
	
	private String userName;
	private String token;
	private long id;
	
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
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AuthResponseDTO [userName=" + userName + ", token=" + token + "]";
	}
	
	

}
