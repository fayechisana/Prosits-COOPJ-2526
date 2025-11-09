package tn.esprit.services;

import tn.esprit.entities.Departement;
import tn.esprit.interfaces.IDepartement;

import java.util.*;

public class DepartementHashSet implements IDepartement<Departement> {
        private Set<Departement> departements = new HashSet<>();

        @Override
        public void ajouterDepartement(Departement d) {
            if (departements.add(d)) {
                System.out.println("Département ajouté : " + d);
            } else {
                System.out.println("Le département existe déjà : " + d);
            }
        }

        @Override
        public boolean rechercherDepartement(String nomDepartement) {
            for (Departement d : departements) {
                if (d.getNomDepartement().equalsIgnoreCase(nomDepartement)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean rechercherDepartement(Departement d) {
            return departements.contains(d);
        }

        @Override
        public void supprimerDepartement(Departement d) {
            if (departements.remove(d)) {
                System.out.println("Département supprimé : " + d);
            } else {
                System.out.println("Département introuvable : " + d);
            }
        }

        @Override
        public void afficherDepartements() {
            for (Departement d : departements) {
                System.out.println(d);
            }
        }

        @Override
        public void trierDepartementsParId() {
            List<Departement> list = new ArrayList<>(departements);
            list.sort(Comparator.comparingInt(Departement::getId));
            list.forEach(System.out::println);
        }

        @Override
        public void trierDepartementsParNomEtNombreEmployes() {
            List<Departement> list = new ArrayList<>(departements);
            list.sort(Comparator.comparing(Departement::getNomDepartement)
                    .thenComparingInt(Departement::getNombreEmployes));
            list.forEach(System.out::println);
        }
    }
