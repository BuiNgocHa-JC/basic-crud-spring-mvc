package com.luv2code.springdemo.repository;

import com.luv2code.springdemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
     Customer getCustomerById(Long id);
}
