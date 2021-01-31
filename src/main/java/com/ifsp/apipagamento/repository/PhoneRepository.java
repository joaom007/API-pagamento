package com.ifsp.apipagamento.repository;

import java.util.List;

import com.ifsp.apipagamento.model.Phone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface PhoneRepository extends JpaRepository<Phone, Long>{

    @Query("select u from Phone u where u.customer.id = :id")
    List<Phone> selectPhoneByCustomer(Long id);

}


