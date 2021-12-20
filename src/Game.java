package src;

public class Game {
    //  Grille de jeu
    private Grid grid;
    //  Liste des joueurs en jeu
    private Players players;
    //  Joueur qui est en train de jouer
    private Player currentPlayer;

    public Game() {
        this.players = new Players();
        this.currentPlayer = null;
        this.grid = null;
    }

    //  Accesseur en lecture permettant de récupérer la grille de jeu
    public Grid getGrid() {
        return this.grid;
    }

    //  Accesseur en lecture permettant de récupérer la liste des joueurs
    public Players getPlayers() {
        return this.players;
    }

    //  Accesseur en lecture permettant de récupérer le joueur en train de jouer
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    //  Ajout d'un ou plusieurs joueurs
    public void addPlayers() {
        String pseudo;
        boolean add;

        System.out.println("Qui sont les joueurs ?");
        do {
            do {
                System.out.print("Nom du joueur : ");
                pseudo = Read.S();
            } while (this.players.existingPlayer(pseudo));
            this.players.addPlayer(new Player(pseudo));
            System.out.print("Joueur supplementaire (o/n) : ");
            add = Input.yesNo();
        } while (add);
    }

    //  Suppression d'un ou plusieurs joueurs
    public void removePlayers() {
        String pseudo;
        boolean remove;

        remove = false;
        System.out.println("Quels joueurs doivent etre supprimes ?");
        do {
            do {
                System.out.print("nom du joueur : ");
                pseudo = Read.S();
            } while (!this.players.existingPlayer(pseudo));
            this.players.removePlayer(pseudo);
            if (this.players.getSize() != 0) {
                System.out.print("Supprimer un autre joueur (o/n) : ");
                remove = Input.yesNo();
            }
        } while (this.players.getSize() != 0 && remove);
    }

    @Override
    public String toString() {
        return  "#### Caracteristiques du jeu ####\n" + 
                Tools.nCharToString(33, '-') + "\n" +
                this.players +
                Tools.nCharToString(33, '-') + "\n" +
                "Indices : " + Parameters.hints +
                "Valeur maximale : " + Parameters.maxCellsValue
                + "\n";
    }

    //  Méthode de jeu
    public void play() {
        byte i;
        byte input;

        //  Sélection aléatoire d'un index dans players et initialisation de la grille de jeu
        i = (byte)(Math.random() * this.players.getSize());
        this.grid = new Grid(); // this.setGrid();
        while (!this.grid.isFull()) {
            this.currentPlayer = this.players.getPlayer(i);
            System.out.println(this);
            System.out.println(this.grid);
            this.currentPlayer.play(this.grid);
            //  On passe au joueur suivant
            i = this.players.getSize() > 1 && i < this.players.getSize() - 1 ? (byte)(i + 1) : 0;
        }
        //  Affichage des joueurs, des scores et de la grille de jeu à la fin de la partie
        System.out.println( Tools.nCharToString(33, '-') + "\n" + 
                            this.players + 
                            Tools.nCharToString(33, '-') + "\n" +
                            this.grid);
        //  Options de fin de partie
        do {
            System.out.println("0 : Rejouer\n1 : Ajouter un ou des joueurs\n2 : Supprimer un ou des joueurs\n3 : Configurer le jeu\n4 : Quitter");
            input = (byte)Input.interval(">> ", 0, 4);
            switch(input) {
                case 0:
                    if (this.players.getSize() == 0) {
                        System.out.println("Vous devez ajouter au moins un joueur pour jouer");
                        input = -1;
                    }
                    break;
                case 1:
                    this.addPlayers();
                    break;
                case 2:
                    if (this.players.getSize() != 0)
                        this.removePlayers();
                    else
                        System.out.println("Aucun joueur a supprimer dans la liste !");
                    break;
                case 3:
                    Parameters.hints = new Hints();
                    Parameters.configure();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        } while (input != 0);
        //  Reset des joueurs avant de lancer la nouvelle partie
        this.players.reset();
        this.play();
    }
}
