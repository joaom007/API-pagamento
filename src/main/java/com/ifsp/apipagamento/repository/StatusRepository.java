package com.ifsp.apipagamento.repository;

import com.ifsp.apipagamento.model.Status;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long>{

}
