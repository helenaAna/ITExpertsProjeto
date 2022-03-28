package com.itexperts.projetofinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Size(max = 50, message = "NameOwner deve ter no máximo 50 caracteres")
    @NotBlank(message = "NameOwner é obrigatório")
	@Column(name = "NAMEOWNER")
	private String nameOwner;
   
	@Size(max = 4, message = "AgencyCode deve ter no máximo 4 caracteres")
    @NotBlank(message = "AgencyCode é obrigatório")
	@Column(name = "AGENCYCODE")
	private String agencyCode;
   
	@Size(max = 8, message = "NumberAccount deve ter no máximo 8 caracteres")
    @NotBlank(message = "NumberAccount é obrigatório")
	@Column(name = "NUMBERACCOUNT")
	private String numberAccount;
    
	@Size(max = 3, message = "DigitVerification deve ter no máximo 3 caracteres")
    @NotBlank(message = "DigitVerification é obrigatório")
	@Column(name = "DIGITVERIFICATION")
	private String digitVerification;
   
	@Size(max = 20, message = "RegisterId deve ter no máximo 20 caracteres")
	@NotBlank(message = "RegisterId é obrigatório")
	@Column(name = "REGISTERID")
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
