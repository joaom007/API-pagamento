package com.ifsp.apipagamento.controller;

import java.net.URI;
import java.util.List;

import com.ifsp.apipagamento.model.Status;
import com.ifsp.apipagamento.service.StatusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/api/categoria")
public class StatusController {

    @Autowired
    private StatusService service;

    @GetMapping
    public ResponseEntity<List<Status>> selectStatus(){
        List<Status> list = service.selectStatus();
        return ResponseEntity.ok().body(list);
    }
    //Select *
    //Return default cod 200 http
    @GetMapping(value = "/{id}")
    public ResponseEntity<Status> selectStatusById(@PathVariable Long id) {
        Status obj = service.selectStatusById(id);
        return ResponseEntity.ok().body(obj);
    }

    //Select by id
    //Return cod 201 http
    @PostMapping
    public ResponseEntity<Status> insert(@RequestBody Status obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    //Delete by id
    //Return cod 204 http
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    //Update by id
    //Return default cod 200 http
    @PutMapping(value = "/{id}")
    public ResponseEntity<Status> update(@PathVariable Long id, @RequestBody Status obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
