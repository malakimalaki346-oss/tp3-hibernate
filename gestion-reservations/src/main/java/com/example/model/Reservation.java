package com.example.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateReservation;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

    public Reservation() {}

    public Reservation(LocalDate dateReservation, Salle salle) {
        this.dateReservation = dateReservation;
        this.salle = salle;
    }

    // getters setters
    public Long getId() { return id; }
    public LocalDate getDateReservation() { return dateReservation; }
    public Utilisateur getUtilisateur() { return utilisateur; }
    public Salle getSalle() { return salle; }

    public void setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
}