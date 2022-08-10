package com.example.jpah2demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Telefone implements Serializable {

    private static final long serialVersionUID = -1143260269706042639L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String DDD;

    private String numero;

    public Telefone(String DDD, String numero) {
        this.DDD = DDD;
        this.numero = numero;
    }

    public Telefone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDDD() {
        return DDD;
    }

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
