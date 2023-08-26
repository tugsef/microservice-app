package com.tugsef.services.notification.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tugsef.services.servicecommon.messaging.TicketNotification;

@Service
public class Test {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("$(sr.rappit.exchange.name)")
	private String routingName;
	
	public void sendToQueue(TicketNotification notification) {
		rabbitTemplate.convertAndSend(routingName,notification);
	}
}
