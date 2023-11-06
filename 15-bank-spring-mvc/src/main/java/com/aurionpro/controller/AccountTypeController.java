package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.AccountType;
import com.aurionpro.service.AccountTypeService;

@RestController
@RequestMapping("/accountType")
public class AccountTypeController {
    @Autowired
    private AccountTypeService accountTypeService;

    @PostMapping("/create")
    public AccountType createAccountType(@RequestBody AccountType accountType) {
        return accountTypeService.createAccountType(accountType);
    }

    @GetMapping("/{id}")
    public AccountType getAccountType(@PathVariable Long id) {
        return accountTypeService.getAccountTypeById(id);
    }

    @PutMapping("/{id}")
    public AccountType updateAccountType(@PathVariable Long id, @RequestBody AccountType accountType) {
        return accountTypeService.updateAccountType(id, accountType);
    }

    @DeleteMapping("/{id}")
    public void deleteAccountType(@PathVariable Long id) {
        accountTypeService.deleteAccountType(id);
    }

    @GetMapping("/list")
    public List<AccountType> listAllAccountTypes() {
        return accountTypeService.listAllAccountTypes();
    }
}
