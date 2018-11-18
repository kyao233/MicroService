package org.spring.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.jpa.domain.Customer;
import org.spring.jpa.repo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringJpaApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init(CustomerRepository repo) {
		return (args) -> {
			repo.save(new Customer("Kai", "Kai"));
			repo.save(new Customer("Y", "Y"));
			
			//fetch all the customers
			log.info("Customers found by findAll()");
			log.info("-----------------------");
			for(Customer customer: repo.findAll()) {
				log.info(customer.toString());
			}
			
		
		};
	}
	
}

