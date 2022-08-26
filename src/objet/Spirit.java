package objet;

import vaisseau.Vaisseau;

public class Spirit implements Item{
    public String nom;
    public Spirit(){
        this.nom = "Spirit";
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void utiliser(Vaisseau vaisseau) {
        System.out.println("Vous utilisez les pièces détachées du pauvre petit Spirit pour réparer votre vaisseau. Comment osez-vous ?!?");
        System.out.println("Vous regagnez 20 points de vie.");
        vaisseau.setPointDeVie(Math.min(100, vaisseau.getPointDeVie() + 30));
    }
}
