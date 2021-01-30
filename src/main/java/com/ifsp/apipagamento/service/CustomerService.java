package com.ifsp.apipagamento.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.ifsp.apipagamento.model.Customer;
import com.ifsp.apipagamento.repository.CustomerRepository;
import com.ifsp.apipagamento.service.exception.DataBaseException;
import com.ifsp.apipagamento.service.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> selectCustomer() {
        return repository.findAll();
    }
    
    public Customer selectCustomerById(Long id) {
      Optional<Customer> obj = repository.findById(id);
      return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Customer insert(Customer obj) {
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

    public Customer update(Long id, Customer obj) {
      try {
        Customer model = repository.getOne(id);
        updateData(model, obj);
        return repository.save(model);
      } catch (EntityNotFoundException e) {
        throw new ResourceNotFoundException(id);
      }
      
    }

    private void updateData(Customer model, Customer obj) {
      model.setName(obj.getName());
      model.setCpf(obj.getCpf());
      model.setRg(obj.getRg());
      model.setEmail(obj.getEmail());
      model.setPassword(obj.getPassword());
      model.setDateBirth(obj.getDateBirth());
    }

}
