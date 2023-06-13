package com.example.demo2.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
@Embeddable
public class RoleUserPK implements Serializable {
	private int role;
	private int user;
	
	public RoleUserPK() {
		super();
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

}
