package com.aurionpro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aurionpro.entity.Role;
import com.aurionpro.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

//	User findByUsername(String username);

//	List<User> findByRole(Role role);
	User findByUsername(String username);

//	List<User> findByRoleRole_id(Long role_id);
	List<User> findByRoleRoleId(Long roleId);



//    @Query("SELECT u FROM User u WHERE u.role.roleId = :roleId")
//    List<User> findByRoleId(@Param("roleId") Long roleId);

	
}
