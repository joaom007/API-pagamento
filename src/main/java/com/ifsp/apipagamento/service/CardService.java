package com.ifsp.apipagamento.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.ifsp.apipagamento.model.Card;
import com.ifsp.apipagamento.repository.CardRepository;
import com.ifsp.apipagamento.service.exception.DataBaseException;
import com.ifsp.apipagamento.service.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    private CardRepository repository;

    public List<Card> selectCard() {
        return repository.findAll();
    }
    
    public Card selectCardById(Long id) {
      Optional<Card> obj = repository.findById(id);
      return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Card> selectCardByCustomer(Long id) {
      return repository.selectCardByCustomer(id); 
    } 

    public Card insert(Card obj) {
      return repository.save(obj);
    }

    public void delete(Long id) {
      try {
        repository.deleteById(id);

      } catch (EmptyResultDataAccessException e) {
        throw new ResourceNotFoundException(id);
        
      } catch (DataIntegrityViolationException e){
        throw new DataBaseException(e.getMessage());
      }
    }

    public Card update(Long id, Card obj) {
      try {
        Card model = repository.getOne(id);
        updateData(model, obj);
        return repository.save(model);
      } catch (EntityNotFoundException e) {
        throw new ResourceNotFoundException(id);
      }
    }

    private void updateData(Card model, Card obj) {
      model.setNumber(obj.getNumber());
      model.setNameInCard(obj.getNameInCard());
      model.setValidate(obj.getValidate());
      model.setSecurityNumber(obj.getSecurityNumber());
    }

}
