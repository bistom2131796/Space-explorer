package objet;

import vaisseau.Vaisseau;

public class Epice implements Item {
    public String nom;
    public Epice(){
        this.nom = "Épice";
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void utiliser(Vaisseau vaisseau) {
        System.out.println("Vous utilisez le pouvoir légendaire de l'épice afin de pouvoir produire du carburant.");
        System.out.println("Vous regagnez 300 Litres de carburants.");
        vaisseau.setCarburantRestant(Math.min(1000, vaisseau.getCarburantRestant() + 300));
    }
}
