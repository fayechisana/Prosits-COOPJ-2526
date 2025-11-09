package tn.esprit.entities;

import java.util.Objects;

public class Departement {
        private int id;
        private String nomDepartement;
        private int nombreEmployes;

        // Constructeur par défaut
        public Departement() {}

        // Constructeur paramétré
        public Departement(int id, String nomDepartement, int nombreEmployes) {
            this.id = id;
            this.nomDepartement = nomDepartement;
            this.nombreEmployes = nombreEmployes;
        }

        // Getters et setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNomDepartement() {
            return nomDepartement;
        }

        public void setNomDepartement(String nomDepartement) {
            this.nomDepartement = nomDepartement;
        }

        public int getNombreEmployes() {
            return nombreEmployes;
        }

        public void setNombreEmployes(int nombreEmployes) {
            this.nombreEmployes = nombreEmployes;
        }

        // Redéfinition de equals pour comparer id et nom
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Departement)) return false;
            Departement that = (Departement) o;
            return id == that.id && nomDepartement.equals(that.nomDepartement);
        }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomDepartement);
    }

    // Redéfinition de toString
        @Override
        public String toString() {
            return "Departement{" +
                    "id=" + id +
                    ", nomDepartement='" + nomDepartement + '\'' +
                    ", nombreEmployes=" + nombreEmployes +
                    '}';
        }
    }

