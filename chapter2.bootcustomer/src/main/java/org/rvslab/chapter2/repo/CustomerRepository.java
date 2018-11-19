package org.rvslab.chapter2.repo;

import java.util.Optional;

import org.rvslab.chapter2.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Optional<Customer> findByName(@Param("name") String name);
	
}
