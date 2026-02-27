package com.example;

import com.example.model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("reservationsPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            System.out.println("=== Création des données ===");

            // 1️⃣ Créer des équipements
            Equipement projecteur = new Equipement("Projecteur");
            Equipement tableau = new Equipement("Tableau blanc");

            em.persist(projecteur);
            em.persist(tableau);

            // 2️⃣ Créer une salle et associer les équipements (ManyToMany)
            Salle salle = new Salle("Salle Informatique", 25);
            salle.addEquipement(projecteur);
            salle.addEquipement(tableau);

            em.persist(salle);

            // 3️⃣ Créer un utilisateur
            Utilisateur utilisateur =
                    new Utilisateur("Malak", "malak@mail.com");

            // 4️⃣ Créer une réservation (OneToMany + cascade)
            Reservation reservation =
                    new Reservation(LocalDate.now(), salle);

            utilisateur.addReservation(reservation);

            // ⚠️ grâce au cascade ALL, on persiste seulement utilisateur
            em.persist(utilisateur);

            em.getTransaction().commit();

            System.out.println("✅ Données insérées");

            // =============================
            // 🧪 TEST orphanRemoval
            // =============================
            em.getTransaction().begin();

            Utilisateur u = em.find(Utilisateur.class, utilisateur.getId());

            if (!u.getReservations().isEmpty()) {
                Reservation r = u.getReservations().get(0);

                System.out.println("=== Suppression de la réservation (orphanRemoval) ===");

                u.removeReservation(r); // doit supprimer en base
            }

            em.getTransaction().commit();

            System.out.println("✅ Test orphanRemoval terminé");

        } finally {
            em.close();
            emf.close();
        }
    }
}