package tn.esprit.services;

import tn.esprit.entities.Employe;
import tn.esprit.interfaces.IGestion;
import tn.esprit.interfaces.IRechercheAvancee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SocieteArrayList implements IGestion<Employe>, IRechercheAvancee<Employe> {

    private List<Employe> listEmployes = new ArrayList<>();

    @Override
    public void ajouterEmploye(Employe t) {
        listEmployes.add(t);
    }

    @Override
    public boolean rechercherEmploye(String nom) {
        for (Employe e : listEmployes) {
            if (e.getNom().equalsIgnoreCase(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherEmploye(Employe t) {
        return listEmployes.contains(t);
    }

    @Override
    public void supprimerEmploye(Employe t) {
        listEmployes.remove(t);
    }

    @Override
    public void displayEmploye() {
        for (Employe e : listEmployes) {
            System.out.println(e);
        }
    }

    @Override
    public void trierEmployeParId() {
        Collections.sort(listEmployes);
    }

    @Override
    public void trierEmployeParNomDépartementEtGrade() {
        Collections.sort(listEmployes, new Comparator<Employe>() {
            @Override
            public int compare(Employe e1, Employe e2) {
                int cmp = e1.getNomDepartement().compareToIgnoreCase(e2.getNomDepartement());
                if (cmp == 0) {
                    cmp = Integer.compare(e1.getGrade(), e2.getGrade());
                    if (cmp == 0) {
                        cmp = e1.getNom().compareToIgnoreCase(e2.getNom());
                    }
                }
                return cmp;
            }
        });
    }

    @Override
    public List<Employe> rechercherParDepartement(String nomDepartement) {
        List<Employe> resultat = new ArrayList<>();
        for (Employe e : listEmployes) {
            if (e.getNomDepartement().equalsIgnoreCase(nomDepartement)) {
                resultat.add(e);
            }
        }
        return resultat;
    }
}