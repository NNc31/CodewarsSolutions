package com.nefodov.RailFenceCipherEncodingAndDecoding;

public class RailFenceCipher {
    static String encode(String s, int n) {
        char[][] rails = new char[n][s.length()];
        //set spaces for all elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < s.length(); j++){
                rails[i][j] = '\'';
            }
        }

        //build rails
        for (int i = 0, j = 0, k = -1; i < s.length(); i++, j += k) {
            if (j == 0 || j == n - 1) {
                k *= -1;
            }
            rails[j][i] = s.charAt(i);
        }

        //collect lines
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (rails[i][j] != '\'') sb.append(rails[i][j]);
            }
        }
        return sb.toString();
    }

    static String decode(String s, int n) {
        char[][] rails = new char[n][s.length()];
        //set spaces for all elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < s.length(); j++){
                rails[i][j] = '\'';
            }
        }

        //mark rails
        for (int i = 0, j = 0, k = -1; i < s.length(); i++, j += k) {
            if (j == 0 || j == n - 1) {
                k *= -1;
            }
            rails[j][i] = '*';
        }

        //set chars on positions
        for (int i = 0, k = 0; i < n; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (rails[i][j] == '*') {
                    rails[i][j] = s.charAt(k);
                    k++;
                }
            }
        }

        //collect rails
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0, k = -1; i < s.length(); i++, j += k) {
            if (j == 0 || j == n - 1) {
                k *= -1;
            }
            sb.append(rails[j][i]);
        }
        return sb.toString();
    }
}
