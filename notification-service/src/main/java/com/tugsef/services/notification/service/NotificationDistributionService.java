package com.tugsef.services.notification.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.tugsef.services.servicecommon.messaging.TicketNotification;

@Service
public class NotificationDistributionService {

	
	
   @RabbitListener(queues = "tug-sef-queue")
    public void onNotification(TicketNotification ticketNotification){
        System.out.println("———————————————————————————————————————————");
        System.out.println("Notification Alindi Kullanicilara gönderiliyor.");
        System.out.println("Notification -> " + ticketNotification.toString());
    }
}
