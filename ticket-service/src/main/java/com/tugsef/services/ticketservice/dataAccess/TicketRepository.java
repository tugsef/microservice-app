package com.tugsef.services.ticketservice.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tugsef.services.ticketservice.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, String>{

}
