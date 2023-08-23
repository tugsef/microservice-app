package com.tugsef.services.ticketservice.core.utilities.elesticsearch;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.tugsef.services")
@EnableElasticsearchRepositories(basePackages = "com.tugsef.services")
public class ElasticsearckConfiguration {

}
