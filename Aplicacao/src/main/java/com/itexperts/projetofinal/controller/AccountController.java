package com.itexperts.projetofinal.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itexperts.projetofinal.model.Account;
import com.itexperts.projetofinal.service.AccountService;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {
	
	private final AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@PostMapping
	public ResponseEntity<Account> create(@RequestBody Account account){
		Account a = accountService.create(account);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(a.getId()).toUri();	
		
		return ResponseEntity.created(location).body(a);
	}

}