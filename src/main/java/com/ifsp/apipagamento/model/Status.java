package com.ifsp.apipagamento.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_status")
public class Status implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;

    @OneToOne
    @MapsId
    private Purchase purchase;

    public Status() {

    }

    public Status(Long id, String status, Purchase purchase) {
        super();
        this.id = id;
        this.status = status;
        this.purchase = purchase;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Purchase getPurchase() {
        return this.purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Status)) {
            return false;
        }
        Status status = (Status) o;
        return Objects.equals(id, status.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
   
}