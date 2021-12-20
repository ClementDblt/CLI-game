package src;

public class Tools {
    //  Retourne le nombre de chiffres d'un nombre
    public static byte getNbDigits(short value) {
        if (value > 99)
            return 3;
        else if (value > 9)
            return 2;
        return 1;
    }

    //  Convertion d'un nombre en caractère ascii
    public static char byteToChar(byte value) {
        return (char)(value + 65);
    }

    //  Convertion d'un caractère ascii en nombre
    public static byte charToByte(char c) {
        return (byte)(c - 65);
    }

    //  Création d'une chaine de caractères de n caractères
    public static String nCharToString(int n, char c) {
        String str;
        int i;

        str = "";
        for (i = 0; i < n; i++)
            str += c;
        return str;
    }

    //  Mélange d'un tableau à une dimension
    public static Cell[] shuffle(Cell[] array) {
        Cell tmp;
        byte i;
        byte j;

        for (i = 0; i < array.length; i++) {
            do {
                j = (byte)(Math.random() * array.length);
            } while(j == i);
            tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
        return array;
    }
}
