package src;

public class Output {
    //  Retourne la liste de sélection des indices existants dans le jeu
    public static void hintsSelection() {
        byte i;

        for (i = 0; i < Parameters.NBHINTS; i++) {
            System.out.println(i + " : " + Parameters.GAMEHINTS[i].getName());
        }
    }

    //  Affichage des indices liés aux cases sélectionnées par le joueur
    public static void indices(Cell cell1, Cell cell2) {
        System.out.println("Indice case 1 : " + cell1.getHint().getResult(cell1, cell2));
        System.out.println("Indice case 2 : " + cell2.getHint().getResult(cell2, cell1));
    }
}
