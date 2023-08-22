package com.tugsef.services.configservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServiceApplication {
	public static void main(String[] args) {
		new SpringApplication(ConfigServiceApplication.class).run(args);
	}
}
