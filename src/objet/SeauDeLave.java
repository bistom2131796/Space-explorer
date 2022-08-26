package objet;

import vaisseau.Vaisseau;

public class SeauDeLave implements Item{
    public String nom;
    public SeauDeLave(){
        this.nom = "Seau de lave";
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void utiliser(Vaisseau vaisseau) {
        System.out.println("Surprenament vous réussissez à produire d'avantage de carburant avec un seau...");
        System.out.println("Vous regagnez 150 Litres de carburants.");
        vaisseau.setCarburantRestant(Math.min(1000, vaisseau.getCarburantRestant() + 150));
    }
}
