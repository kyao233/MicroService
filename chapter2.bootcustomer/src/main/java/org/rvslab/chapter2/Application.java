package org.rvslab.chapter2;

import org.rvslab.chapter2.domain.Customer;
import org.rvslab.chapter2.repo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Bean
	CommandLineRunner init(CustomerRepository repo) {
		return (evt) -> {
			repo.save(new Customer("John", "John@gmail.com"));
			repo.save(new Customer("Adam", "Adam@gmail.com"));
			repo.save(new Customer("Smith", "Smith@gmail.com"));
			repo.save(new Customer("Tom", "Tom@gmail.com"));
			repo.save(new Customer("Sean", "Sean@gmail.com"));
		};
	}
}
