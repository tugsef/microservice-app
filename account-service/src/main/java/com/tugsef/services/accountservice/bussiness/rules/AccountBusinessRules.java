package com.tugsef.services.accountservice.bussiness.rules;

import org.springframework.stereotype.Service;

import com.tugsef.services.accountservice.core.utilities.exception.BussinessException;
import com.tugsef.services.accountservice.dataAccess.AccountRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class AccountBusinessRules {

	private AccountRepository accountRepository;
	
	public void existsByUserName(String username) {
		if (this.accountRepository.existsByUsername(username))
			throw new BussinessException("Username already exists");
	}
	
	public void existsByEmail(String email) {
		if (this.accountRepository.existsByUsername(email))
			throw new BussinessException("Email already exists");
	}
	
	public void existsById(String id) {
		if(this.accountRepository.existsById(id))
			throw new BussinessException("id already exists");
	}
	
	public void existsByIdFalse(String id) {
		if(!this.accountRepository.existsById(id))
			throw new BussinessException("id already exists");
	}
}
