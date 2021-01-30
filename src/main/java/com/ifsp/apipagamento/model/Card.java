package com.ifsp.apipagamento.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_card")
public class Card implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String nameInCard;
    private String validate;
    private String securityNumber;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Card() {
    }

    public Card(Long id, String number, String nameInCard, String validate, String securityNumber, Customer customer) {
        this.id = id;
        this.number = number;
        this.nameInCard = nameInCard;
        this.validate = validate;
        this.securityNumber = securityNumber;
        this.customer = customer;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNameInCard() {
        return this.nameInCard;
    }

    public void setNameInCard(String nameInCard) {
        this.nameInCard = nameInCard;
    }

    public String getValidate() {
        return this.validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    public String getSecurityNumber() {
        return this.securityNumber;
    }

    public void setSecurityNumber(String securityNumber) {
        this.securityNumber = securityNumber;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Card)) {
            return false;
        }
        Card card = (Card) o;
        return Objects.equals(id, card.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
    
}
