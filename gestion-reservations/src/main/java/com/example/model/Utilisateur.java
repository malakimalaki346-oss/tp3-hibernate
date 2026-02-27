package com.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;

    @OneToMany(mappedBy = "utilisateur",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    public Utilisateur() {}

    public Utilisateur(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    // helper methods
    public void addReservation(Reservation r) {
        reservations.add(r);
        r.setUtilisateur(this);
    }

    public void removeReservation(Reservation r) {
        reservations.remove(r);
        r.setUtilisateur(null);
    }

    // getters & setters
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public List<Reservation> getReservations() { return reservations; }

    public void setNom(String nom) { this.nom = nom; }
    public void setEmail(String email) { this.email = email; }
}