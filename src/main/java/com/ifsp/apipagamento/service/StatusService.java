package com.ifsp.apipagamento.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.ifsp.apipagamento.model.Status;
import com.ifsp.apipagamento.repository.StatusRepository;
import com.ifsp.apipagamento.service.exception.DataBaseException;
import com.ifsp.apipagamento.service.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    @Autowired
    private StatusRepository repository;

    public List<Status> selectStatus() {
        return repository.findAll();
    }
    
    public Status selectStatusById(Long id) {
      Optional<Status> obj = repository.findById(id);
      return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Status insert(Status obj) {
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

    public Status update(Long id, Status obj) {
      try {
        Status model = repository.getOne(id);
        updateData(model, obj);
        return repository.save(model);
      } catch (EntityNotFoundException e) {
        throw new ResourceNotFoundException(id);
      }
      
    }

    private void updateData(Status model, Status obj) {
      model.setStatus(obj.getStatus());
      
    }

}
