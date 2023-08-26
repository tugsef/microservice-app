package com.tugsef.services.notification.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

	@Value("$(sr.rappit.queue.name)")
	private String queueName;
	
	@Value("$(sr.rappit.exchange.name)")
	private String routingName;
	
	@Value("$(sr.rappit.routing.name)")
	private String exchsngeName;
	
	@Autowired
	private RabbitTemplate rapRabbitTemplate;
	
	
	@Bean
	public Queue queue() {
		return new Queue(queueName);
	}
	
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange(exchsngeName);
	}
	
	@Bean
	public Binding binding(final Queue queue , final DirectExchange directExchange) {
		return BindingBuilder.bind(queue).to(directExchange).with(routingName);
	}

	public RabbitMqConfiguration(RabbitTemplate rapRabbitTemplate) {
		super();
		this.rapRabbitTemplate = rapRabbitTemplate;
	}
	
	
	
	
}
