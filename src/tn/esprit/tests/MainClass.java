package tn.esprit.tests;

import tn.esprit.entities.Departement;
import tn.esprit.entities.Employe;
import tn.esprit.services.AffectationHashMap;

public class MainClass {
    public static void main(String[] args) {
        AffectationHashMap ahm = new AffectationHashMap();

        Employe e1 = new Employe(1, "Sarah");
        Employe e2 = new Employe(2, "Amine");
        Employe e3 = new Employe(3, "Meriem");

        Departement d1 = new Departement(10, "Informatique", 30);
        Departement d2 = new Departement(20, "Finance", 15);

        // Ajout
        ahm.ajouterEmployeDepartement(e1, d1);
        ahm.ajouterEmployeDepartement(e2, d1);
        ahm.ajouterEmployeDepartement(e3, d2);

        System.out.println("=== Affectations initiales ===");
        ahm.afficherEmployesEtDepartements();

        // Ajouter le même employé dans un autre département
        System.out.println("\n=== Ajout du même employé dans un autre département ===");
        ahm.ajouterEmployeDepartement(e1, d2);

        ahm.afficherEmployesEtDepartements();

        // Tri
        System.out.println("\n=== Map triée par ID Employé ===");
        System.out.println(ahm.trierMap());
    }
}
