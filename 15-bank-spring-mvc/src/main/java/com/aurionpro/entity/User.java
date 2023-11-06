package com.aurionpro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="user_id")
	    private Long userId;
	    
	    @Column(name = "username")
	    private String username;
	    
	    @Column(name = "password")
	    private String password;
	    
	    @ManyToOne
	    @JoinColumn(name="fk_role_id")
		private Role role;

		public User(Long userid, String username, String password, Role role) {
			super();
			this.userId = userid;
			this.username = username;
			this.password = password;
			this.role = role;
		}

		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Long getUserid() {
			return userId;
		}

		public void setUserid(Long userid) {
			this.userId = userid;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}
		
	    
		
	    
	    
}
