package com.jpa.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.demo.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
