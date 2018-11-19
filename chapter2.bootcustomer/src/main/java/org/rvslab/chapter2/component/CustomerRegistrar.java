package org.rvslab.chapter2.component;

import java.util.Optional;

import org.rvslab.chapter2.domain.Customer;
import org.rvslab.chapter2.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerRegistrar {

	
	private CustomerRepository repo;
	
	@Autowired
	public CustomerRegistrar(CustomerRepository repo) {
		this.repo = repo;
	}
	
	
	public Customer register(Customer customer) {
		
		Optional<Customer> existingCustomer = repo.findByName(customer.getName());
		if(existingCustomer.isPresent()) {
			throw new RuntimeException("Customer already exist");
		} else {
			repo.save(customer);
		}
		
		return customer;
	}
}
