package org.rvslab.chapter2.component;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Sender {

	@Autowired
	private RabbitMessagingTemplate template;
	
	
	@Bean
	public Queue queue() {
		return new Queue("CustomerQ", false);
	}
	
	public void send(String message) {
		if (message == "" || message == null) {
			throw new RuntimeException("Email cannot be empty!");
		}
		template.convertAndSend("CustomerQ", message);
	}
	
	
}
