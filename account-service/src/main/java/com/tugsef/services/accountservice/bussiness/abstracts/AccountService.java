package com.tugsef.services.accountservice.bussiness.abstracts;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.tugsef.services.servicecommon.client.contract.AccountResponse;





public interface AccountService {

	AccountResponse get(String id);

	AccountResponse save(AccountResponse accountResponse);

	AccountResponse update(String id, AccountResponse AccountResponse);

	void delete(String id);

	Slice<AccountResponse> findAll(Pageable pageable);
}
