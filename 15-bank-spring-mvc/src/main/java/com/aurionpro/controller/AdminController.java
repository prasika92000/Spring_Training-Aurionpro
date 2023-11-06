package com.aurionpro.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Admin;
import com.aurionpro.service.AdminService;

import jakarta.persistence.NonUniqueResultException;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}

	    @PostMapping("/create")
	    public Admin createAdmin(@RequestBody Admin admin) {
	        return adminService.createAdmin(admin);
	    }
	   
//	    @PostMapping("/create")
//	    public Admin createAdmin(@RequestBody Admin admin) {
//	        User user = admin.getUser(); // Get the associated user
//	        User savedUser = userService.createUser(user); // Save the user
//	        admin.setUser(savedUser); // Set the saved user in the admin entity
//	        return adminService.createAdmin(admin); // Save the admin entity
//	    }

	@GetMapping("/{id}")
	public Admin getAdmin(@PathVariable Long id) {
		return adminService.getAdminById(id);
	}

	@PutMapping("/{id}")
	public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
		return adminService.updateAdmin(id, admin);
	}

	@DeleteMapping("/{id}")
	public void deleteAdmin(@PathVariable Long id) {
		adminService.deleteAdmin(id);
	}

	@GetMapping("/list")
	public List<Admin> listAllAdmins() {
		return adminService.listAllAdmins();
	}

	@GetMapping("/getByFirstname/{firstname}")
	public Admin getAdminByFirstname(@PathVariable String firstname) {
		return adminService.getAdminByFirstname(firstname);
	}

	@GetMapping("/getByLastname/{lastname}")
	public ResponseEntity<?> getAdminByLastname(@PathVariable String lastname) {
		try {
			List<Admin> admin = adminService.getAdminByLastname(lastname);
			return ResponseEntity.ok(admin);
		} catch (NonUniqueResultException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Multiple admins found with the same last name: " + lastname);
		}
	}

}
