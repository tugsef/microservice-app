package com.tugsef.services.ticketservice.bussiness.conceretes;

import com.tugsef.services.ticketservice.bussiness.abstracts.TicketNotificationService;
import com.tugsef.services.ticketservice.entities.Ticket;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@EnableBinding(Source.class)
@RequiredArgsConstructor
public class TicketNotificationManager implements TicketNotificationService {

    private final Source source;

    @Override
    public void sendToQueue(Ticket ticket) {

        TicketNotification ticketNotification =new TicketNotification();
        ticketNotification.setAccountId(ticket.getAssignee());
        ticketNotification.setTicketId(ticket.getId());
        ticketNotification.setTicketDescription(ticket.getDescription());

        source.output().send(MessageBuilder.withPayload(ticketNotification).build());
    }


}