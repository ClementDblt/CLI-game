package src;

public class Parameters {
    //  Indices existants dans le jeu
    public static final Hint[] GAMEHINTS = {new Sum(), new Difference(), new Product(), new Min(), new Max()};
    //  Nombre d'indices existants
    public static final byte NBHINTS = (byte)GAMEHINTS.length;
    //  Liste d'indices disponibles en jeu
    public static Hints hints = new Hints();
    //  Valeur maximale d'une cellule
    public static short maxCellsValue;
    //  Nombre de cellules
    public static byte nbCells;
    //  Est-ce que les incices sont visibles ?
    public static boolean showHint;

    //  Configuration du jeu
    public static void configure() {
        configureMaxCellsValue();
        configureNbCells();
        configureHints();
        configureShowHint();
    }

    //  Configuration de la valeur maximale d'une cellule
    private static void configureMaxCellsValue() {
        maxCellsValue = Input.interval("Valeur maximum d'une case [9 ; 999] : ", 9, 999);
    }

    //  Configuration du nombre de cellules
    private static void configureNbCells() {
        do {
            nbCells = (byte)Input.interval("Nombre pair de cases [2 ; 100] : ", 2, 100);
        } while (nbCells % 2 != 0);
    }

    //  Configuration des indices disponibles en jeu
    private static void configureHints() {
        //  Tableau correspondant aux indices déjà ajoutés
        boolean addedHints[];
        byte input;
        boolean condition;
        boolean add;

        System.out.print("Choisir les indices (o/n) : ");
        //  Initialisation de addedHints
        addedHints = new boolean[NBHINTS];
        if (Input.yesNo()) {
            //  Sélection des indices par l'utilisateur
            add = false;
            Output.hintsSelection();
            do {
                do {
                    input = (byte)Input.interval(">> ", 0, NBHINTS - 1);
                } while (addedHints[input]);
                hints.addHint(GAMEHINTS[input]);
                addedHints[input] = true;
                condition = hints.getSize() < NBHINTS && hints.getSize() < nbCells;
                if (condition) {
                    System.out.print("Indice supplementaire (o/n) : ");
                    add = Input.yesNo();
                }
            } while (add && condition);
        }
        else {
            //  Génération automatique de n indices
            if (nbCells <= NBHINTS)
                input = (byte)nbCells;
            else
                input = NBHINTS;
            System.out.println("Nombre d'indices a generer [1 ; " + input + "] : ");
            hints.initHints((byte)Input.interval(">> ", 1, input));
        }
    }

    //  Configuration de la visibilité des indices
    private static void configureShowHint() {
        System.out.print("Afficher les indices (o/n) : ");
        showHint = Input.yesNo();
    }
}
