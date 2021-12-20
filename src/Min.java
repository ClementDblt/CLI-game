package src;

public class Min extends Hint {
    public Min() {
        //  Appel du constructeur de la classe Hint
        super('m', "Min");
    }

    //  Définition de la méthode getResult() qui retourne le résltat de deux cellules
    public int getResult(Cell cell1, Cell cell2) {
        return (int)(Math.min(cell1.getValue(), cell2.getValue()));
    }
}
