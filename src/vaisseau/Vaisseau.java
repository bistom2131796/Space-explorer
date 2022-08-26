package vaisseau;

import objet.Item;
import planetes.SystemePlanetaire;

import java.util.Stack;

public class Vaisseau {
    private int pointDeVie;
    private int carburantRestant;
    private Item[] inventaire;
    private SystemePlanetaire planeteCourante;

    private Stack<SystemePlanetaire> journalDeBord = new Stack<>();


    public Vaisseau() {
        pointDeVie = 100;
        carburantRestant = 1000;
        planeteCourante = null;
        inventaire = new Item[8];

    }
    public void examiner() {
        System.out.println("\n" +
                "                    __,' __`.                _..----....____\n" +
                "        __...--.'``;.   ,.   ;``--..__     .'    ,-._    _.-'\n" +
                "  _..-''-------'   `'   `'   `'     O ``-''._   (,;') _,'\n" +
                ",'________________                          \\`-._`-','\n" +
                " `._              ```````````------...___   '-.._'-:\n" +
                "    ```--.._      ,.                     ````--...__\\-.\n" +
                "            `.--. `-`                       ____    |  |`\n" +
                "              `. `.                       ,'`````.  ;  ;`\n" +
                "                `._`.        __________   `.      \\'__/`\n" +
                "                   `-:._____/______/___/____`.     \\  `\n" +
                "                               |       `._    `.    \\\n" +
                "                               `._________`-.   `.   `.___\n" +
                "                                                  `------'`");
        System.out.println("Etat du vaisseau: ");
        System.out.println("  * Points de vie : " + pointDeVie);
        System.out.println("  * Carburant restant : " + carburantRestant + " litres");
        if(planeteCourante != null){
            // a refaire
            System.out.println("  * Planete courante : " + planeteCourante.name());
        }
        else {
            System.out.println("  * Planete courante : Terre");
        }

        System.out.println("  * Inventaire : " + toStringInventaire());
        System.out.println();
    }

    public SystemePlanetaire changerPlanete() {
        SystemePlanetaire prochaineDestination;
        if (journalDeBord.size() != 8) {
            do {
                prochaineDestination = SystemePlanetaire.values()[(int) (Math.random() * 8)];
            } while (journalDeBord.contains(prochaineDestination));

            System.out.println("Vous vous rendez sur " + prochaineDestination.name());
            if (carburantRestant >= prochaineDestination.getFuelrequis()) {
                planeteCourante = prochaineDestination;

                journalDeBord.push(prochaineDestination);
                return prochaineDestination;
            } else {
                System.out.println("Vous avez manquez de carburant en cours de route.");
                carburantRestant = 0;
                return null;
            }
        }
        else{
            System.out.println("Vous avez explore tout le systeme disponible.");
            carburantRestant = 0;
            return null;
        }
    }

    public void revenirArriere() {
        if(!(journalDeBord.size() <= 1)){
            SystemePlanetaire planeteRevenu = journalDeBord.pop();
            carburantRestant += planeteRevenu.getFuelrequis();
            for (int i = 7; i > -1; i--) {
                if (inventaire[i] != null){
                    inventaire[i] = null;
                    break;
                }
            }
            planeteCourante = journalDeBord.peek();
            System.out.println("Annulation du voyage en cours...");
            System.out.println("Vous etes de retour sur : " + planeteCourante.name());
            System.out.println();
        }
        else if (journalDeBord.size() == 1){
            SystemePlanetaire planeteRevenu = journalDeBord.pop();
            carburantRestant += planeteRevenu.getFuelrequis();
            for (int i = 7; i > -1; i--) {
                if (inventaire[i] != null){
                    inventaire[i] = null;
                    break;
                }
            }
            planeteCourante = null;
            System.out.println("Annulation du voyage en cours...");
            System.out.println("Vous etes de retour sur : Terre" );
            System.out.println();
        }
        else{
            planeteCourante = null;
            System.out.println("Annulation du voyage en cours...");
            System.out.println("Vous etes de retour sur : Terre" );
            System.out.println();
        }
    }
    public boolean estMort(){
        return 0 >= pointDeVie || 0 >= carburantRestant;
    }

    public void ajouterObjet(Item objet){
        for (int i = 0; i < 8; i++) {
            if (inventaire[i] == null){
                inventaire[i] = objet;
                break;
            }
        }
    }
    public void enleverObjet(int rang){
        for (int i = rang; i < 8; i++) {
            inventaire[i] = null;
            if(i != 7) {
                if (inventaire[i + 1] != null) {
                    inventaire[i] = inventaire[i + 1];
                    inventaire[i + 1] = null;
                }
            }
        }
    }

    public String toStringInventaire(){
        String str = "";
        for (int i = 0; i < 8; i++){
            if (inventaire[i] != null)
                str += inventaire[i].getNom() + " , ";

        }
        return str;
    }

    public void afficherInventaire(){
        System.out.println("Quel objet voulez-vous utiliser ?");
        for (int i = 0; i < 8; i++){
            if (inventaire[i] != null)
                System.out.println((1 + i) + ". " + inventaire[i].getNom());

        }

    }

    public int getPointDeVie() {
        return pointDeVie;
    }

    public void setPointDeVie(int pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    public int getCarburantRestant() {
        return carburantRestant;
    }

    public void setCarburantRestant(int carburantRestant) {
        this.carburantRestant = carburantRestant;
    }

    public Item[] getInventaire() {
        return inventaire;
    }



    public Stack<SystemePlanetaire> getJournalDeBord() {
        return journalDeBord;
    }

}
