package src;

public class Sum extends Hint {
    public Sum() {
        //  Appel du constructeur de la classe Hint
        super('+', "Somme");
    }

    //  Définition de la méthode getResult() qui retourne le résltat de deux cellules
    public int getResult(Cell cell1, Cell cell2) {
        return cell1.getValue() + cell2.getValue();
    }
}
