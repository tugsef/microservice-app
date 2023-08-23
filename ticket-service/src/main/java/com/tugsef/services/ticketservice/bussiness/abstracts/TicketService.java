package com.tugsef.services.ticketservice.bussiness.abstracts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tugsef.services.ticketservice.bussiness.response.TicketResponse;

public interface TicketService {

    TicketResponse save(TicketResponse ticketResponse);

    TicketResponse update(String id, TicketResponse ticketResponse);

    TicketResponse getById(String ticketId);

    Page<TicketResponse> getPagination(Pageable pageable);
}
