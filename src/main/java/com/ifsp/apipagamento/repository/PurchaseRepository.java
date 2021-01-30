package com.ifsp.apipagamento.repository;

import com.ifsp.apipagamento.model.Purchase;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

}