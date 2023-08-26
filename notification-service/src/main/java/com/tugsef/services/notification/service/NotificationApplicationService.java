package com.tugsef.services.notification.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NotificationApplicationService {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplicationService.class, args);
    }

}
