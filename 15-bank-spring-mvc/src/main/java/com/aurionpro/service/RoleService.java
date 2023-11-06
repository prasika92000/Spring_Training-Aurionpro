package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Role;
import com.aurionpro.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	
	public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public Role updateRole(Long id, Role role) {
        if (roleRepository.existsById(id)) {
            role.setRole_id(id); // Update the attribute name
            return roleRepository.save(role);
        } else {
            return null; // Handle not found error
        }
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    public List<Role> listAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleByRolename(String rolename) {
        return roleRepository.findByRolename(rolename);
    }

    public Role getRoleByid(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

}
