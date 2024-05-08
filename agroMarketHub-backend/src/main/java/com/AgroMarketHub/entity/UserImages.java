package com.AgroMarketHub.entity;

import com.AgroMarketHub.user.UserEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_images")
public class UserImages {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	
	public UserImages() {
		super();
	}

	public long getId() {
		return id;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
	
}
