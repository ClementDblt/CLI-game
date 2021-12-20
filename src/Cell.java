package src;

public class Cell {
    //  Valeur de la cellule
    private short value;
    //  Indice de la cellule
    private Hint hint;
    //  Est-ce que la cellule est découverte ou non ?
    private boolean discovered;

    public Cell(Hint hint) {
        this.setValue();
        this.hint = hint;
        this.discovered = false;
    }

    //  Accesseur en écriture qui génère aléatoirement la valeur de la cellule entre 0 et maxCellsValue
    private void setValue() {
        this.value = (short)(Math.random() * (Parameters.maxCellsValue + 1));
    }

    //  Accesseur en lecture qui permet de récupérer la valeur de la cellule
    public short getValue() {
        return this.value;
    }

    //  Accesseur en lecture qui permet de récupérer l'indice de la cellule
    public Hint getHint() {
        return this.hint;
    }

    //  Accesseur en écriture qui permet de modifier le fait que la cellule est découverte ou non
    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    //  Accesseur en lecture qui permet de récupérer la valeur de discovered
    public boolean getDiscovered() {
        return this.discovered;
    }

    @Override
    public String toString() {
        String str;

        if (this.discovered)
            return this.value + this.hint.toString();
        str = "";
        for (byte i = 0; i < Tools.getNbDigits(this.value); i++)
            str += "#";
        return Parameters.showHint ? str + this.hint.toString() : str + "#";
    }

    public boolean equals(Cell cell) {
        return super.equals(cell) && this.value == cell.getValue() && this.hint.equals(cell.getHint());
    }
}