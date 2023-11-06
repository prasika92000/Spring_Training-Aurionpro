package com.aurionpro.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Role;
import com.aurionpro.entity.User;
import com.aurionpro.repository.RoleRepository;
import com.aurionpro.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public User updateUser(Long id, User user) {
		if (userRepository.existsById(id)) {
			user.setUserid(id); // Set the ID in the entity
			return userRepository.save(user);
		} else {
			return null;
		}
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public List<User> listAllUsers() {
		return userRepository.findAll();
	}

	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public List<User> getUsersByRoleId(Long roleId) {
	    return userRepository.findByRoleRoleId(roleId);
	}
	}

//	public List<User> getUsersByRoleId(Long roleId) {
//		Role role = RoleRepository.findByRoleid(roleId);
//		if (role != null) {
//			return userRepository.findByRole(role);
//		} else {
//			return Collections.emptyList();
//		}
//	}


