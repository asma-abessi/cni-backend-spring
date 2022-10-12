package com.cniback.cniback.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="Avance")
public class Avance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="montant",nullable = false)
    private Integer montant;
    @Column(name="discription",nullable = false)
    private String discription;
    @Column(name="datedemande",nullable = false)
    private String datedemande;
    

    public Avance(){
        super();
    }

    public Integer getId() {
        return id;
    }

    public Integer getmontant() {
        return montant;
    }

    public void setmontant(Integer montant) {
        this.montant = montant;
    }
    
    public String getdiscription() {
        return discription;
    }
    public void setdiscription(String discription) {
        this.discription = discription;
    }
    public String getdatedemande() {
        return datedemande;
    }

    public void setdatedemande(String datedemande) {
        this.datedemande = datedemande;
    }
    
    

 
}