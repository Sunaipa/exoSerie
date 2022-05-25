package fr.formation.controller;

import fr.formation.model.Acteur;
import fr.formation.model.Realisateur;
import fr.formation.model.Saison;
import fr.formation.model.Serie;
import fr.formation.service.SerieService;
import fr.formation.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class SerieController {
    @Autowired
    private SerieService ss;

    public void ajoutUneSerie(Serie s) {
        ss.addSerie(s);
    }

    public void ajoutSerie(Scanner sc) {

        Serie s = new Serie();
        System.out.println("titre : ");
        s.setTitre(Util.askString(sc));
        s.setSaisons(ajoutSaison(sc));
        ss.addSerie(s);

    }
    private List<Saison> ajoutSaison(Scanner sc) {
        boolean repeat = false;
        List<Saison> listS = new ArrayList<Saison>();
        Saison sTemp = new Saison();

        do {
            System.out.println("Ajout de saison");
            System.out.println("Numéro de la saison : ");
            sTemp.setNumero(Util.askNumber(sc));
            System.out.println("Année : ");
            sTemp.setAnnee(Util.askNumber(sc));
            System.out.println("Nb épisode : ");
            sTemp.setNbEpisodes(Util.askNumber(sc));

            System.out.println("Ajout d'un Réalisateur :");
            sTemp.setRealisateur(ajoutRealisateur(sc));

            System.out.println("Ajout d'acteur pour la saison " + sTemp.getNumero() + " : ");
            sTemp.setActeurs(ajoutActeur(sc));

            System.out.println("Ajouté une autre saison ? ");
            System.out.println("1 - Oui");
            System.out.println("2 - Non");
            if ((Util.askNumber(1,2,sc)) == 1 ){
                repeat = true;
            }else {
                repeat = false;
            }

        }while(repeat);

        return listS;
    }
    private List<Acteur> ajoutActeur(Scanner sc) {
        boolean repeat = false;
        List<Acteur> listA = new ArrayList<Acteur>();
        Acteur aTemp = new Acteur();
        do {
            System.out.println("Nom de l'acteur : ");
            aTemp.setNom(Util.askString(sc));
            System.out.println("Prenom de l'acteur : ");
            aTemp.setPrenom(Util.askString(sc));
            System.out.println("Role de l'acteur : ");
            aTemp.setRole(Util.askString(sc));

            listA.add(aTemp);
            System.out.println("Ajouté un autre acteur ? ");
            System.out.println("1 - Oui");
            System.out.println("2 - Non");
            if ((Util.askNumber(1,2,sc)) == 1 ){
                repeat = true;
            }else {
                repeat = false;
            }
        }while(repeat);
        return listA;
    }
    public int triSerie(Scanner sc) {
        System.out.println("Selection : ");
        System.out.println("1 - triés par ordre alphabétique croissant du titre");
        System.out.println("2 - triés par ordre alphabétique décroissant du titre");
        System.out.println("3 - triés par ordre chronologique de la premiere saison");
        System.out.println("4 - triés par ordre chronologique inverse de la premiere saison");
        System.out.println("5 - triés par nombre total d'épisodes croissant");
        System.out.println("6 - triés par nombre total d'épisodes décroissant");
        System.out.println("7 - triés en fonction d'un réalisateur");
        System.out.println("8 - triés  en fonction d'un acteur");
        System.out.println("9 - recherche sur le titre");
        return Util.askNumber(1, 9, sc);

    }
    private Realisateur ajoutRealisateur(Scanner sc) {
        Realisateur r = new Realisateur();
        System.out.println("Nom du réalisateur : ");
        r.setNom(Util.askString(sc));
        System.out.println("Prenom du réalisateur : ");
        r.setPrenom(Util.askString(sc));
        return r;
    }
    public void modifSerie(Scanner sc) {
        //TODO JAMAIS
    }
    public void deleteSerie(Scanner sc) {
        //TODO JAMAIS
    }

    //TRI
    public void triTitre(Scanner sc) {
        String recherche = Util.askString(sc);
        ss.triTitre(recherche).forEach(System.out::println);

    }
    public void triAlphaActeur() {
        ss.triAlphaActeur().forEach(System.out::println);
    }
    public void triAlphaRealisateur() {
        ss.triAlphaRealisateur().forEach(System.out::println);
    }
    public void triNombreEpisodeDecroissant() {
        ss.triNombreEpisodeDecroissant().forEach(System.out::println);
    }
    public void triNombreEpisodeCroissant() {
        ss.triNombreEpisodeCroissant().forEach(System.out::println);
    }
    public void triChronoInverseSaison() {
        ss.triChronoInverseSaison().forEach(System.out::println);
    }
    public void triChronoSaison() {
        ss.triChronoSaison().forEach(System.out::println);
    }
    public void triAlphaDecroissantTitre() {
        ss.triAlphaDecroissantTitre().forEach(System.out::println);
    }
    public void triAlphaCroissantTitre() {
        ss.triAlphaCroissantTitre().forEach(System.out::println);
    }


}
