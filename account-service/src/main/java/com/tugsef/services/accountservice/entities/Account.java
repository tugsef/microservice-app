package com.tugsef.services.accountservice.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "id" })
@ToString
@Table(value = "accounts")
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private String id = UUID.randomUUID().toString();

	@Column(value = "uname")
	private String username;

	@Column(value = "name")
	private String name;

	@Column(value = "surname")
	private String surname;

	@Column(value = "email")
	private String email;

	@Column(value = "birth_date")
	private Date birthDate;

	@Column(value = "pwd")
	private String password;

	@Column(value = "created_at")
	private Date createdAt;

	@Column(value = "is_active")
	private Boolean active;

}