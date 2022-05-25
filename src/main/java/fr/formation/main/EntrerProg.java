package fr.formation.main;


import fr.formation.conf.ApplicationConfiguration;
import fr.formation.controller.SerieController;
import fr.formation.model.Acteur;
import fr.formation.model.Realisateur;
import fr.formation.model.Saison;
import fr.formation.model.Serie;
import fr.formation.service.SerieService;
import fr.formation.util.Util;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntrerProg {


    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        SerieController sCont = ac.getBean(SerieController.class);

        Scanner sc = new Scanner(System.in);

        //JEU D'ESSAIS :
        //1
        Acteur a1 = new Acteur("toto", "titi", "tata");
        Acteur a2 = new Acteur("zozo", "zizi", "zaza");
        Acteur a3 = new Acteur("yoyo", "yiyi", "yaya");
        Acteur a4 = new Acteur("popo", "pipi", "papa");
        List<Acteur> la1 = new ArrayList<Acteur>();
        la1.add(a1);
        la1.add(a2);
        List<Acteur> la2 = new ArrayList<Acteur>();
        la1.add(a3);
        la1.add(a4);

        Realisateur r1 = new Realisateur("lolo", "lili");

        Saison s1 = new Saison(1, 1990, 24, r1, la1);
        Saison s2 = new Saison(2, 1992, 24, r1, la2);
        List<Saison> ls1 = new ArrayList<Saison>();
        ls1.add(s1);
        ls1.add(s2);

        Serie se = new Serie("serieA", ls1);

        sCont.ajoutUneSerie(se);
        //2
        Acteur a5 = new Acteur("sfsdf", "tieferti", "rtre");
        Acteur a6 = new Acteur("zertze", "zcxvxcvizi", "dfsf");
        Acteur a7 = new Acteur("sxcwx", "dsfs", "fsdd");
        Acteur a8 = new Acteur("trery", "yrty", "reteryrt");
        List<Acteur> la3 = new ArrayList<Acteur>();
        la3.add(a5);
        la3.add(a6);
        List<Acteur> la4 = new ArrayList<Acteur>();
        la4.add(a7);
        la4.add(a8);

        Realisateur r2 = new Realisateur("qsdqsdq", "qiqhfghfi");

        Saison s3 = new Saison(1, 2000, 12, r2, la3);
        Saison s4 = new Saison(2, 2002, 30, r2, la4);
        List<Saison> ls2 = new ArrayList<Saison>();
        ls2.add(s3);
        ls2.add(s4);

        Serie se2 = new Serie("serieB", ls2);

        sCont.ajoutUneSerie(se2);

        do {
            System.out.println("Selection : ");
            System.out.println("1 - Ajout Serie");
            System.out.println("2 - Modif Serie");
            System.out.println("3 - Delete Serie");
            System.out.println("4 - Affichage & tri");

            ChoixMenuTraitement(Util.askNumber(1, 4, sc), sc, sCont);

        }while(false);

        sc.close();
        System.out.println("FIN");
    }

    private static void ChoixMenuTraitement(int n, Scanner sc, SerieController sCont){
        switch (n){
            case 1 :
                sCont.ajoutSerie(sc);
                break;
            case 2 :
                sCont.modifSerie(sc);
                break;
            case 3 :
                sCont.deleteSerie(sc);
                break;
            case 4 :
                choixMenuTraitementTri(sCont.triSerie(sc), sc, sCont);
                break;
        }
    }

    private static void choixMenuTraitementTri(int n, Scanner sc, SerieController sCont) {
        switch (n){
            case 1 :
                sCont.triAlphaCroissantTitre();
                break;
            case 2 :
                sCont.triAlphaDecroissantTitre();
                break;
            case 3 :
                sCont.triChronoSaison();
                break;
            case 4 :
                sCont.triChronoInverseSaison();
                break;
            case 5 :
                sCont.triNombreEpisodeCroissant();
                break;
            case 6 :
                sCont.triNombreEpisodeDecroissant();
                break;
            case 7 :
                sCont.triAlphaRealisateur();
                break;
            case 8 :
                sCont.triAlphaActeur();
                break;
            case 9 :
                sCont.triTitre(sc);
                break;

        }
    }




}

