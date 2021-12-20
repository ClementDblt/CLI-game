package src;

public class Grid {
    //  Nombre de lignes de la grille
    private byte rows;
    //  Nombre de colonnes de la grille
    private byte cols;
    //  Cellules contenues par la grille
    private Cell[][] cells;

    public Grid() {
        this.setRows();
        this.setCols();
        this.initCells();
    }

    //  Accesseur en écriture qui génère le nombre de lignes de la grille en fonction du nombre cellules
    private void setRows() {
        byte rows;

        rows = (byte)(Math.sqrt((double)Parameters.nbCells) + 1);
        while (Parameters.nbCells % rows != 0) {
            rows--;
        }
        this.rows = rows;
    }

    //  Accesseur en lecture qui permet de récupérer le nombre de lignes de la grille
    public byte getRows() {
        return this.rows;
    }

    //  Accesseur en écriture qui génère le nombre de colonnes de la grille en fonction de sn nombre de lignes
    public void setCols() {
        this.cols = (byte)(Parameters.nbCells / this.rows);
    }

    //  Accesseur en lecture qui permet de récupérer le nombre de colonnes de la grille
    public byte getCols() {
        return this.cols;
    }

    //  Accesseur en lecture qui permet de récupérer les cellules contenues par la grille
    public Cell getCell(byte i, byte j) {
        return this.cells[i][j];
    }

    //  Méthode d'initialisation des cellules
    public void initCells() {
        Cell tmp[];
        byte i;
        byte j;

        this.cells = new Cell[this.rows][this.cols];
        tmp = new Cell[Parameters.nbCells];
        j = 0;
        //  On remplit tmp en alternant les indices à chaque index
        for (i = 0; i < Parameters.nbCells; i++) {
            tmp[i] = new Cell(Parameters.hints.getHint(j));
            j++;
            if (j == Parameters.hints.getSize())
                j = 0;
        }
        //  Mélange de tmp
        Tools.shuffle(tmp);
        //  Recopie de tmp dans cells
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.cols; j++) {
                cells[i][j] = tmp[j + i * this.cols];
            }
        }
    }

    @Override
    public String toString() {
        String str;
        byte nbSpace;
        byte i;
        byte j;

        //  Génération des index supérieur
        str = "  ";
        nbSpace = Tools.getNbDigits(Parameters.maxCellsValue);
        for (i = 0; i < this.cols; i++) {
            str += Tools.byteToChar(i);
            str += Tools.nCharToString(nbSpace + 1, ' ');
        }
        str += '\n';
        for (i = 0; i < this.rows; i++) {
            //  Génération des index de gauche
            str += Tools.byteToChar(i) + " ";
            for (j = 0; j < this.cols; j++) {
                //  Contenu de la grille
                str += this.cells[i][j] + " ";
                str += Tools.nCharToString(nbSpace - Tools.getNbDigits(this.cells[i][j].getValue()), ' ');
            }
            str += '\n';
        }
        return str;
    }

    //  Retourne true si la toutes les cellules de la grilles ont été découvertes
    public boolean isFull() {
        byte i;
        byte j;

        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.cols; j++) {
                if (!this.cells[i][j].getDiscovered())
                    return false;
            }
        }
        return true;
    }
}
