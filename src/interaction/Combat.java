package interaction;

import vaisseau.Vaisseau;

import java.security.PrivateKey;
import java.util.Scanner;

public class Combat {
    public static void combattre(Vaisseau vaisseau, Pirate pirate, Scanner sc){
        System.out.println("Vous etes attaque par une bande pirate.");

        while(!(pirate.estMort() || vaisseau.estMort())){
            System.out.println("Que faites-vous?");
            System.out.println("   1- Attaquer");
            System.out.println("   2- Se defendre");
            pirate.action();
            int choix = sc.nextInt();
            switch (choix){
                case 1:
                    if(pirate.isDefendre()){
                        System.out.println("Les pirates bloquent toute tentative d'attaque.");
                    }

                    else{
                        vaisseau.setPointDeVie(vaisseau.getPointDeVie() - pirate.attaquer());
                        System.out.println("Vous recevez " + pirate.getDegat() + " points de degat.");
                        int degat = (int)(Math.random() * 20 ) + 5;
                        pirate.prendreDegat(degat);
                        System.out.println("Vous avez infligez " + degat + " points de degat aux pirates.");
                    }
                    break;

                case 2:
                    if(pirate.isDefendre()){
                        System.out.println("Vous vous bloques tous les deux c'est genant...");
                    }

                    else{
                        System.out.println("Vous bloquez les attaques pirates");
                        System.out.println();
                    }
                    break;

                default:
                    System.out.println("Ceci n'est pas une option valide.");
                    System.out.println();
                    break;
            }

        }

        if(pirate.estMort()){
            System.out.println("Vous avez vaincu les pirates.");
        }

        if(vaisseau.estMort()){
            System.out.println("Vous avez péri dans l'attaque.");
        }

    }
}

class Pirate{
    private int  pointDeVie;
    private int degat;

    private boolean defendre;

    public Pirate() {
        pointDeVie = (int)(Math.random() * 30) + 1;
        degat = (int)(Math.random() * 15) + 1;
        defendre = false;
    }

    public void action(){
        switch ((int)(Math.random() * 2) + 1){
            case 1:
                defendre = true;
                break;
            case 2:
                defendre = false;
                break;

        }
    }

    public int attaquer(){
        return degat;
    }

    public void prendreDegat(int dommage){
        pointDeVie -= dommage;
    }

    public boolean estMort(){
        return pointDeVie <= 0;
    }

    public int getPointDeVie() {
        return pointDeVie;
    }

    public void setPointDeVie(int pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    public int getDegat() {
        return degat;
    }

    public void setDegat(int degat) {
        this.degat = degat;
    }

    public boolean isDefendre() {
        return defendre;
    }

    public void setDefendre(boolean defendre) {
        this.defendre = defendre;
    }
}
