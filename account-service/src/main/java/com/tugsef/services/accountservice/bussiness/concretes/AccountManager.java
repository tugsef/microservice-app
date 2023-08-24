package com.tugsef.services.accountservice.bussiness.concretes;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.tugsef.services.accountservice.bussiness.abstracts.AccountService;
import com.tugsef.services.accountservice.dataAccess.AccountRepository;
import com.tugsef.services.accountservice.entities.Account;
import com.tugsef.services.servicecommon.client.contract.AccountResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AccountManager implements AccountService {

	 private final AccountRepository accountRepository;
	    private final ModelMapper modelMapper;


	    public AccountResponse get(String id) {
	        Account account = accountRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException());
	        return modelMapper.map(account, AccountResponse.class);
	    }

	    @Transactional
	    public AccountResponse save(AccountResponse accountResponse) {
	        Account account = modelMapper.map(accountResponse, Account.class);
	        account = accountRepository.save(account);
	        accountResponse.setId(account.getId());
	        return accountResponse;
	    }

	    @Transactional
	    public AccountResponse update(String id, AccountResponse accountResponse) {
	        Assert.isNull(id, "Id cannot be null");
	        Optional<Account> account = accountRepository.findById(id);
	        Account accountToUpdate = account.map(it -> {
	            it.setBirthDate(accountResponse.getBirthDate());
	            it.setName(accountResponse.getName());
	            it.setSurname(accountResponse.getSurname());
	            return it;
	        }).orElseThrow(IllegalArgumentException::new);
	        return modelMapper.map(accountRepository.save(accountToUpdate), AccountResponse.class);
	    }

	    @Transactional
	    public void delete(String id) {
	        Account account = accountRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException());
	        accountRepository.delete(account);
	    }

	    public Slice<AccountResponse> findAll(Pageable pageable) {
	        Slice<Account> accounts = accountRepository.findAll(pageable);
	        return null;
	    }
	
	

	

}
