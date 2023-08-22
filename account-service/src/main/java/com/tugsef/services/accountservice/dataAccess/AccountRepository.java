package com.tugsef.services.accountservice.dataAccess;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.tugsef.services.accountservice.entities.Account;


public interface AccountRepository extends CassandraRepository<Account, String> {
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);
}
