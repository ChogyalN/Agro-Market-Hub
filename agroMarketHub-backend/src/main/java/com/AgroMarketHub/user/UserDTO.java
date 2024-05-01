package com.AgroMarketHub.user;

import com.AgroMarketHub.entity.Role;

import java.util.List;
import java.util.Set;

public class UserDTO {
	private String firstName;
	private String lastName;
	private String email;
    private String userName;
    private String password;
    
    private List<String> roles;

    public UserDTO() {
    }

    
    public UserDTO(String firstName, String lastName, String email, String password,
			Set<String> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFisrtName() {
		return this.firstName;
	}

	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void setEmail(String email) {
		this.email = email;
	}

    public String getUserName(String firstName, String lastName) {
        return this.userName = firstName.trim().concat(Character.toString(lastName.charAt(0)).toUpperCase());
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
