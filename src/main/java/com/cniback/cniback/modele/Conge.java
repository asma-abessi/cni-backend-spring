package com.cniback.cniback.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="Conge")
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
   

    
    @Column(name="datedeb",nullable = false)
    private Date datedeb;

    @Column(name="datefin",nullable = false)
    private Date datefin;

    @Column(name="type",nullable = false)
    private String type;

	public Conge() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatedeb() {
		return datedeb;
	}

	public void setDatedeb(Date datedeb) {
		this.datedeb = datedeb;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
    
     

   
}
