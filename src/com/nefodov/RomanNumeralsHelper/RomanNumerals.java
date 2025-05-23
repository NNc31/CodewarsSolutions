package com.nefodov.RomanNumeralsHelper;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {

    public static String toRoman(int n) {
        StringBuilder romanStr = new StringBuilder();
        int m = 1, i;
        while (n != 0) {
            i = n % 10;
            if (m == 1) {
                romanStr.append(transformDecade(i, "I", "V", "X"));
            } else if (m == 10) {
                romanStr.append(transformDecade(i, "X", "L", "C"));
            } else if (m == 100) {
                romanStr.append(transformDecade(i, "C", "D", "M"));
            } else {
                romanStr.append(transformDecade(i, "M", "M", "M"));
            }
            n /= 10;
            m *= 10;
        }
        return romanStr.reverse().toString();
    }

    private static String transformDecade(int i, String a, String b, String c) {
        if (i == 0) {
            return "";
        } else if (i == 1) {
            return a;
        } else if (i == 2) {
            return a + a;
        } else if (i == 3) {
            return a + a + a;
        } else if (i == 4) {
            return b + a;
        } else if (i == 5) {
            return b;
        } else if (i == 6) {
            return a + b;
        } else if (i == 7) {
            return a + a + b;
        } else if (i == 8) {
            return a + a + a + b;
        } else {
            return c + a;
        }
    }

    public static int fromRoman(String romanNumeral) {
        int romanNum = 0;
        int previousNum = 0;
        int currentNum;

        Map<Character, Integer> dictionary = new HashMap<>();
        dictionary.put('I', 1);
        dictionary.put('V', 5);
        dictionary.put('X', 10);
        dictionary.put('L', 50);
        dictionary.put('C', 100);
        dictionary.put('D', 500);
        dictionary.put('M', 1000);
        for (int i = 0; i < romanNumeral.length(); i++) {
            char c = romanNumeral.charAt(i);
            currentNum = dictionary.get(c);
            if (currentNum <= previousNum) {
                romanNum += currentNum;
            } else {
                romanNum += (currentNum - previousNum * 2);
            }
            previousNum = currentNum;
        }
        return romanNum;
    }
}