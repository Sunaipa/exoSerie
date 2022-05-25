package fr.formation.model;

import javax.persistence.Entity;

@Entity
public class Acteur extends PersonAbstract{

    private String role;

    public Acteur() {
    }
    public Acteur(String nom, String prenom, String role) {
        super(nom, prenom);
        this.role = role;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Acteur{" +
                "role='" + role + '\'' +
                '}';
    }
}
