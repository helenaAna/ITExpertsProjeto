package com.itexperts.projetofinal.controller;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping
	public ResponseEntity<Page<Account>> getAll(Pageable pageable){
		 Page<Account> accountList = accountService.findAll(pageable);		
		return ResponseEntity.ok().body(accountList);
	}
	
	@PostMapping
	public ResponseEntity<Account> create(@RequestBody Account account){
		Account a = accountService.create(account);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(a.getId()).toUri();	
		
		return ResponseEntity.created(location).body(a);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Account> update(@RequestBody Account account, @PathVariable Integer id){
		account = accountService.update(account, id);
		return ResponseEntity.ok().body(account);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Account> delete(@PathVariable Integer id){
		accountService.delete(id);
		return ResponseEntity.noContent().build();
		}
}
