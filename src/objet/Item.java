package objet;

import vaisseau.Vaisseau;

public interface Item {
    void utiliser(Vaisseau vaisseau);
    String getNom();
}
