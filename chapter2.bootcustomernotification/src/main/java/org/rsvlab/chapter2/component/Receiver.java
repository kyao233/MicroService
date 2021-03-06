package org.rsvlab.chapter2.component;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@Autowired
	private Mailer mailer;
	
	@Bean
	public Queue queue() {
		return new Queue("CustomerQ", false);
	}
	
	
	@RabbitListener(queues = "CustomerQ")
	public void processMessage(String email) {
		System.out.println("Send to: " + email);
		mailer.sendMail(email);
	}
	
	
}
