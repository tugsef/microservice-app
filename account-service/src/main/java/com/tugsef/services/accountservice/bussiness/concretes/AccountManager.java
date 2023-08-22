package com.tugsef.services.accountservice.bussiness.concretes;

import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.tugsef.services.accountservice.bussiness.abstracts.AccountService;
import com.tugsef.services.accountservice.bussiness.responses.AccountResponse;
import com.tugsef.services.accountservice.bussiness.rules.AccountBusinessRules;
import com.tugsef.services.accountservice.core.utilities.mapper.ModelMapperService;
import com.tugsef.services.accountservice.dataAccess.AccountRepository;
import com.tugsef.services.accountservice.entities.Account;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AccountManager implements AccountService {

	private AccountRepository accountRepository;
	private ModelMapperService modelMapperService;
	private AccountBusinessRules accountBusinessRules;
	
	@Override
	public AccountResponse get(String id) {
		this.accountBusinessRules.existsByIdFalse(id);
		Account account = this.accountRepository
												.findById(id)
												.orElseThrow();
		AccountResponse accountResponse = this.modelMapperService
												.forResponse()
												.map(account, AccountResponse.class);
		return accountResponse;

	}

	@Override
    @Transactional
	public AccountResponse save(AccountResponse accountResponse) {
		Account account = this.modelMapperService.forRequest().map(accountResponse, Account.class);
		this.accountRepository.save(account);
		accountResponse.setId(account.getId());
		return accountResponse;
	}

	@Override
	@Transactional
	public AccountResponse update(String id, AccountResponse accountResponse) {
		Assert.isNull(id, "Id cannot be null");
		this.accountBusinessRules.existsByIdFalse(id);
		Optional<Account> account = this.accountRepository.findById(id);
		  Account accountToUpdate = account.map(it -> {
	            it.setBirthDate(accountResponse.getBirthDate());
	            it.setName(accountResponse.getName());
	            it.setSurname(accountResponse.getSurname());
	            return it;
	        }).orElseThrow(IllegalArgumentException::new);
		return this.modelMapperService.forResponse().map(this.accountRepository.save(accountToUpdate), AccountResponse.class);
	}

	@Override
	@Transactional
	public void delete(String id) {
		this.accountRepository.deleteById(id);

	}

	@Override
	public Slice<AccountResponse> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	

}
