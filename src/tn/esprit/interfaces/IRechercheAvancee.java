package tn.esprit.interfaces;

import java.util.List;

public interface IRechercheAvancee<T> {
    List<T> rechercherParDepartement(String nomDepartement);
}
