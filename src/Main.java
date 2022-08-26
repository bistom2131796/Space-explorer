import interaction.Interaction;
import vaisseau.Vaisseau;

public class Main {
    public static void main(String[] args) {
        Vaisseau vaisseau = new Vaisseau();
        System.out.println(" ______     ______   ______     ______     ______           ______     __  __     ______   __         ______     ______     ______     ______    \n" +
                "/\\  ___\\   /\\  == \\ /\\  __ \\   /\\  ___\\   /\\  ___\\         /\\  ___\\   /\\_\\_\\_\\   /\\  == \\ /\\ \\       /\\  __ \\   /\\  == \\   /\\  ___\\   /\\  == \\   \n" +
                "\\ \\___  \\  \\ \\  _-/ \\ \\  __ \\  \\ \\ \\____  \\ \\  __\\         \\ \\  __\\   \\/_/\\_\\/_  \\ \\  _-/ \\ \\ \\____  \\ \\ \\/\\ \\  \\ \\  __<   \\ \\  __\\   \\ \\  __<   \n" +
                " \\/\\_____\\  \\ \\_\\    \\ \\_\\ \\_\\  \\ \\_____\\  \\ \\_____\\        \\ \\_____\\   /\\_\\/\\_\\  \\ \\_\\    \\ \\_____\\  \\ \\_____\\  \\ \\_\\ \\_\\  \\ \\_____\\  \\ \\_\\ \\_\\ \n" +
                "  \\/_____/   \\/_/     \\/_/\\/_/   \\/_____/   \\/_____/         \\/_____/   \\/_/\\/_/   \\/_/     \\/_____/   \\/_____/   \\/_/ /_/   \\/_____/   \\/_/ /_/ \n" +
                "                                                                                                                                                 ");


        System.out.println("Bienvenue sur Space explorer.\n" +
                " Votre mission est de explorer chaque planete du systeme connu sans y laisser votre vie.\n" +
                " En serez-vous capable?");
        System.out.println();

        while (!vaisseau.estMort()){
            Interaction.menu(vaisseau);
        }


    }
}
