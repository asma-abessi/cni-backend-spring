package com.cniback.cniback.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Superviseur")
public class Superviseur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="nom",nullable = false)
    private String nom;
    @Column(name="email",nullable = false)
    private String email;
    @Column(name="password",nullable = false)
    private String password;
    @Column(name="datenaiss",nullable = false)
    private String datenaiss;
    @Column(name="telphone",nullable = false)
    private String telphone;
    @Column(name="adresse",nullable = false)
    private String adresse;
    @Column(name="salaire",nullable = false)
    private String salaire;
	
	public Superviseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDatenaiss() {
		return datenaiss;
	}
	public void setDatenaiss(String datenaiss) {
		this.datenaiss = datenaiss;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getSalaire() {
		return salaire;
	}
	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}
   

    

  
}
