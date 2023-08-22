package com.tugsef.services.accountservice.webApi;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tugsef.services.accountservice.bussiness.abstracts.AccountService;
import com.tugsef.services.accountservice.bussiness.responses.AccountResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("account")
@AllArgsConstructor
public class AccountController {
	private final AccountService accountService;

	@GetMapping("/{id}")
	public ResponseEntity<AccountResponse> get(@PathVariable("id") String id) {
		return ResponseEntity.ok(accountService.get(id));
	}

	@PostMapping
	public ResponseEntity<AccountResponse> save(@RequestBody AccountResponse account) {
		return ResponseEntity.ok(accountService.save(account));
	}

	@PutMapping
	public ResponseEntity<AccountResponse> update(@PathVariable("id") String id, @RequestBody AccountResponse account) {
		return ResponseEntity.ok(accountService.update(id, account));
	}

	@DeleteMapping
	public void delete(String id) {
		accountService.delete(id);
	}

	@GetMapping
	public ResponseEntity<Slice<AccountResponse>> getAll(Pageable pageable) {
		return ResponseEntity.ok(accountService.findAll(pageable));
	}
}
