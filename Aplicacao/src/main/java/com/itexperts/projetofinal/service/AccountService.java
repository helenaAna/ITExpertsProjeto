package com.itexperts.projetofinal.service;

import org.springframework.stereotype.Service;

import com.itexperts.projetofinal.model.Account;
import com.itexperts.projetofinal.repository.AccountRepository;

@Service
public class AccountService {
	
	private AccountRepository accountRepository;	
	
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public Account create (Account account) {
		Account a = new Account();
		a.setnameOwner(account.getnameOwner());
		a.setagencyCode(account.getagencyCode());
		a.setnumberAccount(account.getnumberAccount());
		a.setregisterId(account.getregisterId());
		a.setdigitVerification(account.getdigitVerification());
		
		accountRepository.save(a);
		return a;		
		}
}
