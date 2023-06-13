package com.example.demo2.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity

public class RoleUser {
	   @EmbeddedId
	    private RoleUserPK pk;
	    @ManyToOne
	    @JoinColumn(name = "role", insertable = false, updatable = false)
	    private Role role;
	    @ManyToOne
	    @JoinColumn(name = "user", insertable = false, updatable = false)
	    private User user;
		public RoleUser() {
			super();
		}
		public RoleUser(RoleUserPK pk, Role role, User user) {
			super();
			this.pk = pk;
			this.role = role;
			this.user = user;
		}
		public RoleUserPK getPk() {
			return pk;
		}
		public void setPk(RoleUserPK pk) {
			this.pk = pk;
		}
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
	    
	    
}
