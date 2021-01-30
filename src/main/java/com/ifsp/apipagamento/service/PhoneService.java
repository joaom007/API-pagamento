package com.ifsp.apipagamento.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.ifsp.apipagamento.model.Phone;
import com.ifsp.apipagamento.repository.PhoneRepository;
import com.ifsp.apipagamento.service.exception.DataBaseException;
import com.ifsp.apipagamento.service.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository repository;

    public List<Phone> selectPhone() {
        return repository.findAll();
    }
    
    public Phone selectPhoneById(Long id) {
      Optional<Phone> obj = repository.findById(id);
      return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Phone insert(Phone obj) {
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

    public Phone update(Long id, Phone obj) {
      try {
        Phone model = repository.getOne(id);
        updateData(model, obj);
        return repository.save(model);
      } catch (EntityNotFoundException e) {
        throw new ResourceNotFoundException(id);
      }
    }

    private void updateData(Phone model, Phone obj) {
      model.setPhone(obj.getPhone());
    }

}

