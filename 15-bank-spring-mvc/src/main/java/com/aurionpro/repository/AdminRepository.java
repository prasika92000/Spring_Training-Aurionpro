package com.aurionpro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	Admin findByAdminFirstName(String firstname);

	List<Admin> findByAdminLastName(String lastname);

}
