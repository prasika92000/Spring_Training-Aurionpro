package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.AccountType;
import com.aurionpro.repository.AccountTypeRepository;

@Service
public class AccountTypeService {

	@Autowired
	private AccountTypeRepository accountTypeRepository;

	 public AccountTypeService(AccountTypeRepository accountTypeRepository) {
	        this.accountTypeRepository = accountTypeRepository;
	    }

	    public AccountType createAccountType(AccountType accountType) {
	        return accountTypeRepository.save(accountType);
	    }

	    public AccountType getAccountTypeById(Long id) {
	        return accountTypeRepository.findById(id).orElse(null);
	    }

	    public AccountType updateAccountType(Long id, AccountType accountType) {
	        if (accountTypeRepository.existsById(id)) {
	            accountType.setTypeid(id); // Set the ID in the entity
	            return accountTypeRepository.save(accountType);
	        } else {
	            return null; // Handle not found error
	        }
	    }

	    public void deleteAccountType(Long id) {
	        accountTypeRepository.deleteById(id);
	    }

	    public List<AccountType> listAllAccountTypes() {
	        return accountTypeRepository.findAll();
	    }
}
