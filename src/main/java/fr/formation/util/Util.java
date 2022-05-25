package fr.formation.util;

import java.util.Scanner;

public class Util {

    public static int askNumber(int min, int max, Scanner sc) {
        boolean repeat = false;
        int choix = 0;
        do {
            try{
                choix = sc.nextInt();
                sc.nextLine();
                if (choix >= min && choix <= max){
                    repeat = false;
                }else {
                    repeat = true;
                }

            }catch (Exception e){
                repeat = true;
            }
        }while (repeat);

        return choix;

    }

    public static int askNumber(Scanner sc) {
        boolean repeat = false;
        int choix = 0;
        do {
            try{
                choix = sc.nextInt();
                sc.nextLine();
                repeat = false;
            }catch (Exception e){
                repeat = true;
            }
        }while (repeat);

        return choix;
    }

    public static String askString(Scanner sc) {
        boolean repeat = false;
        String str = "";
        do {
            try{
                str = sc.nextLine();
                repeat = false;
            }catch (Exception e){
                repeat = true;
            }
        }while (repeat);
        return str;
    }
}
