package com.ifsp.apipagamento.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_customer")
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String rg;
    private String email;
    private String password;
    private String token;
    private String dateBirth;

    @OneToMany(mappedBy = "customer")
    private List<Phone> phones = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Card> cards = new ArrayList<>();


    public Customer() {
    }

    public Customer(Long id, String name, String cpf, String rg, String email, String password, String token, String dateBirth) {
        super();
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.password = password;
        this.token = token;
        this.dateBirth = dateBirth;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDateBirth() {
        return this.dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public List<Phone> getPhones() {
        return this.phones;
    }

    public List<Card> getCards() {
        return this.cards;
    }  

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
            
}
