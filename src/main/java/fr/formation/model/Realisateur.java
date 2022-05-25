package fr.formation.model;

import javax.persistence.*;

@Entity
public class Realisateur extends PersonAbstract {

    public Realisateur() {
    }
    public Realisateur(String nom, String prenom) {
        super(nom, prenom);
    }

    @Override
    public String toString() {
        return "Realisateur{}";
    }
}
