import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {

    public static String mot_au_hazard() {


        List<String> listdemot = new ArrayList<>();

        listdemot.add("manger");
        listdemot.add("voiture");
        listdemot.add("accepter");
        listdemot.add("lambourgini");
        listdemot.add("ferrari");
        listdemot.add("james");
        listdemot.add("zombi");
        listdemot.add("callofduty");
        listdemot.add("leagueoflegende");
        listdemot.add("bayern");

        Collections.shuffle(listdemot);

        return listdemot.get(0);

    }

    public static String[] mot_cacher(String mot) {

        String[] mot_cacher = new String[mot.length()];

        return mot_cacher;
    }

    public static void dessin_du_pendu(int palier) {


        String[] dessin = {

                "----- \n"
                        + "|      | \n"
                        + "|\n" + "|\n" + "|\n" + "|\n" + "|\n" + "|\n"
                        + "--------\n" + "|    |\n"
                        + "|    O\n"
                        + "|\n"
                        + "|\n" + "|\n" + "|\n" + "|\n" + "--------\n",
                "-----\n"
                        + "|    |\n"
                        + "|    O\n"
                        + "| ---|---\n"
                        + "|    |\n" + "|\n" + "|\n" + "|\n" + "--------\n",
                "-----\n"
                        + "|    |\n"
                        + "|    O\n"
                        + "| ---|---\n"
                        + "|    |\n" + "|   ===\n"
                        + "|   |\n"
                        + "|   |\n"
                        + "|\n" + "--------\n", "-----\n"

                + "|    |\n"
                + "|    O\n"
                + "| ---|---\n"
                + "|    |\n" + "|   ===\n"
                + "|   | \n"
                + "|    \n"
                + "|\n" + "--------\n"

                , "-----\n"

                + "|    |\n"
                + "|    O\n"
                + "| ---|---\n"
                + "|    |\n" + "|   ===\n"
                + "|   | |\n"
                + "|   | |\n"
                + "|\n" + "--------\n"

                , "-----\n"

                + "|    |\n"
                + "|    O\n"
                + "| ---|---\n"
                + "|    |\n" + "|   ===\n"
                + "|   | |\n"
                + "|   | |\n"
                + "  __    \n"
                + "|\n" + "--------\n"

                , "-----\n"

                + "|    |\n"
                + "|    O--(JE VAIS MOURIR TROUVE TOUTE LES LETTRE ESPECE DE CON !)\n"
                + "| ---|---\n"
                + "|    |\n"
                + "|   ===\n"
                + "|   | |\n"
                + "|   | |\n"
                + "  __   __ \n"
                , "-----\n"


                + "|    |\n"
                + "|    O--(HAAAAAAAAA JE BRUUUULLLLEEEE!!!!!!)\n"
                + "| ---|---\n"
                + "|^^^ |^^^\n"
                + "|^^^===^^^^\n"
                + "|^^ | |^^\n"
                + "|^^ | |^^\n"
                + "^^__^^^__^\n"
                + "^^^^^^^^^^^\n"
                + "^^^^^^^^^^^\n"
                + "^^^^^^^^^^^\n"

                + "--------------\n"


        };

        System.out.println(dessin[palier]);


    }

    public static void afficherList(List<String> list) {

        System.out.println("_________________________________");
        System.out.println("_______Lettre deja choisie_______");
        System.out.println("_________________________________");
        for (String elem : list
        ) {

            System.out.print(" | " + elem);

        }

        System.out.println();

        System.out.println("_________________________________");
    }

    public static void afficherTab(String[] tab) {

        for (String elem : tab) {

            System.out.print(" | ");

            System.out.print(elem == null ? "*" : elem);

        }
    }

    public static void game() {

        Scanner scanner = new Scanner(System.in);


        List<String> list_de_lettre_deja_choisie = new ArrayList<>();


        System.out.println("=========================");
        System.out.println("=======LE PENDU==========");
        System.out.println("=========================");

        String mot = mot_au_hazard();

        String[] mot_cacher = mot_cacher(mot);


        int nombre_de_chance = 0;

        int compteur_trouver = 0;


        while (nombre_de_chance < 8) {

            afficherTab(mot_cacher);

            boolean lettre_trouver = false;

            System.out.println();

            System.out.print("choisie une lettre : ");

            String choix = scanner.next();


            list_de_lettre_deja_choisie.add(choix);


            afficherList(list_de_lettre_deja_choisie);

            for (int i = 0; i < mot.length(); i++) {

                if (choix.charAt(0) == mot.charAt(i)) {

                    mot_cacher[i] = choix;

                    lettre_trouver = true;

                    compteur_trouver++;
                }

            }

            if (lettre_trouver == false) {

                dessin_du_pendu(nombre_de_chance);

                nombre_de_chance++;


            }


            if (nombre_de_chance == 8) {

                System.out.println("________________");

                System.out.println("vous avez perdu");

                System.out.println("________________");

                System.out.println("Le mot etait : " + mot);


                System.out.println("________________");
            }


            if (compteur_trouver == mot_cacher.length) {

                System.out.println("vous avez gagnez");

                afficherTab(mot_cacher);

                nombre_de_chance = nombre_de_chance + 9;

            }


        }


    }


    public static void main(String[] args) {

        game();


    }
}