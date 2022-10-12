package com.cniback.cniback.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="Formation")
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="datedeb",nullable = false)
    private Date datedeb;

    @Column(name="theme",nullable = false)
    private String theme;

    @Column(name="niveau",nullable = false)
    private String niveau;

	public Formation() {
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

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
    
   
   
}
