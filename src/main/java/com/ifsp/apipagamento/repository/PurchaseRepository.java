package com.ifsp.apipagamento.repository;

import java.util.List;

import com.ifsp.apipagamento.model.Purchase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

    @Query("select u from Purchase u where u.card.customer.id = :id")
    List<Purchase> selectPurchaseByCustomer(Long id);

}