package com.ifsp.apipagamento.controller;

import java.net.URI;
import java.util.List;

import com.ifsp.apipagamento.model.Card;
import com.ifsp.apipagamento.service.CardService;

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
@RequestMapping(path = "/api/cartao")
public class CardController {

    @Autowired
    private CardService service;

    @GetMapping
    public ResponseEntity<List<Card>> selectCard(){
        List<Card> list = service.selectCard();
        return ResponseEntity.ok().body(list);
    }
    //Select *
    //Return default cod 200 http
    @GetMapping(value = "/{id}")
    public ResponseEntity<Card> selectCardById(@PathVariable Long id) {
        Card obj = service.selectCardById(id);
        return ResponseEntity.ok().body(obj);
    }

    //Select by id customer
    //Return cod 201 http
    @GetMapping(value = "/cliente/{id}")
    public ResponseEntity<List<Card>> selectCardByCustomer(@PathVariable Long id) {
        List<Card> lst = service.selectCardByCustomer(id);
        return ResponseEntity.ok().body(lst);
    }

    //Select by id
    //Return cod 201 http
    @PostMapping
    public ResponseEntity<Card> insert(@RequestBody Card obj) {
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
    public ResponseEntity<Card> update(@PathVariable Long id, @RequestBody Card obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
