package objet;

import vaisseau.Vaisseau;

public class Glace implements Item{
    public String nom;
    public Glace(){
        this.nom = "Glace";
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void utiliser(Vaisseau vaisseau) {
        System.out.println("Vous utilisez de la glace de qualité supérieur pour produire du carburant.");
        System.out.println("Vous regagnez 150 Litres de carburants.");
        vaisseau.setCarburantRestant(Math.min(1000, vaisseau.getCarburantRestant() + 150));

    }
}
