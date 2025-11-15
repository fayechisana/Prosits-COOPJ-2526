package tn.esprit.services;

import tn.esprit.entities.Departement;
import tn.esprit.entities.Employe;
import tn.esprit.interfaces.IAffectation;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AffectationHashMap implements IAffectation {

    private HashMap<Employe, Departement> affectations = new HashMap<>();

    @Override
    public void ajouterEmployeDepartement(Employe e, Departement d) {
        affectations.put(e, d); // remplace si employé déjà existant
    }

    @Override
    public void afficherEmployesEtDepartements() {
        if (affectations.isEmpty()) {
            System.out.println("Aucune affectation trouvée.");
            return;
        }
        for (Map.Entry<Employe, Departement> entry : affectations.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }

    @Override
    public void supprimerEmploye(Employe e) {
        affectations.remove(e);
    }

    @Override
    public void supprimerEmployeEtDepartement(Employe e, Departement d) {
        if (affectations.containsKey(e) && affectations.get(e).equals(d)) {
            affectations.remove(e);
        }
    }

    @Override
    public void afficherEmployes() {
        for (Employe e : affectations.keySet()) {
            System.out.println(e);
        }
    }

    @Override
    public void afficherDepartements() {
        for (Departement d : affectations.values()) {
            System.out.println(d);
        }
    }

    @Override
    public boolean rechercherEmploye(Employe e) {
        return affectations.containsKey(e);
    }

    @Override
    public boolean rechercherDepartement(Departement d) {
        return affectations.containsValue(d);
    }

    @Override
    public TreeMap<Employe, Departement> trierMap() {
        return new TreeMap<>(affectations);
    }
}

