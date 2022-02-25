package com.itexperts.projetofinal.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nameOwner;
	private String agencyCode;
	private String numberAccount;
	private String digitVerification;
	private String registerId;

	public Account() {
	}

	public Account(Integer id, String nameOwner, String agencyCode, String numberAccount, String digitVerification
			, String registerId) {
		this.id = id;
		this.nameOwner = nameOwner;
		this.agencyCode = agencyCode;
		this.numberAccount = numberAccount;
		this.digitVerification = digitVerification;
		this.registerId = registerId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getnameOwner() {
		return nameOwner;
	}

	public void setnameOwner(String nameOwner) {
		this.nameOwner = nameOwner;
	}
	
	public String getagencyCode() {
		return agencyCode;
	}

	public void setagencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}
	
	public String getnumberAccount() {
		return numberAccount;
	}

	public void setnumberAccount(String numberAccount) {
		this.numberAccount = numberAccount;
	}
	public String getdigitVerification() {
		return digitVerification;
	}

	public void setdigitVerification(String digitVerification) {
		this.digitVerification = digitVerification;
	}
	public String getregisterId() {
		return registerId;
	}

	public void setregisterId(String registerId) {
		this.registerId = registerId;
	}

}
