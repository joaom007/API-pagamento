package com.ifsp.apipagamento.repository;

import java.util.List;

import com.ifsp.apipagamento.model.Card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CardRepository extends JpaRepository<Card, Long>{

    @Query("select u from Card u where u.customer.id = :id")
    List<Card> selectCardByCustomer(Long id);
}
