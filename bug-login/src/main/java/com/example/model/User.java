package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="username")
    private String userName;
	
	@Column(name="password")
    private String password;
	
	@Column(name="profile_picture")
    private String profilePicture;
	
	@Column(name="role_id")
    private String roleId;

	public User(String userName, String password, String profilePicture, String roleId) {
		super();
		this.userName = userName;
		this.password = password;
		this.profilePicture = profilePicture;
		this.roleId = roleId;
	}
	


	
    
    
	
    
    

}
