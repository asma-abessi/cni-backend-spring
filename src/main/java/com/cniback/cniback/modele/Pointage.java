
package com.cniback.cniback.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="Pointage")
public class Pointage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="present",nullable = false)
    private String present;

    @Column(name="datedeb",nullable = false)
    private String datedeb;
    @Column(name="datefin",nullable = false)
    private String datefin;
    @Column(name="nbheure",nullable = false)
    private String nbheure;
	public Pointage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPresent() {
		return present;
	}
	public void setPresent(String present) {
		this.present = present;
	}
	public String getDatedeb() {
		return datedeb;
	}
	public void setDatedeb(String datedeb) {
		this.datedeb = datedeb;
	}
	public String getDatefin() {
		return datefin;
	}
	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}
	public String getNbheure() {
		return nbheure;
	}
	public void setNbheure(String nbheure) {
		this.nbheure = nbheure;
	}

}
