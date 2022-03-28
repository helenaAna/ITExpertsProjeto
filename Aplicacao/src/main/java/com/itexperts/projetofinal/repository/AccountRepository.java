package com.itexperts.projetofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itexperts.projetofinal.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}