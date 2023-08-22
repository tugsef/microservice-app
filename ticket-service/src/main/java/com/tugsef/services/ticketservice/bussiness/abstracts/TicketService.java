package com.tugsef.services.ticketservice.bussiness.abstracts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tugsef.services.ticketservice.entities.es.TicketModel;

public interface TicketService {

    TicketModel save(TicketModel ticketModel);

    TicketModel update(String id, TicketModel ticketModel);

    TicketModel getById(String ticketId);

    Page<TicketModel> getPagination(Pageable pageable);
}
