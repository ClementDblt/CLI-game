package src;

public class Player {
    //  Pseudo du joueur
    private String pseudo;
    //  Score du joueur
    private int score;
    //  Est-ce que le joueur a gagné le tour ?
    private boolean turnWin;
    //  Première cellule sélectionnée par le joueur
    private Cell cell1;
    //  Seconde cellule sélectionnée par le joueur
    private Cell cell2;

    public Player(String pseudo) {
        this.pseudo = pseudo;
        //  Par défaut le joueur à un score de 0, il n'a gagné aucun tour et n'a sélectionné aucune cellule
        this.score = 0;
        this.turnWin = false;
        this.cell1 = null;
        this.cell2 = null;
    }

    //  Accesseur en lecture permettant de récupérer le pseudo du joueur
    public String getPseudo() {
        return this.pseudo;
    }

    //  Réinitialise les attributs de l'instance aux valeurs par défaut
    public void reset() {
        this.score = 0;
        this.turnWin = false;
        this.cell1 = null;
        this.cell2 = null;
    }

    @Override
    public String toString() {
        return this.pseudo + " : " + this.score;
    }

    //  Méthode permettant au joueur de jouer un tour
    public void play(Grid grid) {
        boolean input;
        short cell1Guess;
        short cell2Guess;

        input = false;
        cell1Guess = -1;
        cell2Guess = -1;
        System.out.println("Au tour de : " + this.getPseudo());
        if (this.cell1 != null && this.cell2 != null) {
            if (!this.turnWin && !this.cell1.getDiscovered() && !this.cell2.getDiscovered()) {
                System.out.print("Rejouer les memes cases qu'au tour precedent (o/n) : ");
                input = Input.yesNo();
            }
        }
        if (!input) {
            this.cell1 = Input.cell("Choix de la premiere case", grid, null);
            this.cell2 = Input.cell("Choix de la seconde case", grid, this.cell1);
        }
        Output.indices(this.cell1, this.cell2);
        System.out.print("Faire une hypothese (o/n) : ");
        if (input = Input.yesNo()) {
            System.out.println("Valeur de la case 1 : ");
            cell1Guess = Input.interval(">> ", 0, Parameters.maxCellsValue);
            System.out.println("Valeur de la case 2 : ");
            cell2Guess = Input.interval(">> ", 0, Parameters.maxCellsValue);
        }
        if (cell1Guess == this.cell1.getValue() && cell2Guess == this.cell2.getValue())
            this.win();
        else
            this.loose();
    }

    //  Éxecute les actions nécessaires lorsque le joueur gagne un tour
    private void win() {
        System.out.println("\nBravo ! Le contenu des cases a ete trouve\n");
        this.cell1.setDiscovered(true);
        this.cell2.setDiscovered(true);
        this.turnWin = true;
        this.score += this.cell1.getValue() + this.cell2.getValue();
    }

    //  Éxecute les actions nécessaires lorsque le joueur perd un tour
    private void loose() {
        System.out.println("\nAu moins une des hypotheses est fausse !\n");
        this.turnWin = false;
    }

}
