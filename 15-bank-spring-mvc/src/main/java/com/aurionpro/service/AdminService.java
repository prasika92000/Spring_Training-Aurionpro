package com.aurionpro.service;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Admin;
import com.aurionpro.repository.AdminRepository;

import jakarta.persistence.NonUniqueResultException;

@Service
public class AdminService {

	private final AdminRepository adminRepository;
	
	@Autowired
	private UserService userService;

	@Autowired
	public AdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	public Admin createAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
//	 public Admin createAdmin(Admin admin) {
//	        // Create or update the user
//	        User user = admin.getUser();
//	        User savedUser = userService.createUser(user); // Save or update the user
//	        admin.setUser(savedUser); // Set the saved user in the admin entity
//
//	        // Now you can save the admin entity
//	        return adminRepository.save(admin);
//	    }

	public Admin getAdminById(Long id) {
		return adminRepository.findById(id).orElse(null);
	}

	public Admin updateAdmin(Long id, Admin admin) {
	    if (adminRepository.existsById(id)) {
	        admin.setAdminId(id); // Set the ID in the entity
	        return adminRepository.save(admin);
	    } else {
	        return null; // Handle non-existent admin
	    }
	}

	public void deleteAdmin(Long id) {
		adminRepository.deleteById(id);
	}

	public List<Admin> listAllAdmins() {
		return adminRepository.findAll();
	}

	public Admin getAdminByFirstname(String firstname) {
		return adminRepository.findByAdminFirstName(firstname);
	}

	public List<Admin> getAdminByLastname(String lastname) {
	    List<Admin> admins = adminRepository.findByAdminLastName(lastname);
	    return admins;
	}
	
}

	
