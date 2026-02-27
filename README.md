TP : Gestion des Réservations avec JPA/Hibernate

Étape 1 : Création du projet

J’ai commencé par créer un projet Maven nommé gestion-reservations en définissant le GroupId, l’ArtifactId et la version. Le projet a ensuite été ouvert dans l’IDE afin de préparer l’environnement de développement.

Étape 2 : Configuration des dépendances et de JPA

J’ai ajouté les dépendances nécessaires dans le fichier pom.xml, notamment Hibernate, H2 et l’API JPA. Ensuite, j’ai configuré le fichier persistence.xml pour définir l’unité de persistance, les paramètres de connexion à la base H2 et les propriétés Hibernate.

Étape 3 : Création des entités

J’ai créé les entités principales du système : Utilisateur, Salle, Réservation et Équipement. Cette étape a permis de modéliser la structure de la base de données en Java.

![diagramme de classe](https://github.com/user-attachments/assets/d0d42c3e-c6ca-4eeb-8ae6-c0e1f18df500)

Étape 4 : Implémentation des relations

J’ai mis en place les relations entre les entités : OneToMany entre Utilisateur et Réservation .ManyToOne entre Réservation et Salle. ManyToMany entre Salle et Équipement

Les annotations JPA appropriées ont été utilisées afin d’assurer la cohérence relationnelle.

![image 1](https://github.com/user-attachments/assets/0e0602d0-00c9-4843-8e4a-294663b363a9)
![image 2](https://github.com/user-attachments/assets/b13bfb4d-d7a7-498d-91d2-78537a7c60cb)
![image 3](https://github.com/user-attachments/assets/2d64dc12-13de-4de2-beee-225c1562d6aa)
![image 4](https://github.com/user-attachments/assets/995e8548-0bf5-4e5e-81bf-eebdb783860f)
![image 5](https://github.com/user-attachments/assets/aac35bfa-b937-429c-b277-2aa3409fb90e)
![image 6](https://github.com/user-attachments/assets/5d9a44ab-cb77-43ca-b608-de08adea6645)
![image 7](https://github.com/user-attachments/assets/adb8f6db-f584-44a5-a211-c852b7d83b5e)
![image 8](https://github.com/user-attachments/assets/f384bb17-9a0f-450e-8a0c-5e812d73b3bb)
![image 9](https://github.com/user-attachments/assets/2ce7461d-b167-49df-bd82-0efc29db4781)

Étape 5 : Tests des cascades et de orphanRemoval

J’ai configuré les stratégies de cascade ainsi que l’option orphanRemoval = true pour automatiser la gestion du cycle de vie des entités. Une classe principale a été créée pour tester l’insertion des données, les relations entre entités et la suppression orpheline.










