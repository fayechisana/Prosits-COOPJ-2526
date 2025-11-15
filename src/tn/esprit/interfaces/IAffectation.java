package tn.esprit.interfaces;

import tn.esprit.entities.Departement;
import tn.esprit.entities.Employe;

import java.util.TreeMap;

public interface IAffectation {
    void ajouterEmployeDepartement(Employe e, Departement d);
    void afficherEmployesEtDepartements();
    void supprimerEmploye(Employe e);
    void supprimerEmployeEtDepartement(Employe e, Departement d);
    void afficherEmployes();
    void afficherDepartements();
    boolean rechercherEmploye(Employe e);
    boolean rechercherDepartement(Departement d);
    TreeMap<Employe, Departement> trierMap();
}
