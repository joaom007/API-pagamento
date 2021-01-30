package com.ifsp.apipagamento.repository;

import com.ifsp.apipagamento.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
