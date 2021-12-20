package src;

public class Product extends Hint {
    public Product() {
        //  Appel du constructeur de la classe Hint
        super('x', "Produit");
    }

    //  Définition de la méthode getResult() qui retourne le résltat de deux cellules
    public int getResult(Cell cell1, Cell cell2) {
        return cell1.getValue() * cell2.getValue();
    }
}
