package org.spring.jpa.repo;

import java.util.List;

import org.spring.jpa.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

	List<Customer> findByLastName(String lastName);
	
}
