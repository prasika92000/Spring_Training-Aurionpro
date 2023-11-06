package com.aurionpro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Long roleId;

	@Column(name = "rolename")
	private String rolename;

	public Role(Long role_id, String rolename) {
		super();
		this.roleId = role_id;
		this.rolename = rolename;
	}

	public Role() {
		super();
	}

	public Long getRole_id() {
		return roleId;
	}

	public void setRole_id(Long role_id) {
		this.roleId = role_id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
