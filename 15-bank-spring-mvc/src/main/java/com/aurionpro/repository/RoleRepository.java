package com.aurionpro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRolename(String rolename);



}
