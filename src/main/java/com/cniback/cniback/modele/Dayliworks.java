package com.cniback.cniback.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Dayliworks")
public class Dayliworks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="nom",nullable = false)
    private String nom;

  /*  @OneToMany(mappedBy = "Employe",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Employe> Employe;
*/
    public Dayliworks(){
        super();
    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom.substring(0,1).toUpperCase() + nom.substring(1).toLowerCase();
    }

 /*   public List<Employe> getEmploye() {
        return Employe;
    }

    public void setEmploye(List<Employe> Employe) {
        this.Employe = Employe;
    }*/
}
