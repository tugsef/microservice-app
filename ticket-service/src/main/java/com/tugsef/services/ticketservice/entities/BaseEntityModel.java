package com.tugsef.services.ticketservice.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

/**
 * 
 */
@MappedSuperclass
public abstract class BaseEntityModel implements Serializable {

	private static final long serialVersionUID = -75333702558837841L;

	@CreatedDate
	@Column(name = "created_at")
	private Date cretedAt;

	@Column(name = "updated_at")
	private Date updatedAt;
}