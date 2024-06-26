package com.AgroMarketHub.user;

import com.AgroMarketHub.entity.DocsEntity;
import com.AgroMarketHub.entity.Role;
import com.AgroMarketHub.entity.UserImages;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String password;
    
    @Column(unique = true)
    private String userName;
    
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserImages> userImages;

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
	
	@OneToMany(mappedBy = "user")
    private List<DocsEntity> docsEntities;

    public UserEntity() {}

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public String getFirstName() {
  		return firstName;
  	}

  	public void setFirstName(String firstName) {
  		this.firstName = firstName;
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

  	public void setEmail(String email) {
  		this.email = email;
  	}

	public List<DocsEntity> getDocsEntity() {
		return docsEntities;
	}

	public void setDocsEntity(List<DocsEntity> docsEntity) {
		this.docsEntities = docsEntity;
	}
  	
}