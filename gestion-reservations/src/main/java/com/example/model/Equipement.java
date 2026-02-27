package com.example.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToMany(mappedBy = "equipements")
    private Set<Salle> salles = new HashSet<>();

    public Equipement() {}

    public Equipement(String nom) {
        this.nom = nom;
    }

    // getters setters
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public Set<Salle> getSalles() { return salles; }

    public void setNom(String nom) { this.nom = nom; }
}