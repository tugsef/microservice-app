package com.tugsef.services.ticketservice.bussiness.abstracts;

import com.tugsef.services.ticketservice.entities.Ticket;

public interface TicketNotificationService {

    void sendToQueue(Ticket ticket);
}
