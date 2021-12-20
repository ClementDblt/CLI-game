package src;

public abstract class Hint {
    //  Type de l'indice
    private char type;
    //  Nom de l'indice
    private String name;

    public Hint(char type, String name) {
        this.type = type;
        this.name = name;
    }

    //  Accesseur en lecture permettant de récupérer le type de l'indice
    public char getType() {
        return this.type;
    }

    //  Accesseur en lecture permettant de récupérer le type de l'indice
    public String getName() {
        return this.name;
    }

    //  Méthode abstraite définie dans les classes Difference, Max, Min, Product et Sum
    public abstract int getResult(Cell cell1, Cell cell2);

    @Override
    public String toString() {
        return this.type + "";
    }

    public boolean equals(Hint hint) {
        return this.type == hint.getType();
    }
}
