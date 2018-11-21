package org.rvslab.chapter2.component;

import java.util.Optional;

import org.rvslab.chapter2.domain.Customer;
import org.rvslab.chapter2.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CustomerRegistrar {

	
	private CustomerRepository repo;
	
	private Sender mailSender;
	
	@Autowired
	public CustomerRegistrar(CustomerRepository repo, Sender mailSender) {
		this.repo = repo;
		this.mailSender = mailSender;
	}
	
	
	public Customer register(Customer customer) {
		
		Optional<Customer> existingCustomer = repo.findByName(customer.getName());
		if(existingCustomer.isPresent()) {
			throw new RuntimeException("Customer already exist");
		} else {
			repo.save(customer);
			mailSender.send(customer.getEmail());
		}
		
		return customer;
	}
}
