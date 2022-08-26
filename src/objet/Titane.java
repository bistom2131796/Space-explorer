package objet;

import vaisseau.Vaisseau;

public class Titane implements Item {
    public String nom;
    public Titane(){
        this.nom = "Titane";
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void utiliser(Vaisseau vaisseau) {
        System.out.println("Vous revêtissez une couche de titane sur les parties endommagé de votre vaisseau.");
        System.out.println("Vous regagnez 10 points de vie.");
        vaisseau.setPointDeVie(Math.min(100, vaisseau.getPointDeVie() + 10));
    }
}
