package ru.netoogy;

import static ru.netoogy.Main.*;

public class CompareMethods {

    public static boolean isPalindrom(String strings) {
        int i1 = 0;
        int i2 = strings.length() - 1;
        while (i2 > i1) {
            if (strings.charAt(i1) != strings.charAt(i2)) {
                return false;
            }
            i1++;
            i2--;
        }
        return true;
    }

    public static boolean CompareIdentical(String strings) {
        for (int i = 1; i <= strings.length() - 1; i++) {
            if (strings.charAt(0) != strings.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean CompareNaturalOrder(String strings) {
        for (int i = 0; i < strings.length() - 1; i++) {
            if (strings.charAt(i) > strings.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void incrementValue(int string) {
        switch (string) {
            case 3:
                lengthThree.incrementAndGet();
                break;
            case 4:
                lengthFour.incrementAndGet();
                break;
            case 5:
                lengthFive.incrementAndGet();
                break;
        }
    }
}
