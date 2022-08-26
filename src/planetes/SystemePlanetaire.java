package planetes;

import objet.*;
import vaisseau.Vaisseau;

public enum SystemePlanetaire implements Planete {
    ARRAKIS(250, new Epice() ),
    HOTT(300, new Glace()),
    REACH(250, new Titane()),
    MARS(50, new Spirit()),
    MUSTAFAR(350,new SeauDeLave()),
    //ENDOR(200,),
    MANDALOR(200, new Beskar()),
    TRANTOR(300, new VaisseauEmpireGalactique()),
    TERMINUS(500, new Encyclopedie());

    private int fuelrequis;
    private Item objet;

    SystemePlanetaire(int fuelrequis, Item objet) {
        this.fuelrequis = fuelrequis;
        this.objet = objet;

    }

    public int getFuelrequis() {
        return fuelrequis;
    }

    @Override

    public void explorer(Vaisseau vaisseau) {
            System.out.println("Vous avez dépenser " + fuelrequis + " litres");
            vaisseau.setCarburantRestant(vaisseau.getCarburantRestant() - fuelrequis);
            vaisseau.ajouterObjet(objet);
            System.out.println("Vous avez obtenu : " + objet.getNom());
            System.out.println();
            /*if((Math.random() * 3) < 2 ){
                int degat = (int)(Math.random() * 50);
                vaisseau.setPointDeVie(vaisseau.getPointDeVie() - degat );
                System.out.println("Vous etes attaqués par des pirates.");
                System.out.println("Vous avez subit " + degat + " point de degats.");
                System.out.println();
                if (vaisseau.estMort()){
                    System.out.println("Vous avez peri dans l'attaque.");
                }

            }*/


    }

}

