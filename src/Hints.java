package src;

import java.util.ArrayList;

public class Hints {
    //  Liste d'indices
    private ArrayList<Hint> hints;

    public Hints() {
        this.hints = new ArrayList<Hint>();
    }

    //  Accesseur en lecture permettant de récupérer la taille de l'attribut hints
    public byte getSize() {
        return (byte)this.hints.size();
    }

    //  Accesseur en lecture permettant de récupérer l'indice d'index i
    public Hint getHint(byte i) {
        return this.hints.get(i);
    }

    //  Accesseur en lecture permettant d'ajouter un indice
    public void addHint(Hint hint) {
        this.hints.add(hint);
    }

    //  Cette méthode permet d'initialiser hints avec n indices uniques entre 1 et max
    public void initHints(byte n) {
        byte randomIndex;
        boolean addedHints[];

        addedHints = new boolean[Parameters.NBHINTS];
        for (--n; n >= 0; n--) {
            do {
                randomIndex = (byte)(Math.random() * Parameters.NBHINTS);
            } while (addedHints[randomIndex]);
            this.addHint(Parameters.GAMEHINTS[randomIndex]);
            addedHints[randomIndex] = true;
        }
    }

    @Override
    public String toString() {
        byte i;
        byte size;
        String str = "";

        //  Évite de faire appel à .size à chaque tour de boucle
        size = (byte)this.hints.size();
        for (i = 0; i < size; i++) {
            str += this.hints.get(i);
            str += i < size - 1 ? ", " : "";
        }
        return "[" + str + "]\n";
    }
}
