package com.tugsef.services.accountservice.bussiness.responses;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {
	
	private String id ;

    private String username;

    private String name;

    private String surname;

    private String email;

    private Date birthDate;
}
