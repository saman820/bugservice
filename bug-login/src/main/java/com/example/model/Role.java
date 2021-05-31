package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", unique = true, nullable = false)
	private int roleId;
	@Column(name = "role", nullable = false)
	private String role;
	public Role(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}
	public Role(String role) {
		super();
		this.role = role;
	}
	public Role() {
		super();
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", role=" + role + "]";
	}
}