package src;

public class Difference extends Hint {
    public Difference() {
        //  Appel du constructeur de la classe Hint
        super('-', "Difference");
    }

    //  Définition de la méthode getResult() qui retourne le résltat de deux cellules
    public int getResult(Cell cell1, Cell cell2) {
        return (int)(cell1.getValue() - cell2.getValue());
    }
}