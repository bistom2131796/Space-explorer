package interaction;

import planetes.SystemePlanetaire;
import vaisseau.Vaisseau;

import java.util.Scanner;

public class Interaction {
    public static void menu(Vaisseau vaisseau){
        Scanner sc = new Scanner(System.in);

        System.out.println("Que desirez-vous faire?");
        System.out.println("   1. Examiner le vaisseau");
        System.out.println("   2. Explorer une nouvelle planete");
        System.out.println("   3. Utiliser un objet dans l'inventaire");
        System.out.println("   4. Revenir en arriere");
        System.out.println("Votre choix: ");

        char choix = sc.next().charAt(0);

        switch(choix){
            case '1':
                vaisseau.examiner();
                break;

            case '2':
                try{
                    vaisseau.changerPlanete().explorer(vaisseau);
                }
                catch (Exception e) {
                    gameOver(vaisseau);
                }

                break;

            case '3':
                vaisseau.afficherInventaire();
                int reponse = sc.nextInt();
                try{
                    vaisseau.getInventaire()[reponse - 1].utiliser(vaisseau);
                    vaisseau.enleverObjet(reponse - 1);
                }
                // erreur toujours déclencher
                catch (Exception e){
                    System.out.println("Cet objet n'est pas valide");
                    System.out.println(e.getStackTrace());
                }
                break;

            case '4':
                vaisseau.revenirArriere();
                break;

            default:
                System.out.println("Ceci n'est pas un choix valide.");
        }

    }
    public static void gameOver(Vaisseau vaisseau){
        System.out.println("Partie Termine");
        System.out.println();
        System.out.println("Trajet Parcouru : ");
        String trajet = "";
        while(!vaisseau.getJournalDeBord().empty()){
            trajet = " -> " + vaisseau.getJournalDeBord().pop().name() + trajet;
        }
        trajet = "TERRE" + trajet;
        System.out.println(trajet);

    }
}
