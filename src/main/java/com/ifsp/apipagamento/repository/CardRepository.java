package com.ifsp.apipagamento.repository;

import com.ifsp.apipagamento.model.Card;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long>{

}
