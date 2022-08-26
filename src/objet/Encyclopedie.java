package objet;

import vaisseau.Vaisseau;

public class Encyclopedie implements Item{
    public String nom;
    public Encyclopedie(){
        this.nom = "Encyclopédie";
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void utiliser(Vaisseau vaisseau) {
        System.out.println("Grâce aux enseignements millénaires de l'encyclopédie vous réussissez à réparer votre vaisseau.");
        System.out.println("Vous regagnez 25 points de vie.");
        vaisseau.setPointDeVie(Math.min(100, vaisseau.getPointDeVie() + 25));
    }
}
