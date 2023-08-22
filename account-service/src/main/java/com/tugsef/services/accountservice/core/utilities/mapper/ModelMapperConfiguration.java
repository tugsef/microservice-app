package com.tugsef.services.accountservice.core.utilities.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {
	
	@Bean
	public ModelMapper getModelmapper() {
		return new ModelMapper();
	} 
}
