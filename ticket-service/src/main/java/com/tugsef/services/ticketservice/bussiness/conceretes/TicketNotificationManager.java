package com.tugsef.services.ticketservice.bussiness.conceretes;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.tugsef.services.servicecommon.messaging.TicketNotification;
import com.tugsef.services.ticketservice.bussiness.abstracts.TicketNotificationService;
import com.tugsef.services.ticketservice.entities.Ticket;





public class TicketNotificationManager implements TicketNotificationService {

	@Autowired
	private RabbitTemplate rabbitTemplate;

    @Override
    public void sendToQueue(Ticket ticket) {

        TicketNotification ticketNotification =new TicketNotification();
        ticketNotification.setAccountId(ticket.getAssignee());
        ticketNotification.setTicketId(ticket.getId());
        ticketNotification.setTicketDescription(ticket.getDescription());
        rabbitTemplate.convertAndSend("tug-sef-routing",ticketNotification);
    
    }


}
