package src;

public class Input {
    //  Sélection d'une cellule (par exemple la premère cellule de la grille est la cellule "AA" en respectant la casse !!)
    public static Cell cell(String str, Grid grid, Cell cell) {
        String input;
        byte i;
        byte j;

        //  Sélection de la cellule tant que celle sélectionnée est déjà découverte
        do {
            System.out.println(str);
            //  Sélection des index tant que la cellule sélectionnée est égale à la cellule sélectionnée précédement
            //  (dans le cas ou le joueur est en train de sélectionner la seconde cellule)
            do {
                //  Initialisation de i et j à des index inexistants et affichage de l'interval d'index
                i = -1;
                j = -1;
                System.out.println("Emplacement de la case [AA ; " + 
                                    Tools.byteToChar((byte)(grid.getRows() - 1)) +
                                    Tools.byteToChar((byte)(grid.getCols() - 1)) +
                                    "]");
                //  On demande à l'utilisateur de saisir les index tant que ceux-ci ne sont pas corrects 
                do {
                    System.out.print(">> ");
                    input = Read.S();
                    if (input.length() == 2) {
                        i = Tools.charToByte(input.charAt(0));
                        j = Tools.charToByte(input.charAt(1));
                    }
                } while(input.length() != 2 || i < 0 || i > grid.getRows() - 1 || j < 0 || j > grid.getCols() - 1);
            } while(cell != null && grid.getCell(i, j).equals(cell));
        } while(grid.getCell(i, j).getDiscovered());
        return grid.getCell(i, j);
    }

    //  Retourne true si l'utilisateur entre 'o' ou 'O' sinon false
    public static boolean yesNo() {
        char input;

        input = Read.c();
        return input == 'o' || input == 'O';
    }

    //  Retourne un nombre saisi par l'utilisateur dans l'interval [min ; max]
    public static short interval(String str, int min, int max) {
        short input;

        do {
            System.out.print(str);
            input = Read.s();
        } while(input < min || input > max);
        return input;
    }
}