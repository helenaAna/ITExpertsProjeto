package com.itexperts.projetofinal.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itexperts.projetofinal.model.Account;
import com.itexperts.projetofinal.repository.AccountRepository;
import com.itexperts.projetofinal.service.exception.ContaException;
import com.itexperts.projetofinal.service.exception.RecursoNaoEncontradoException;

@Service
public class AccountService {
	
	private AccountRepository accountRepository;	
	
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public Page<Account> findAll(Pageable pageable){
		Page<Account> list = accountRepository.findAll(pageable);		
		return list;
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
	
	@Transactional
	public Account update(Account account, Integer id) {		
		try {
			Optional<Account> a = accountRepository.findById(id);
			a.get().setnameOwner(account.getnameOwner());
			a.get().setagencyCode(account.getagencyCode());	
			a.get().setnumberAccount(account.getnumberAccount());
			a.get().setdigitVerification(account.getdigitVerification());
			a.get().setregisterId(account.getregisterId());
			accountRepository.save(a.get());			
			return a.get();			
		}catch(EntityNotFoundException e ) {
			throw new RecursoNaoEncontradoException("Id: "+id+" não foi encontrado");
		}catch(NoSuchElementException e ) {
			throw new RecursoNaoEncontradoException("Id: "+id+" não foi encontrado");
		}
	}
	
	@Transactional
	public void delete(Integer id) {
		try {			 
			accountRepository.deleteById(id);
			
		}catch(EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoException("Id: "+id+" não foi encontrado");
		}catch(DataIntegrityViolationException e) {
			throw new ContaException("Integridade violada!");
		}
	}
	
	
}
