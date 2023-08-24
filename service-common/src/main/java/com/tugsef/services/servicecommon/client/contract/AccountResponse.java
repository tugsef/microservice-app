package com.tugsef.services.servicecommon.client.contract;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {

    private String id ;

    private String username;

    private String name;

    private String surname;

    private String email;

    private Date birthDate;

    public String getNameSurname() {
       return this.name + " " + this.surname;
    }
}

