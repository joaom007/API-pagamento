package com.ifsp.apipagamento.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.ifsp.apipagamento.model.Purchase;
import com.ifsp.apipagamento.repository.PurchaseRepository;
import com.ifsp.apipagamento.service.exception.DataBaseException;
import com.ifsp.apipagamento.service.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository repository;

    public List<Purchase> selectPurchase() {
        return repository.findAll();
    }
    
    public Purchase selectPurchaseById(Long id) {
      Optional<Purchase> obj = repository.findById(id);
      return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Purchase insert(Purchase obj) {
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

    public Purchase update(Long id, Purchase obj) {
      try {
        Purchase model = repository.getOne(id);
        updateData(model, obj);
        return repository.save(model);
      } catch (EntityNotFoundException e) {
        throw new ResourceNotFoundException(id);
      }
    }

    private void updateData(Purchase model, Purchase obj) {
      model.setNameCompany(obj.getNameCompany());
      model.setDate(obj.getDate());
      model.setTotal(obj.getTotal());
      model.setInstallments(obj.getInstallments());
      model.setStatus(obj.getStatus());
      model.setCard(obj.getCard());

    }
}
