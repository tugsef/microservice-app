package com.tugsef.services.ticketservice.dataAccess.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.tugsef.services.ticketservice.entities.es.TicketModel;

public interface TicketElasticRepository extends ElasticsearchRepository<TicketModel, String> {
}
