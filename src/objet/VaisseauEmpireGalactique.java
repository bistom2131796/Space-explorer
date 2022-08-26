package objet;

import vaisseau.Vaisseau;

public class VaisseauEmpireGalactique implements Item {
    public String nom;
    public VaisseauEmpireGalactique(){
        this.nom = "Vaisseau de l'Empire Galactique";
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void utiliser(Vaisseau vaisseau) {
        System.out.println("Lorsque vous arrivez sur Trantor l'empreur Cléon I vous offre un tout nouveau vaisseau.");
        System.out.println("Vous regagnez toutes vos statistiques.");
        vaisseau.setCarburantRestant(1000);
        vaisseau.setPointDeVie(100);
    }
}
