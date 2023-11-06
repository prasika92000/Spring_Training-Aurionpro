package com.aurionpro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account_type")
public class AccountType {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="type_id")
	    private Long typeid;
	    
	    @Column(name = "typename")
	    private String typename;

		public AccountType(Long typeid, String typename) {
			super();
			this.typeid = typeid;
			this.typename = typename;
		}

		public AccountType() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Long getTypeid() {
			return typeid;
		}

		public void setTypeid(Long typeid) {
			this.typeid = typeid;
		}

		public String getTypename() {
			return typename;
		}

		public void setTypename(String typename) {
			this.typename = typename;
		}
		
	   
}
