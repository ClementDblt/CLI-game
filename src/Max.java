package src;

public class Max extends Hint {
    public Max() {
        //  Appel du constructeur de la classe Hint
        super('M', "Max");
    }

    //  Définition de la méthode getResult() qui retourne le résltat de deux cellules
    public int getResult(Cell cell1, Cell cell2) {
        return (int)(Math.max(cell1.getValue(), cell2.getValue()));
    }
}
