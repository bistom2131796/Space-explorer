package objet;

import vaisseau.Vaisseau;

public class Beskar implements Item{
    public String nom;
    public Beskar(){
        this.nom = "Beskar";
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void utiliser(Vaisseau vaisseau) {
        System.out.println("Vous revêtissez une couche de Beskar sur les parties endommagé de votre vaisseau.");
        System.out.println("Vous regagnez 30 points de vie.");
        vaisseau.setPointDeVie(Math.min(100, vaisseau.getPointDeVie() + 30));
    }
}
