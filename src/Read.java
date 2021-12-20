package src;

import java.io.IOException;

public class Read {
    public static String S() {
        String input = "";
        char c = '\0';

        try {
            while ((c = (char)System.in.read()) != '\n')
                input += c != '\r' ? c : "";
        } catch (IOException e) {
            System.out.println(e);
            System.exit(0);
        }
        return input;
    }

    public static byte b() {
        String input = S();
        byte n = 0;

        while (!isByte(input))
            input = S();
        try {
            n = Byte.parseByte(input);
        } catch (NumberFormatException e) {
            System.out.println(e);
            System.exit(0);
        }

        return n;
    }

    public static short s() {
        String input = S();
        short n = 0;

        while (!isShort(input))
            input = S();
        try {
            n = Short.parseShort(input);
        } catch (NumberFormatException e) {
            System.out.println(e);
            System.exit(0);
        }

        return n;
    }

    public static int i() {
        String input = S();
        int n = 0;

        while (!isInt(input))
            input = S();
        try {
            n = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(e);
            System.exit(0);
        }

        return n;
    }

    public static long l() {
        String input = S();
        long n = 0;

        while (!isLong(input))
            input = S();
        try {
            n = Long.parseLong(input);
        } catch (NumberFormatException e) {
            System.out.println(e);
            System.exit(0);
        }

        return n;
    }

    public static float f() {
        String input = S();
        float n = 0.0f;

        while (!isFloat(input))
            input = S();
        try {
            n = Float.parseFloat(input);
        } catch (NumberFormatException e) {
            System.out.println(e);
            System.exit(0);
        }
        return n;
    }

    public static double d() {
        String input = S();
        double n = 0.0;

        while (!isDouble(input))
            input = S();
        try {
            n = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println(e);
            System.exit(0);
        }
        return n;
    }

    public static char c() {
        String input = S();

        while (input.length() > 1 )
            input = S();
        if (input.length() == 0)
            return '\n';
        return input.charAt(0);
    }

    private static boolean isByte(String str) {
        long n;
        
        if (!isNumber(str))
            return false;
        n = strToNumber(str);
        if (n < Byte.MIN_VALUE || n > Byte.MAX_VALUE)
            return false;
        return true;
    }

    private static boolean isShort(String str) {
        long n;
        
        if (!isNumber(str))
            return false;
        n = strToNumber(str);
        if (n < Short.MIN_VALUE || n > Short.MAX_VALUE)
            return false;
        return true;
    }

    private static boolean isInt(String str) {
        long n;
        
        if (!isNumber(str))
            return false;
        n = strToNumber(str);
        if (n < Integer.MIN_VALUE || n > Integer.MAX_VALUE)
            return false;
        return true;
    }

    private static boolean isLong(String str) {
        long n;
        
        if (!isNumber(str))
            return false;
        n = strToNumber(str);
        if (n < Long.MIN_VALUE|| n > Long.MAX_VALUE)
            return false;
        return true;
    }

    private static boolean isFloat(String str) {
        float n;
        
        if (!isReal(str))
            return false;
        n = Float.parseFloat(str);
        if (str.charAt(0) == '-')
            n = -n;
        if (n < Float.MIN_VALUE || n > Float.MAX_VALUE)
            return false;
        return true;
    }

    private static boolean isDouble(String str) {
        double n;
        
        if (!isReal(str))
            return false;
        n = Double.parseDouble(str);
        if (str.charAt(0) == '-')
            n = -n;
        if (n < Double.MIN_VALUE || n > Double.MAX_VALUE)
            return false;
        return true;
    }

    private static long strToNumber(String str) {
        long n = 0;
        char c = str.charAt(0);
        int i = 0;
        boolean neg = false;

        if (operator(c)) {
            if (c == '-')
                neg = true;
            i++;
        }
        while (i < str.length()) {
            n = n * 10 + str.charAt(i) - 48;
            i++;
        }
        return neg ? -n : n;
    }

    private static boolean isNumber(String str) {
        char c;
        int i = 0;

        if (str.length() == 0)
            return false;
        c = str.charAt(0);
        if (!digit(c) && str.length() == 1)
            return false;
        if (operator(c))
            i++;
        while (i < str.length()) {
            c = str.charAt(i);
            if (!digit(c))
                return false;
            i++;
        }
        return true;
    }

    private static boolean isReal(String str) {
        String[] parts = str.split("\\.");

        if (parts.length == 0 || parts.length > 2)
            return false;
        if (parts.length == 2 && (str.charAt(str.length() - 1) == '.'))
            return false;
        if (parts.length == 1) {
            if (!isNumber(parts[0]))
                return false;
        } else {
            if (!isNumber(parts[0]) || !isNumber(parts[1]))
                return false;
        }
        return true;
    }

    private static boolean digit(char c) {
        if (c >= '0' && c <= '9')
            return true;
        return false;
    }

    private static boolean operator(char c) {
        if (c == '+' || c == '-')
            return true;
        return false;
    }
}